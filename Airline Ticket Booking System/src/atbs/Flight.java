package atbs;

public class Flight {
	
	private String flightNumber;
	private String airline;
	private String source;
	private String destination;
	private int departureTime;
	private int arrivalTime;
	private double price;
	private int availableSeats;
	
	
	
	public Flight() { //================ blank constructor
		flightNumber = "SQ110011";
		airline = "Singapore Airline";
		source = "Singapore Changi Airport";
		destination = "Abu Dhabi International Airport";
		departureTime = 1130;
		arrivalTime = 0135;
		price = 666 ;
		availableSeats = 399;
		
	}

	public Flight(String flightNumber, String airline, String source, String destination,int departureTime, int arrivalTime,double price,int availableSeats) { //============= full constructor
		
		this.flightNumber = flightNumber;
		this.airline = airline;
		this.source = source;
		this.destination = destination;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
		this.price = price;
		this.availableSeats = availableSeats;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public String getAirline() {
		return airline;
	}

	public void setAirline(String airline) {
		this.airline = airline;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(int departureTime) {
		this.departureTime = departureTime;
	}

	public int getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(int arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	
	

}

