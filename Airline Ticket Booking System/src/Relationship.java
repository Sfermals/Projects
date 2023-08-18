import java.io.Serializable;

public class Relationship implements Serializable{
	   private String userId;
	   private String name;
	   private String flightNo;
	   private int ticketNo;	
	   
	   
	   
	   public Relationship( String userId, String name, String flightNo, int ticketNo) {  //constructor with attributes 
			
			this.userId = userId;
			this.name = name;
			this.flightNo = flightNo;
			this.ticketNo = ticketNo;
			
	   }
	  


	public String getUserId() {
		return userId;
	}



	public void setUserId(String userId) {
		this.userId = userId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getFlightNo() {
		return flightNo;
	}



	public void setFlightNo(String flightNo) {
		this.flightNo = flightNo;
	}



	public int getTicketNo() {
		return ticketNo;
	}



	public void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}
	public String toString() {
		return "  "+userId + "                 " + name +"            "+ flightNo +"            "+ ticketNo+"            " ;
} 
	   

}
