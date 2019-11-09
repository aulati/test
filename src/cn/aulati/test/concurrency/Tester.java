package cn.aulati.test.concurrency;

import cn.aulati.test.util.Generated;
import cn.aulati.test.util.RandomGenerator;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public abstract class Tester<C> {
    static int testReps = 10;
    static int testCycles = 1000;
    static int containerSize = 1000;
    
    abstract C containerInitializer();
    abstract void startReaderAndWriters();
    
    C testContainer;
    String testId;
    int nReaders;
    int nWriters;
    volatile long readResult = 0;
    volatile long readTime = 0;
    volatile long writeTime = 0;
    
    CountDownLatch endLatch;
    static ExecutorService exec = Executors.newCachedThreadPool();
    Integer[] writeData;

    Tester(String id, int nReaders, int nWriters) {
        this.testId = id;
        this.nReaders = nReaders;
        this.nWriters = nWriters;
        writeData = Generated.array(Integer.class, new RandomGenerator.Integer(), containerSize);
        for (int i = 0; i < testReps; i++) {
            runTest();
            readTime = 0;
            writeTime = 0;
        }
        System.out.println("---------------------------------------------------------");
    }
    
    void runTest() {
        endLatch = new CountDownLatch(nReaders + nWriters);
        testContainer = containerInitializer();
        startReaderAndWriters();
        try {
            endLatch.await();
        } catch (InterruptedException e) {
            System.out.println("EndLatch interrupted");
        }
        System.out.printf("%-27s %14d %14d\n", testId, readTime, writeTime);
        if (readTime != 0 && writeTime != 0) {
            System.out.printf("%-27s %14d\n", "readTime + writeTime =", readTime + writeTime);
        }
    }
    
    abstract class TestTask implements Runnable {
        abstract void test();
        abstract void putResult();
        long duration;

        @Override
        public void run() {
            long startTime = System.nanoTime();
            test();
            duration = System.nanoTime() - startTime;
            synchronized (Tester.this) {
                putResult();
            }
            endLatch.countDown();
        }
    }

    public static void initMain(int reps, int cycles, int size) {
        testReps = reps;
        testCycles = cycles;
        containerSize = size;
        System.out.printf("%-27s %14s %14s\n", "Type", "Read Time", "Write Time");
        System.out.println("=========================================================");
    }
}
