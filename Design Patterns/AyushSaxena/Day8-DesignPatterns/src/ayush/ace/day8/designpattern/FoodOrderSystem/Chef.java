package ayush.ace.day8.designpattern.FoodOrderSystem;

public interface Chef {
	
	//Command
	public void cookFood();
	
	//Command
	default void prepareDrinks(){
		System.out.println("I dont have drinks to serve");
	}

}
