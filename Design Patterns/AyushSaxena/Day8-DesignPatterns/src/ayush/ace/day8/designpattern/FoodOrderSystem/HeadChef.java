package ayush.ace.day8.designpattern.FoodOrderSystem;

public class HeadChef {

	// Based on the food choice we are returning receivers
	
	public static Chef selectMaker(String foodtype){
		
		switch(foodtype.toLowerCase()){
		
		case "chinese" : return new ChineseFoodMaker();
		
		
		case "continental" : return new ContinentalFoodMaker();
		
		
		default : return new IndianFoodMaker();
		
		}
		
			
		
	}
	
	
}
