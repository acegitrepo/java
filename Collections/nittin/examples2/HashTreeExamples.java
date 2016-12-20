package com.collections.examples2;

import java.util.Collections;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class HashTreeExamples {
	static Set<Integer> set;
	public static void main(String[] args) {
	 Random random=new Random(10);
	 int i=0;
	 while(i!=10){
	 System.out.println();
     set=new HashSet<Integer>();
	 set.add(random.nextInt());
	 i++;}
	  Set treeSet=new TreeSet<Integer>(set);
	 
	}
	
	
	

}
