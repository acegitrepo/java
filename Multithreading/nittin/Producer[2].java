package com.examples.producerconsumerusingcustomlist;

public class Producer implements Runnable
{
	private static int counter = 0;
	private final CustomList<Integer> myList;

	public Producer(final CustomList<Integer> myList)
	{
		this.myList = myList;
	}

	@Override
	public void run()
	{
		for (int i = 0; i < 10; i++)
		{
			try
			{
				System.out.println("Producing value : " + counter);
				myList.add(counter);
				counter++;
				Thread.sleep(1000);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}
