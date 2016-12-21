package com.examples.producerconsumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerUsingArrayBlockingQueueTest 
{
  public static void main(String[] args) 
  {
	int totalSize = 10;
	BlockingQueue<Item> sharedData = new ArrayBlockingQueue<>(totalSize);
    Thread producer = new Thread(new Producer(sharedData, totalSize), "Producer");
    Thread consumer = new Thread(new Consumer(sharedData), "Consumer");
    
    producer.start();
    consumer.start();
  }
}
