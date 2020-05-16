package leetcode.top.interview.question;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;

/**
 * https://leetcode-cn.com/problems/print-zero-even-odd/
 *
 * @author Richard_yyf
 * @version 1.0 2020/5/16
 */
public class T1116_PrintZeroEvenOdd {

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(3);
        ////                System.out.println(Thread.currentThread().getName());
        IntConsumer printNumber = System.out::print;

        Thread thread1 = new Thread(() -> {
            try {
                zeroEvenOdd.zero(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                zeroEvenOdd.even(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread thread3 = new Thread(() -> {
            try {
                zeroEvenOdd.odd(printNumber);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();
        thread3.start();
    }

    static class ZeroEvenOdd {

        private int n;
        private Semaphore zeroSemaphore = new Semaphore(1);
        private Semaphore evenSemaphore = new Semaphore(0);
        private Semaphore oddSemaphore = new Semaphore(0);
        private int c = 1;

        public ZeroEvenOdd(int n) {
            this.n = n;
        }

        // printNumber.accept(x) outputs "x", where x is an integer.
        public void zero(IntConsumer printNumber) throws InterruptedException {
            while (c <= n) {
                zeroSemaphore.acquire();
                if (c > n) {
                    evenSemaphore.release();
                    oddSemaphore.release();
                    return;
                }
                printNumber.accept(0);
                if (c % 2 == 0) {
                    evenSemaphore.release();
                } else {
                    oddSemaphore.release();
                }
            }
        }

        public void even(IntConsumer printNumber) throws InterruptedException {
            while (c <= n) {
                evenSemaphore.acquire();
                if (c > n) {
                    return;
                }
                printNumber.accept(c);
                c++;
                zeroSemaphore.release();
            }
        }

        public void odd(IntConsumer printNumber) throws InterruptedException {
            while (c <= n) {
                oddSemaphore.acquire();
                if (c > n) {
                    return;
                }
                printNumber.accept(c);
                c++;
                zeroSemaphore.release();
            }
        }
    }
}
