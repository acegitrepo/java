package com.examples.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

public class ProducerConsumerUsingDelayQueueTest 
{
  public static void main(String[] args) 
  {
    int totalSize = 10;
	BlockingQueue<Item> sharedData = new LinkedBlockingDeque<>(totalSize);
	Thread producer = new Thread(new Producer(sharedData, totalSize), "Producer");
	Thread consumer = new Thread(new Consumer(sharedData), "Consumer");
	    
	producer.start();
	consumer.start();
  }

}
