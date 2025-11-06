package com.chandu.practice.multithread.producerconsumerbuffer;

public class Buffer{
     private int data;
     private boolean isEmpty = true;
    public synchronized void produce(int value){
        if(!isEmpty){
            try{
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Produced : "+value);
        data = value;
        isEmpty = false;
        notify();
    }
    public synchronized int consume(){
        if(isEmpty){
            try {
                wait();
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("Consumed : "+data);
        isEmpty = true;
        notify();
        return data;
    }
}