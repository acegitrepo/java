package com.java.multithreading;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockImpl {
	
	 Map<Integer,Integer> map = new HashMap<>();
	
	 
	 private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	 
	 static int putVal = 0;  
	 static int getVal = 0;
	 
	 private final Lock readLock = readWriteLock.readLock();
	 
	  
	 
	 private final Lock writeLock = readWriteLock.writeLock();

	
	
	public void readFromMap(){
		try{
			readLock.lock();
			System.out.println("thread name reading from map "+ Thread.currentThread().getName() + " and value is " +map.get(getVal++));
			}finally{
				readLock.unlock();
			}
	}
	public void writeOnMap(){
		try{
		writeLock.lock();
		System.out.println("writing value on map " + Thread.currentThread().getName() + " and value is " + putVal);
		Thread.sleep(000);
		map.put(putVal, putVal);
		putVal++;
		}catch(InterruptedException e){
			
		}finally{
			writeLock.unlock();
		}
	}
	
	
	

}
