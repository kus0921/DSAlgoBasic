package javastreamsSession3;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.IntStream;

public class ThreadWithStream {
    public static void main(String[] args) {
        int[] intArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19};
        IntStream intStream = Arrays.stream(intArray);
        AtomicInteger atomicInteger = new AtomicInteger(1);
        final int[] someWork = {0};
        Lock lock = new ReentrantLock();

        // lambda needs effectively final variable ?
       /*int u = 1;
        u = 2;
        Predicate<Integer> predicate = t -> u + 1 == 1;*/


        /* problem with using atomic integer in stream! */
        // if you run code 25 - 39, then many times, atomicInteger will change in between stream operation!
        /*Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("setting atomic integer to 2");
                atomicInteger.set(2);
            }
        };

        thread.start();
        intStream.forEach(t -> System.out.println(t + atomicInteger.get()));*/

        /* to avoid the above problem run the below snippet and see
           that the lock is only present with one thread and the other
           thread has to wait until first completes its operation */
        Thread thread = new Thread() {
            @Override
            public void run() {
                lock.lock(); // lock is initially with this thread, if it starts first
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                System.out.println("setting atomic integer to 2");
                atomicInteger.set(2);
                lock.unlock(); // unlock -> for better coding we can also
                               // place 54 and 55 in try block after sleep(1) and lock.unlock in finally block
            }
        };

        Thread thread1 = new Thread() {
            @Override
            public void run() {
                lock.lock(); // lock is initially with this thread, if it starts first
                // actual task
                intStream.forEach(t -> System.out.println(t + atomicInteger.get()));
                lock.unlock();
            }
        };

        thread.start();
        thread1.start();

    }
}
