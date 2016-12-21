package ayush.ace.day8.designpattern.FoodOrderSystem;

//Receiver
public class IndianFoodMaker implements Chef{

	@Override
	public void cookFood() {
		System.out.println("Preparing Indian Food");
	}

}
