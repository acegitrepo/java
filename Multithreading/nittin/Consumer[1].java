package com.examples.producerconsumerusingcustomlist;

public class Consumer implements Runnable
{
	private final CustomList<Integer> myList;

	public Consumer(final CustomList<Integer> myList)
	{
		this.myList = myList;
	}

	@Override
	public void run()
	{
		while (true)
		{
			try
			{
				Integer intValue = myList.get();
				if (null == intValue)
				{
					continue;
				}
				int value = intValue;
				System.out.println("Consuming value : " + value);
				System.out.println("---------------------------------------------------------------");
			}
			catch (Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
