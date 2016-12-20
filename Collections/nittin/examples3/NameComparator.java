package com.collections.examples3;

import java.util.Comparator;

public class NameComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee arg0, Employee arg1) {
		return arg0.name.compareTo(arg1.name);
		
	}

}
