package com.collections.examples1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class LinkedListExample {
	
	public static void main(String[] args) {
		List<String>  friends=new LinkedList<String>();
		friends.add("nittin");
		friends.add("nittin1");
		friends.add("nittin2");
		friends.add("nittin3");
		friends.add("nittin4");
		
		for(int i=0;i<friends.size();i++)
		System.out.println(friends.get(i));
		
		
		friends.remove(3);
		for(int i=0;i<friends.size();i++)
			System.out.println(friends.get(i));
		
		
			
		
	}
	

}
