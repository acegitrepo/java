package ayush.ace.day8.designpattern.FoodOrderSystem;


//Invoker
public class Waiter {
	
	OrderFood order;
	
	Waiter(OrderFood newOrder){
		
		this.order = newOrder;
	}
	
	public void submitOrder(){
		
		
		order.execute();
		
	}


}
