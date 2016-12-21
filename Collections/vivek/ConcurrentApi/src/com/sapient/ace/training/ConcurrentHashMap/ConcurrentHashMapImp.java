package com.sapient.ace.training.ConcurrentHashMap;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapImp {

	public ConcurrentHashMapImp() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
		map.put(1,11);
		
		map.putIfAbsent(1, 2);
		
		map.putIfAbsent(2, 22);
		
		Iterator<Integer> it=map.keySet().iterator();
		
		while(it.hasNext())
		{
			Integer key=it.next();
			System.out.println("key "+key+" value "+map.get(key));
		}
	}

}
