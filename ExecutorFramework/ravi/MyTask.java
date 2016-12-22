package com.examples.countdown.ace;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class MyTask implements Runnable
{
  private final String source;
  private final CountDownLatch countDownLatch;

  public MyTask(final String taskName, CountDownLatch countDownLatch)
  {
    this.source = taskName;
    this.countDownLatch = countDownLatch;
  }

  @Override
  public void run()
  {
    try
    {
      TimeUnit.SECONDS.sleep(1);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    System.out.println("Task Completed : Data loaded from " + source);
    countDownLatch.countDown();
  }
}
