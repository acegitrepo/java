package com.examples.executorsdemo.ace;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class MyExecutorTask implements Callable<String>
{
  private final String taskName;

  public MyExecutorTask(String taskName)
  {
    this.taskName = taskName;
  }

  @Override
  public String call() throws InterruptedException
  {
    TimeUnit.SECONDS.sleep(2);
    String msg = "Hello, Mr. Sharma";
    System.out.println("Task - " + taskName + ", message = " + msg);
    return msg;
  }
}
