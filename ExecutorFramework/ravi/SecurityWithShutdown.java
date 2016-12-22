package com.examples.executorsdemo.ace;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class SecurityWithShutdown
{
  private static ThreadPoolExecutor tpe;

  public static void main(String[] args)
  {
    Thread ct = Thread.currentThread();
    System.out.println("current thread: " + ct);
    ct.checkAccess(); // we have access to our own thread...

    tpe = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS,
        new LinkedBlockingQueue<Runnable>(), new ThreadFactory() {
          public Thread newThread(Runnable r)
          {
            // obviously never gets called as we don't add any work
            System.out.println("making thread");
            try
            {
              TimeUnit.SECONDS.sleep(1);
            }
            catch (InterruptedException e)
            {
              // TODO Auto-generated catch block
              e.printStackTrace();
            }
            return new Thread(r);
          }
        });

    tpe.shutdown();
  }
}
