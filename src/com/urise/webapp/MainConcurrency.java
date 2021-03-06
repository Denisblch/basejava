package com.urise.webapp;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MainConcurrency {
    private static final int THREADS_NUMBER = 10000;
//    private static int counter;
    private final AtomicInteger atomicCounter = new AtomicInteger();
    private static final Integer ACC1 = 150;
    private static final Integer ACC2 = 350;

    static ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("dd.MM.yyyy HH:mm:ss"));

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());

        Thread thread0 = new Thread() {
            @Override
            public void run() {
                System.out.println(getName() + ", " + getState());
            }
        };
        thread0.start();

        new Thread(() -> System.out.println(Thread.currentThread().getName() + ", " + Thread.currentThread().getState())).start();

        System.out.println(thread0.getState());

        MainConcurrency mainConcurrency = new MainConcurrency();
        CountDownLatch latch = new CountDownLatch(THREADS_NUMBER);
        ExecutorService executorService = Executors.newCachedThreadPool();

//        CompletionService completionService = new ExecutorCompletionService(executorService);
//        List<Thread> threads = new ArrayList<>(THREADS_NUMBER);

        for (int i = 0; i < THREADS_NUMBER; i++) {
            executorService.submit(() ->
//            Thread thread = new Thread(() ->
            {
                for (int j = 0; j < 100; j++) {
                    mainConcurrency.inc();
                    System.out.println(threadLocal.get().format(new Date()));
                }
                latch.countDown();
            });

//            thread.start();
//            threads.add(thread);
        }
/*
        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
*/
        latch.await(10, TimeUnit.SECONDS);
        executorService.shutdown();
        System.out.println(mainConcurrency.atomicCounter.get());
        deadLock(ACC1, ACC2);
        deadLock(ACC2, ACC1);
    }

    private synchronized void inc() {
        atomicCounter.incrementAndGet();
//        counter++;
    }

    private static void transfer12(Object object1, Object object2) {
        object1 = (Integer) object1 - 100;
        object2 = (Integer) object2 + 100;
        System.out.println("Transfer from acc1" + "(" + object1 + ")" + " to acc2" + "(" + object2 + ")");
    }

    private static void transfer21(Object object1, Object object2) {
        object2 = (Integer) object2 - 150;
        object1 = (Integer) object1 + 150;
        System.out.println("Transfer from acc2" + "(" + object2 + ")" + " to acc1" + "(" + object1 + ")");
    }

    private static void deadLock(Object obj1, Object obj2) {
        new Thread(() -> {
            synchronized (obj1) {
                System.out.println("Execution: ");
                transfer12(obj1, obj2);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj2) {
                    System.out.println("Execution: ");
                    transfer21(obj1, obj2);
                }
            }
        }).start();
    }
}
