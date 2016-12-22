package com.examples.executorsdemo.ace;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

public class NewFixedThreadPoolExample
{
  public static void main(String[] args)
  {
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    MyExecutorTask task1 = new MyExecutorTask("T1");
    MyExecutorTask task2 = new MyExecutorTask("T2");
    MyExecutorTask task3 = new MyExecutorTask("T3");
    MyExecutorTask task4 = new MyExecutorTask("T4");
    MyExecutorTask task5 = new MyExecutorTask("T5");

    executorService.submit(task1);
    executorService.submit(task2);
    executorService.submit(task3);
    executorService.submit(task4);
    executorService.shutdown();

    try
    {

      executorService.submit(task5);
    }
    catch (RejectedExecutionException e)
    {
      System.out.println("Exception was expected due to " + e.getCause());
    }

    while (executorService.isTerminated())
    {
      System.out.println("All Task Done !!!");
    }
  }
}
