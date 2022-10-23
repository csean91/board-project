package com.example.counter;

/**
 * packageName    : com.example.counter
 * fileName       : RaceCountDemo
 * author         : swch
 * date           : 2022-09-27
 * description    :
 */
public class RaceCountDemo {
    public static void main(String[] args) {
        Counter counter = new Counter();    // singleton처럼 객체를 하나만 생성

        Thread thread1 = new Thread(counter, "thread-1");
        Thread thread2 = new Thread(counter, "thread-2");
        Thread thread3 = new Thread(counter, "thread-3");
        Thread thread4 = new Thread(counter, "thread-4");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
