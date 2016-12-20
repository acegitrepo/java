package com.collections.examples4;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import com.collections.examples3.Employee;
import com.collections.examples3.NameComparator;

public class PriorityQueueApp {
	static Comparator nc=new NameComparator();
	public static void main(String[] args) {
		Queue<Employee>  pq=new PriorityQueue(nc);
		pq.add(new Employee(1,"Nittin"));
		pq.add(new Employee(3,"Ankit"));
		pq.add(new Employee(2,"Ravi"));
	for(Employee e: pq){
		System.out.println(e.name);
	}
	
	
	}

}
