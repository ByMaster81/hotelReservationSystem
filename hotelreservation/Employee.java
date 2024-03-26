package hotelreservation;


public class Employee implements Calculable {
	private String name;
	private String surname;
	private int id;
	private double monthlyPayment;
	
	public Employee(String name, String surname,int id, double monthlyPayment) {
		this.name = name;
		this.id = id;
		this.surname = surname;
		this.monthlyPayment = monthlyPayment;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}


	public double getMonthlyPayment() {
		return monthlyPayment;
	}


	public int getId() {
		return id;
	}
    @Override
	public double getCost() {
		return getMonthlyPayment();
	}

	
	

}
