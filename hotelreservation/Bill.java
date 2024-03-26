package hotelreservation;


public class Bill implements Calculable{
	private String type;
	private double amount;
	private String mounth;
	public Bill (String type, double amount, String mounth ) {
		this.type =  type;
		this.amount = amount;
		this.mounth = mounth;
	}
	public String getType() {
		return type;
	}
	
	public double getAmount() {
		return amount;
	}
	
	public String getMonth() {
		return mounth;
	}
	@Override
	public double getCost() {
		return getAmount();
	}
	
}
