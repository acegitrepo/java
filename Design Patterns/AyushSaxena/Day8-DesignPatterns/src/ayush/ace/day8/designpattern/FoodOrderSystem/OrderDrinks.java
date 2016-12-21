package ayush.ace.day8.designpattern.FoodOrderSystem;


//Command implementation, it will execute the command based on the receiver

public class  OrderDrinks implements Command {

	
	//This is receiver object 
	Chef maker;
	
	OrderDrinks(Chef maker){
		
		this.maker = maker;
		
	}
	
	@Override
	public void execute() {
		// TODO Auto-generated method stub
		
		maker.prepareDrinks();
		
		
	}

	
	
	
}
