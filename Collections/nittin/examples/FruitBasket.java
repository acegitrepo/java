package com.collections.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FruitBasket {
	static List<Fruit>  fruits=new ArrayList<>();
	public static void main(String[] args) {
		Fruit grape=new Fruit("Grapes","Blue");
		addFruits(new Fruit("Apple","Green"));
		addFruits(new Fruit("Apple","Red"));
		addFruits(new Fruit("Guava","Green"));
		addFruits(new Fruit("Pineapple","Yellow"));
		addFruits(new Fruit("Grapes","Blue"));
		
		System.out.println(fruits.size());
		Collections.sort(fruits);
		for(Fruit fruit : fruits){
			System.out.println(fruit.name);
		}
		System.out.println(Collections.binarySearch(fruits,new Fruit("Grapes","Blue")));
		
		
	}
	
	static void addFruits(Fruit fruit){
		fruits.add(fruit);
	}

}
