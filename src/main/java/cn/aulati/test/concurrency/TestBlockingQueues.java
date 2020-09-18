package cn.aulati.test.concurrency;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class TestBlockingQueues {
    public static void test(String queType, BlockingQueue<LiftOff> queue) throws InterruptedException {
        System.out.println("------------------------------------------------");
        System.out.println(queType);
        LiftOffRunner runner = new LiftOffRunner(queue);
        
        Thread t = new Thread(runner);
        t.start();

        for (int i = 0; i < 5; i++) {
            runner.add(new LiftOff(5));
        }

        TimeUnit.SECONDS.sleep(5);
        t.interrupt();
        System.out.println("Test finished: " + queType);
    }
}

class LiftOffRunner implements Runnable {
    private BlockingQueue<LiftOff> rockets;

    public LiftOffRunner(BlockingQueue<LiftOff> queue) {
        rockets = queue;
    }
    
    public void add(LiftOff lo) {
        try {
            rockets.put(lo);
            System.out.println("A rocket is added to the queue");
        } catch (InterruptedException e) {
            System.out.println("Interrupted during put()");
        }
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                LiftOff rocket = rockets.take();
                rocket.run();

                TimeUnit.MILLISECONDS.sleep(200);
            }
        } catch (InterruptedException e) {
            System.out.println("Interrupted when waiting for take()");
        }
        System.out.println("Exiting LiftOffRunner");
    }
}