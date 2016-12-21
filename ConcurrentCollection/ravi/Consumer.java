package com.examples.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Consumer implements Runnable
{
	private final BlockingQueue<Item> sharedData;

	public Consumer(BlockingQueue<Item> sharedData)
	{
      this.sharedData = sharedData;
	}

	@Override
	public void run() 
	{
	  Item item = null;
      try
      {
    	  System.out.println("--------------------------------------------");
    	  while(true)
    	  {
    		  if(sharedData.size() == 0)
    		  {
    			  if(sharedData.size() == 0)
    		      {
    			    TimeUnit.SECONDS.sleep(1);
    			    continue;
    		      } 
    		   }
    		  
    		  item = sharedData.take();
    		  System.out.println("Consumed Item : " + item);
    		  System.out.println("---------------------------------------------------------------------");
    	  }
      }
      catch(Exception ex)
      {
        ex.printStackTrace();
      }
	}
}
