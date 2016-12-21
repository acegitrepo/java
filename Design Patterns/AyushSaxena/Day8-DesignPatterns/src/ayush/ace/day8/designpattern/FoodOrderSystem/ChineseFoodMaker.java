package ayush.ace.day8.designpattern.FoodOrderSystem;


//Receiver
public class ChineseFoodMaker implements Chef{

	@Override
	public void cookFood() {
		System.out.println("Preparing Chinese Food");
	}

}
