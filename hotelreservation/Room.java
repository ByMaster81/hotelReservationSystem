package hotelreservation;


public class Room {
	String type;
	private int dailyCost;
	int roomSize;
	boolean hasBath;

	public Room(String type, int dailyCost, int roomSize, boolean hasBath) {
		this.type = type;
		this.dailyCost = dailyCost;
		this.roomSize = roomSize;
		this.hasBath = hasBath;
	}
	public Room() {
		type = "Single";
		dailyCost = 100;
		roomSize = 15;
		hasBath = false;
	}
		
	public String getRoomType() {
		return type;
	}
	public void setRoomType(String roomType) {
		this.type = roomType;
	}
	
	
	public int getDailyCost() {
		return dailyCost;
	}
	
	public void setDailyCost(int newCost) {
		this.dailyCost = newCost;
	}
	
}

