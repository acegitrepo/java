package com.sapient.ace.training.SynchronousQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class ProducerConsumer {

	public static void main(String[] args) {
		BlockingQueue<Integer> blockingQueue = new SynchronousQueue<Integer>();
		new Consumer(blockingQueue).start();
		new Producer(blockingQueue).start();

	}

}

class Consumer extends Thread {
	BlockingQueue<Integer> blockingQueue;

	Consumer(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	public void run() {
		for(int i=0;i<100;i++)
		{

			try {
				
				int output = blockingQueue.take();
				System.out.println("Thread " + Thread.currentThread() + " consumes " + output);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Producer extends Thread {
	BlockingQueue<Integer> blockingQueue;

	Producer(BlockingQueue<Integer> blockingQueue) {
		this.blockingQueue = blockingQueue;
	}

	

	public void run() {
		for(int i=0;i<100;i++)
		{

			try {
				
				System.out.println("Thread " + Thread.currentThread() + " procuses " + i);
				blockingQueue.put(i);
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
