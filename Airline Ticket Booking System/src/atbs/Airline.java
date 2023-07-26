package atbs;

public class Airline {
	
	private String flights;
	private String users;
	private int tickets;
	
	public Airline() { //================ blank constructor
		flights = "Singapore Airline";
		users = "Tom Hanks";
		tickets = 13390001;
	}
	
	public Airline(String flights, String users, int tickets) { //================ blank constructor
		this.flights = flights;
		this.users = users;
		this.tickets = tickets;
	}

	public String getFlights() {
		return flights;
	}

	public void setFlights(String flights) {
		this.flights = flights;
	}

	public String getUsers() {
		return users;
	}

	public void setUsers(String users) {
		this.users = users;
	}

	public int getTickets() {
		return tickets;
	}

	public void setTickets(int tickets) {
		this.tickets = tickets;
	}
	
	

}
