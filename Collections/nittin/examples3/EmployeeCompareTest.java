package com.collections.examples3;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

public class EmployeeCompareTest {
	
	public static void main(String[] args) {
		List<Employee> employees=new ArrayList<Employee>();
		employees.add(new Employee(1,"Nittin"));
		employees.add(new Employee(3,"Ankit"));
		employees.add(new Employee(2,"Ravi"));
		System.out.println("UnSorted");
		for(Employee employee:employees){
			System.out.println(employee.name);
		}
		Collections.sort(employees);
		System.out.println("Id Sorted");
		for(Employee employee:employees){
			System.out.println(employee.name);
		}
		
		
		employees.sort(new NameComparator());
		System.out.println("Name Sorted");
		for(Employee employee:employees){
			System.out.println(employee.name);
		}
		//WeakReference<T>
		//WeakHashMap<K, V>
		
		
	}
	
	

}
