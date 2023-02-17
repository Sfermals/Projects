import java.io.Serializable;

public class Person  implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3342037059478137163L;
	private String name;
	private String email;
	private int phoneNumber;
	
	
	public Person() { //================ blank constructor
		name = "";
		email = "abc@abc.com";
		phoneNumber = 12345678;
	}
	
	
	public Person(String name, String email, int phoneNumber) { //============= full constructor
		
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		
	}

	//=== accessors ===================================

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


}
