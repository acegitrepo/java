package com.collections.examples;


public class Fruit implements Comparable<Fruit> {

	
	String name;
	String color;
	
	public Fruit(String name,String color){
		this.name=name;
		this.color=color;
		
	}


	

	@Override
	public int compareTo(Fruit o) {
		return this.name.compareToIgnoreCase(o.name);	
	}
	
	
}
