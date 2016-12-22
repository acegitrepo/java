package com.examples.countdown.ace;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest
{
  public static void main(String[] args) throws InterruptedException
  {
    CountDownLatch countDownLatch = new CountDownLatch(3);
    Thread t1 = new Thread(new MyTask("XML", countDownLatch));
    Thread t2 = new Thread(new MyTask("DB", countDownLatch));
    Thread t3 = new Thread(new MyTask("txt", countDownLatch));

    t1.start();
    t2.start();
    t3.start();

    countDownLatch.await();
    System.out.println("Data Processed and preparing report.....");
  }
}
