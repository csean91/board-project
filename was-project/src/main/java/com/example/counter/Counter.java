package com.example.counter;

/**
 * packageName    : com.example.counter
 * fileName       : Counter
 * author         : swch
 * date           : 2022-09-27
 * description    :
 */
public class Counter implements Runnable {
    private int count = 0; // 상태를 알게 하기 위한 변수
    public void increment() {   // 상태에 변화를 주는 함수
        count++;
    }
    public void decrement() {   // 상태에 변화를 주는 함수
        count--;
    }
    public int getCount() {
        return this.count;
    }
    @Override
    public void run() {
        synchronized (this) {
            this.increment();
            System.out.println("after increment. " + Thread.currentThread().getName() + " " + this.getCount());
            this.decrement();
            System.out.println("after decrement. " + Thread.currentThread().getName() + " " + this.getCount());
        }
    }
}
