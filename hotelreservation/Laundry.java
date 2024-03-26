package hotelreservation;


public class Laundry extends services {
	private int clothingPieces;
	private double laundryCost;
	
	public Laundry(int id, int pieces, double cost){
		super(id);
		this.clothingPieces = pieces;
		this.laundryCost = cost;
		
	}
	
	@Override
	public String getServiceType() {
		return "Laundry";		
	}
	@Override 
	public double calculateService() {
		return clothingPieces*laundryCost;
	}
	@Override
	public double getCost() {
		return calculateService();
	}

}	
