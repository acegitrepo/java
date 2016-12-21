
package com.examples.producerconsumer;

public class ProducedItem implements Item
{
	private int count = 0;
	public ProducedItem()
	{
      count++;
	}
	
	public ProducedItem(int count) 
	{
      this.count = count;
	}

	@Override
	public int getValue() 
	{
		return count;
	}

	@Override
	public String toString() 
	{
    	return "[" + count + "]";
	}
}
