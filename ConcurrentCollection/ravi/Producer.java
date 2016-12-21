package com.examples.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TimeUnit;

public class Producer implements Runnable
{
	private final BlockingQueue<Item> sharedData;
	private final int totalSize;
    private static int count = 0;
	public Producer(BlockingQueue<Item> sharedData, int totalSize)
	{
      this.sharedData = sharedData;
      this.totalSize = totalSize;
	}

	@Override
	public void run() 
	{
	  Item item = null;
      try
      {
    	  while(true)
    	  {
    	    if(sharedData.size() == totalSize)
    		 {
    		   TimeUnit.SECONDS.sleep(1);
    			continue;
    		 }
    		  
    	      if(sharedData instanceof LinkedBlockingDeque)
    	      {
    	        item = new DelayedItem(count); 
    	      }
    	      else
    	      {
    		    item = new ProducedItem(count);
    	      }
    	      
    	      if(sharedData instanceof LinkedTransferQueue)
    	      {
    	        ((LinkedTransferQueue<Item>) sharedData).transfer(item);
    	      }
    	      else
    	      {
    		    sharedData.put(item);
    	      }
    	      
    		  System.out.println("Produced Item : " + item);
    		  count++;
    	  }
      }
      catch(Exception ex)
      {
        ex.printStackTrace();
      }
	}
}
