package com.examples.cyclicbarrie.ace;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo
{
  public static void main(String[] args) throws InterruptedException
  {
    CyclicBarrier barrier = new CyclicBarrier(3);
    Thread t1 = new Thread(new MyCyclicTask("XML", barrier));
    Thread t2 = new Thread(new MyCyclicTask("DB", barrier));
    Thread t3 = new Thread(new MyCyclicTask("txt", barrier));

    t1.start();
    t2.start();
    t3.start();
  }

}
