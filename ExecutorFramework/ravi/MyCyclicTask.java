package com.examples.cyclicbarrie.ace;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class MyCyclicTask implements Runnable
{
  private final String source;
  private final CyclicBarrier barrier;

  public MyCyclicTask(final String taskName, CyclicBarrier barrier)
  {
    this.source = taskName;
    this.barrier = barrier;
  }

  @Override
  public void run()
  {
    try
    {
      TimeUnit.SECONDS.sleep(1);
      System.out.println("Waiting...");
      barrier.await();
      System.out.println("Task Completed : Data loaded from " + source);
    }
    catch (InterruptedException | BrokenBarrierException e)
    {
      e.printStackTrace();
    }
  }
}
