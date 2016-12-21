package ayush.ace.day8.designpattern.FoodOrderSystem;

//Receiver
public class ContinentalFoodMaker implements Chef{

	@Override
	public void cookFood() {
		System.out.println("Preparing Continental Food");
	}

}
