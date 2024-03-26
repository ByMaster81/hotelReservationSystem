package hotelreservation;


public class spa extends services {
	private int days;
	private double spaCost;
	public spa(int id,int day, double cost) {
		super(id);
		this.days = day;
		this.spaCost = cost;
	}
	@Override
    public String getServiceType() {
        return "Spa";
    }
	@Override
	public double calculateService() {
		return days*spaCost;
	}
	@Override
	public double getCost() {
		return calculateService();
	}
    
}

