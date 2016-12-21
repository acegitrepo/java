package ayush.ace.day8.designpattern.FoodOrderSystem;

import java.util.Scanner;

public class FoodOrderSystem {

	public static void main(String[] args){
		
			
		while(true){
			
		System.out.println("What type of food you want to order? ");
		
		Scanner sc = new Scanner(System.in);
			    		
		OrderFood item = new OrderFood(HeadChef.selectMaker(sc.nextLine()));
		
		Waiter waiter = new Waiter(item);

		waiter.submitOrder();
		//System.out.println("What type of drinks you want to order? ");
		}
		
		
		
	}
	
}
