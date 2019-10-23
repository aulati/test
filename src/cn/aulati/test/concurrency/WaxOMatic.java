package cn.aulati.test.concurrency;

import java.util.concurrent.TimeUnit;

public class WaxOMatic {
}

class Car {
    private volatile boolean waxOn = false;
    
    public volatile int mod = 0;

    public synchronized void waxed() {
        waxOn = true;   // ready to buff
        mod++;
//        notifyAll();
        notify();
    }

    public synchronized void buffed() {
        waxOn = false;
        mod++;
//        notifyAll();
        notify();
    }

    public synchronized void waitForWaxing() throws InterruptedException {
        while (!waxOn) {
            wait();
        }
    }
    
    public synchronized void waitForBuffing() throws InterruptedException {
        while (waxOn) {
            wait();
        }
    }
}

class WaxOn implements Runnable {
    private Car car;

    public WaxOn(Car c) {
        car = c;
    }
    
    @Override
    public void run() {
        try {
            while (car.mod < 30 && !Thread.interrupted()) {
                System.out.println("Waxing!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffing();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting WaxOn via interrupt");
        }
        System.out.println("Ending Waxing task");
    }
}

class Buff implements Runnable {
    private Car car;

    public Buff(Car c) {
        car = c;
    }

    @Override
    public void run() {
        try {
            while (car.mod < 30 && !Thread.interrupted()) {
                car.waitForWaxing();
                System.out.println("Buffing!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        } catch (InterruptedException e) {
            System.out.println("Exiting Buff via interrupt");
        }
        System.out.println("Ending Buffing task");
    }
}