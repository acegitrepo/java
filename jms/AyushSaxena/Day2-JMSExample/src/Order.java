import java.io.Serializable;

public class Order implements Serializable {

	public enum Status {PROCESSED , WAITING};
	
	public String itemName;
	
	public int reqdQuantity;
	
	public static final int availQuantity = 10;
	
	public int getReqdQuantity() {
		return reqdQuantity;
	}

	public void setReqdQuantity(int reqdQuantity) {
		this.reqdQuantity = reqdQuantity;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	Status orderStatus;
	
	public Status getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Status orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if(price < 0){
			
			throw new NegativePriceException("The Price of the Order cannot be negative");
		}
		this.price = price;
	}

	int price;
	
	
	
	
	
	
}
