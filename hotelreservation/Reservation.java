package hotelreservation;


public class Reservation extends services implements Comparable<Reservation> {
	private Room room;
	private String city;
	private String hotelName;
	private String reservationMonth;
	private int reservationStart;
	private int reservationEnd;
	
	public static int totalNumberOfReservations = 0;
	
	
	public Reservation(int id, String hotelName,String city, String reservationMonth, int reservationStart, int reservationEnd, Room room) {
		super(id);
		this.hotelName = hotelName;
		this.reservationMonth = reservationMonth;
		this.reservationStart = reservationStart;
		this.reservationEnd = reservationEnd;
		this.room = room;
		this.city = city;
	
		
	};
	
	public String getCity() {
		return city;
	}

	public Room getRoom() {
		return room;
	}
	public String getHotelName(){
		return hotelName; 
	}
	
	public String getReservationMonth(){
		return reservationMonth;
	}
	public int getReservationStart(){
		return reservationStart;
	}
	public int getReservationEnd(){
		return reservationEnd;
	}
	
	
	public int totalCost() {
			int duration = reservationEnd - reservationStart;
			int totalCost = duration*room.getDailyCost();
			switch(reservationMonth) {
				case "June":
					return 2*totalCost;
				case "July":
					return 2*totalCost;
				case "August":
					return 2*totalCost;
				default:
					return totalCost;
			
			}
		
	}
	
	public static void setTotalNumberOfReservations(int totalNumberOfReservations) {
		Reservation.totalNumberOfReservations = totalNumberOfReservations;
	}

	public int getTotalNumberOfReservations() {
		return totalNumberOfReservations;
	}

	

	public void setRoom(Room room) {
		this.room = room;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public void setReservationMonth(String reservationMonth) {
		this.reservationMonth = reservationMonth;
	}

	public void setReservationStart(int reservationStart) {
		this.reservationStart = reservationStart;
	}

	public void setReservationEnd(int reservationEnd) {
		this.reservationEnd = reservationEnd;
	}

	public void displayInfo(){
		System.out.println("Reservation for "+room.type+" room in "+ hotelName + " starts on " + reservationMonth +" "+ reservationStart + " ends on " + reservationMonth + " " + reservationEnd +".  \n"
				+ "Reservation has total cost of "+totalCost()+ "$\n"
						+ "ID ="+getCustomerId());
	}

	@Override
	public String getServiceType() {
		return "reservation";
	}
		
	@Override
	public double calculateService() {
		return totalCost();
	}
	@Override
	public double getCost() {
		return calculateService();
	}

	@Override
	public int compareTo(Reservation o) {
		return this.getHotelName().compareTo(o.getHotelName());

	}
	public String displayInfoGUI(){
		return"Reservation for "+room.type+" room in "+ hotelName + " starts on " + reservationMonth +" "+ reservationStart + " ends on " + reservationMonth + " " + reservationEnd +".  \n"
				+ "Reservation has total cost of "+totalCost()+ "$\n"
						+ "Reservation ID ="+getCustomerId();
	}
		


	
}
