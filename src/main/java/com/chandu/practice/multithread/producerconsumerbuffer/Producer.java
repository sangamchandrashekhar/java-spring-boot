package com.chandu.practice.multithread.producerconsumerbuffer;

public class Producer extends Thread{
    Buffer buffer;
    public Producer(Buffer buffer){
        this.buffer = buffer;
    }
    @Override
    public void run(){
        for (int i =1 ; i<=10 ; i++){
            buffer.produce(i);
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }
}
