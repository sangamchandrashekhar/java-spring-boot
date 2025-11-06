package com.chandu.practice.multithread.producerconsumerbuffer;

public class Consumer extends Thread{
    Buffer buffer;
    public Consumer(Buffer buffer){
        this.buffer = buffer;
    }
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            buffer.consume();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}