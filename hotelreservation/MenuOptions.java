package hotelreservation;


public enum MenuOptions {
	createRes("\n1) Create new reservation."),
	displayAllRes("2) Display all reservations."),
	listOfReservations("3) List the reservations for a specific city."),
	extras("4)Add extra services to a reservation."),
	costServices("5)Calculate total cost for each service"),
	costAllCustomers("6)Display the total cost of every customer"),
	addEmployee("7)Add an employee"),
	addBill("8)Add a bill"),
	monthlyBalance("9) Monthly balance"),
	costSort("10) List all Services sorted based on cost"),
	nameSort("11) List all Reservations sorted based on hotel names"),
	exit("12 Exit");
	String description;
	
	MenuOptions (String description){
		this.description = description;
	}

	public String getDescription() {
		return description;
	}
}
	