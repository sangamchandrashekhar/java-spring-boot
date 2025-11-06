package com.chandu.practice.multithread.printnumberinsequence;

public class PrintNumbersInSequence implements Runnable{
    static Integer number = 1;
    static Object lock = new Object();
    @Override
    public void run() {
        while(number <= 100) {
            if (number % 2 == 0 && Thread.currentThread().getName().equals("even")) {
                synchronized (lock) {
                    System.out.println(number++);
                    lock.notify();
                }
            }
            if (number % 2 != 0 && Thread.currentThread().getName().equals("odd")) {
                synchronized (lock) {
                    System.out.println(number++);
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }

    public static void main(String[] args){
        Thread even = new Thread(new PrintNumbersInSequence(), "even");
        Thread odd = new Thread(new PrintNumbersInSequence(),"odd");
        even.start();
        odd.start();

    }
}
