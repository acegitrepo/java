package com.examples.producerconsumer;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedItem implements Item, Delayed 
{
	private int count = 0;
	
	public DelayedItem(int count)
	{
      this.count = count;
	}
	
	@Override
	public int compareTo(Delayed o) 
	{
      if (this.count < ((DelayedItem) o).count) 
      {
        return -1;
	  }
      
      if (this.count > ((DelayedItem) o).count) 
      {
        return 1;
      }
      
	  return 0;
	}


	@Override
	public long getDelay(TimeUnit unit) 
	{
		return count;
	}

	@Override
	public int getValue() 
	{
		return 0;
	}

	@Override
	public String toString() 
	{
    	return "[" + count + "]";
	}
}
