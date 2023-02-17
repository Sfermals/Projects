
public class Admin extends Person{
	private int staffNumber;
	private int password;
	
	public Admin() {
		getName();
		getEmail();
		getPhoneNumber();
		staffNumber = 0;
		password = 0;
	}
	
	public Admin(String name, String email, int phoneNumber, int staffNumber) {
		super(name,email,phoneNumber);
		this.staffNumber = staffNumber;
	}
	public Admin(int staffNumber, int password) {
		this.staffNumber=staffNumber;
		this.password=password;
		
	}

	public int getStaffNumber() {
		return staffNumber;
	}

	public void setStaffNumber(int staffNumber) {
		this.staffNumber = staffNumber;
		
	}
	
	
	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public String toString() {
		return getName()+"     "+getEmail()+"       "+getPhoneNumber()+"           "+staffNumber;
	}
	
	
	
}
