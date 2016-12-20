package com.java.multithreading;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ReadWriteDemo {
	ReadWriteLockImpl readWriteLockImpl = new ReadWriteLockImpl();
	
	private void reader(){
		ExecutorService es1 = Executors.newFixedThreadPool(10);
		for(int i=0;i<100;i++){
			es1.submit(()->{
				readWriteLockImpl.readFromMap();
			});
			try {
				Thread.sleep(000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		es1.shutdown();
	}
	
	private void writer() throws InterruptedException{
		ExecutorService es = Executors.newFixedThreadPool(5);
		for(int i=0;i<100;i++){
			es.submit(()->{
				readWriteLockImpl.writeOnMap();
			});
			
		}
		es.shutdown();
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		final ReadWriteDemo readWriteDemo =  new ReadWriteDemo();
		
		Thread writer = new Thread(()->{
			try {
				readWriteDemo.writer();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		Thread reader = new Thread(()->{
			try {
				readWriteDemo.reader();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		writer.start();
		reader.start();
		
		
		
		
		
		
	}
}
