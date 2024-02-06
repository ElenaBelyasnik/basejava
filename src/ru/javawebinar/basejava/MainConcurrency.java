package ru.javawebinar.basejava;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MainConcurrency {
    public static final int THREADS_NUMBER = 10000;
    private static int counter;
    private final AtomicInteger atomicCounter = new AtomicInteger();
    //private static final Object LOCK = new Object();
    private static final Lock lock = new ReentrantLock();
    private static final ReentrantReadWriteLock reentrantReadWriteLock =
            new ReentrantReadWriteLock();
    private static final Lock WRITE_LOCK = reentrantReadWriteLock.writeLock();
    private static final Lock READ_LOCK = reentrantReadWriteLock.readLock();
    private static final ThreadLocal<SimpleDateFormat> threadLocal =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("dd.MM.yyyy HH:mm:ss"));
    private static final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        Thread thread0 = new Thread() {
            @Override
            public void run() {
                System.out.println(getName() + ", " + getState());
                //throw new IllegalStateException();
            }
        };
        thread0.start();

        // создание потока при помощи лямбда-выражения и интерфейса Runnable
        new Thread(() -> System.out.println(Thread.currentThread().getName()
                + ", " + Thread.currentThread().getState())).start();

        System.out.println(thread0.getState());

        final MainConcurrency mainConcurrency = new MainConcurrency();
        CountDownLatch latch = new CountDownLatch(THREADS_NUMBER);
        //ExecutorService executorService = Executors.newCachedThreadPool();
        ExecutorService executorService =
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        CompletionService completionService = new ExecutorCompletionService(executorService);

//        List<Thread> threads = new ArrayList<>(THREADS_NUMBER);
        for (int i = 0; i < THREADS_NUMBER; i++) {
            SimpleDateFormat sdf = new SimpleDateFormat();
            Future<Integer> future = executorService.submit(() ->

//            Thread thread = new Thread(() ->
            {
                for (int j = 0; j < 100; j++) {
                    mainConcurrency.inc();
                    System.out.println(threadLocal.get().format(new Date()));
                    //System.out.println(LocalDate.now().format(formatter));
                }
                latch.countDown(); // синхронизатор
                return counter;
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
        //System.out.println(counter);
        System.out.println(mainConcurrency.atomicCounter.get());
        //LazySeingleton.getInstance();
    }


    //    private synchronized void inc() {
    private void inc() {
        //   private void inc() {
        //       synchronized (MainConcurrency.class) {
        //       double a = Math.sin(13.);
        //       synchronized (this) {
//        lock.lock();
//        try {
        atomicCounter.incrementAndGet();
//            counter++;
//        } finally {
//            lock.unlock();
//        }
//        }
    }
}
