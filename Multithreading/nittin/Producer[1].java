package com.example.demo;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable
{
	private static int counter = 0;
	private final BlockingQueue<Integer> myQueue;

	public Producer(final BlockingQueue<Integer> myQueue)
	{
		this.myQueue = myQueue;
	}

	@Override
	public void run()
	{
		for (int i = 0; i < 10; i++)
		{
			try
			{
				System.out.println("Producing value : " + counter);
				myQueue.put(counter);
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
