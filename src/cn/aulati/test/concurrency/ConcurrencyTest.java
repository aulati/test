package cn.aulati.test.concurrency;

import cn.aulati.test.ITest;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

public class ConcurrencyTest implements ITest {
    @Override
    public void runTest() {
        try {
            test04();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    private void test04() throws InterruptedException {
        TestBlockingQueues.test("LinkedBlockingQueue", new LinkedBlockingQueue<LiftOff>());
        TestBlockingQueues.test("ArrayBlockingQueue", new ArrayBlockingQueue<LiftOff>(3));
        TestBlockingQueues.test("SynchronousQueue", new SynchronousQueue<LiftOff>());
    }

    /**
     * notify() vs notifyAll()
     */
    private void test03() throws InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            exec.execute(new Task());
        }

        exec.execute(new Task2());
        
        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            int prod = 0;
            @Override
            public void run() {
                if (prod < 3) {
                    System.out.println("notify()");
                    Task.blocker.prod();
                    prod++;
                } else {
                    System.out.println("notifyAll()");
                    Task.blocker.prodAll();
                    prod = 0;
                }
            }
        }, 400, 400);
        
        // run for a while
        TimeUnit.SECONDS.sleep(5);
        t.cancel();
        System.out.println("Timer canceled!");
        TimeUnit.MILLISECONDS.sleep(500);

        System.out.println("Task2.blocker.prodALL()!");
        Task2.blocker.prodAll();
        TimeUnit.MILLISECONDS.sleep(500);

        System.out.println("Shutting down...");
        exec.shutdownNow();
    }

    /**
     * wait and notifyAll.
     * wait() must be call when the lock has been acquired.
     */
    private void test02() throws InterruptedException {
        Car c = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(new WaxOn(c));
        exec.execute(new Buff(c));

        TimeUnit.SECONDS.sleep(5);

//            exec.shutdownNow();
        exec.shutdown();
    }

    /**
     * interrupt and IO block, synchronized block
     */
    private void test01() throws InterruptedException {
        Interrupting.test(new SleepBlocked());
        Interrupting.test(new IOBlocked(System.in));
        Interrupting.test(new SynchronizedBlocked());

        TimeUnit.SECONDS.sleep(30);
        System.out.println("Aborting with System.exit(0)");
        System.exit(0);
    }
}
