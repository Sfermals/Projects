import java.io.Serializable;

public class generator implements Serializable{
	
	private int ticketNumber;
	private String seatNumber;
	private int num;
	private char sect;
	
	
	
	
	public generator(){
		ticketNumber=11000;
		seatNumber="";
		num = 1;
		sect='A';
	}
	
	public generator(int ticketNumber, String seatNumber, int num, char sect) {
		this.ticketNumber=ticketNumber;
		this.seatNumber=seatNumber;
		this.num=num;
		this.sect=sect;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public String getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(String seatNumber) {
		this.seatNumber = seatNumber;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public char getSect() {
		return sect;
	}

	public void setSect(char sect) {
		this.sect = sect;
	}
	
	public String toString() {
		return "  " +  ticketNumber + "  " + seatNumber +"  "+ num +" "+ sect;
		
		
	}
	
	
	

}
