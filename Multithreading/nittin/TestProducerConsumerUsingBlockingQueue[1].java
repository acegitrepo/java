package com.example.demo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TestProducerConsumerUsingBlockingQueue
{
	public static void main(String[] args)
	{
		final BlockingQueue<Integer> myQueue = new LinkedBlockingQueue<>(2);
		Thread producer = new Thread(new Producer(myQueue));
		Thread consumer = new Thread(new Consumer(myQueue));

		consumer.start();
		producer.start();
	}
}
