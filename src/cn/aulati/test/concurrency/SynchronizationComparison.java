package cn.aulati.test.concurrency;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizationComparison {
    static BaseLine base = new BaseLine();
    static SynchronizedTest sync = new SynchronizedTest();
    static LockTest lock = new LockTest();
    static AtomicTest atomic = new AtomicTest();
    static void test() {
        System.out.println("============================");
        System.out.printf("%-12s : %13d\n", "Cycles", Accumulator.cycles);
        base.timeTested();
        sync.timeTested();
        lock.timeTested();
        atomic.timeTested();
        Accumulator.report(sync, base);
        Accumulator.report(lock, base);
        Accumulator.report(atomic, base);
        Accumulator.report(sync, lock);
        Accumulator.report(sync, atomic);
        Accumulator.report(lock, atomic);
    }
}

abstract class Accumulator {
    public static long cycles = 50000L;
    
    private static final int N = 4;
    public static ExecutorService exec = Executors.newFixedThreadPool(N * 2);
    private static CyclicBarrier barrier = new CyclicBarrier(N * 2 + 1);
    
    protected volatile int index = 0;
    protected volatile long value = 0;
    protected long duration = 0;
    protected String id = "error";
    protected static final int SIZE = 100000;
    protected static int[] preloaded = new int[SIZE + 10];
    static {
        Random rand = new Random(47);
        for (int i = 0; i < SIZE + 10; i++) {
            preloaded[i] = rand.nextInt();
        }
    }
    
    public abstract void accumulate();
    public abstract long read();

    private class Modifier implements Runnable {
        @Override
        public void run() {
            for (long i = 0; i < cycles; i++) {
                accumulate();
            }

            try {
                barrier.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    private class Reader implements Runnable {
        private volatile long value;

        @Override
        public void run() {
            for (long i = 0; i < cycles; i++) {
                value = read();
            }

            try {
                barrier.await();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
    
    public void timeTested() {
        long start = System.nanoTime();
        for (int i = 0; i < N; i++) {
            exec.execute(new Modifier());
            exec.execute(new Reader());
        }

        try {
            barrier.await();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        duration = System.nanoTime() - start;
        System.out.printf("%-13s: %13d\n", id, duration);
    }

    public static void report(Accumulator acc1, Accumulator acc2) {
        System.out.printf("%-22s: %.2f\n", acc1.id + "/" + acc2.id, (double)acc1.duration / (double)acc2.duration);
    }
}

class BaseLine extends Accumulator {
    { id = "BaseLine"; }

    public void accumulate() {
        value += preloaded[index++];
        if (index >= SIZE) {
            index = 0;
        }
    }

    public long read() {
        return value;
    }
}

class SynchronizedTest extends Accumulator {
    { id = "Synchronized"; }
    
    public synchronized void accumulate() {
        value += preloaded[index++];
        if (index >= SIZE) {
            index = 0;
        }
    }

    @Override
    public synchronized long read() {
        return value;
    }
}

class LockTest extends Accumulator {
    { id = "Lock"; }
    private Lock lock = new ReentrantLock();

    public void accumulate() {
        lock.lock();
        try {
            value += preloaded[index++];
            if (index >= SIZE) {
                index = 0;
            }
        } finally {
            lock.unlock();
        }
    }
    
    public long read() {
        lock.lock();
        try {
            return value;
        } finally {
            lock.unlock();
        }
    }
}

class AtomicTest extends Accumulator {
    { id = "Atomic"; }

    private AtomicInteger index = new AtomicInteger(0);
    private AtomicLong value = new AtomicLong(0);
    public void accumulate() {
        int i = index.getAndIncrement();
        value.getAndAdd(preloaded[i]);
        if (++i >= SIZE) {
            index.set(0);
        }
    }

    public long read() {
        return value.get();
    }
}