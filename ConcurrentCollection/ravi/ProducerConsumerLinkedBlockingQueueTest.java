package com.examples.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ProducerConsumerLinkedBlockingQueueTest 
{
  public static void main(String[] args) 
  {
    int totalSize = 10;
	BlockingQueue<Item> sharedData = new LinkedBlockingQueue<>(totalSize);
	Thread producer = new Thread(new Producer(sharedData, totalSize), "Producer");
	Thread consumer = new Thread(new Consumer(sharedData), "Consumer");
	    
	producer.start();
	consumer.start();
	  
  }
}
