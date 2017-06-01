package _synch_test;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample
{
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(3);

        Waiter waiter = new Waiter(latch);

        new Thread(waiter).start();

        Thread.sleep(1000);
        System.out.println(1);
        latch.countDown();

        Thread.sleep(1000);
        System.out.println(2);
        latch.countDown();

        Thread.sleep(1000);
        System.out.println(3);
        latch.countDown();

        //Thread.sleep(4000);
    }
}

class Waiter implements Runnable
{

    CountDownLatch latch = null;

    public Waiter(CountDownLatch latch) {
        this.latch = latch;
    }

    public void run() {
        System.out.println(123);
        try {
            latch.await();
            System.out.println(666);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Waiter Released");
    }
}
