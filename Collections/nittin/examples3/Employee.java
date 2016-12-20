package com.collections.examples3;

public class Employee implements Comparable<Employee> {
	
	public long id;
	public String name;
	
	public Employee(long id,String name){
		this.id=id;
		this.name=name;
				
	}
	@Override
	public int compareTo(Employee employee) {
	
		if( this.id==employee.id	)
			{
			return 0;
			}else if(this.id>employee.id){
				return 1;
				
			}else{
				return -1;
			}
			}

}
