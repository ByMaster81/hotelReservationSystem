package hotelreservation;

public abstract class services implements Calculable{
	private int ID;
	
	public services(int id) {
		this.ID = id;
	}

	public int getCustomerId() {
		return ID;
	}

	public void setCustomerId(int customerId) {
		this.ID = customerId;
	}
	
	public abstract String getServiceType();
	public abstract double calculateService();
	
	public void displayServiceInfo() {
		System.out.println("Customer ID : " +getCustomerId()+ ", Service Type : " + getServiceType() + ", Cost : " + calculateService() );
	}

}
	


