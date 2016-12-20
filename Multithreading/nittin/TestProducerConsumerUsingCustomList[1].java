package com.examples.producerconsumerusingcustomlist;

public class TestProducerConsumerUsingCustomList
{

	public static void main(String[] args) throws InterruptedException
	{
		final CustomList<Integer> myList = new CustomList<>();
		Thread producer = new Thread(new Producer(myList));
		Thread consumer = new Thread(new Consumer(myList));

		producer.start();
		consumer.start();
	}

}
