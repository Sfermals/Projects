
public class Member extends Person  {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6119374866512470798L;
	private int membershipNumber;
	private boolean membershipStatus;
	private int password;
	
	
	
	public Member() { //========================= blank constructor
		getName();
		getEmail();
		getPhoneNumber();
		membershipNumber = 0202023;
		membershipStatus = true;
		password = 0;
	}
	
	                 //=========================== full constructor
	public Member(String name, String email, int phoneNumber, int membershipNumber, boolean membershipStatus) {
		super(name, email, phoneNumber);
		this.membershipNumber = membershipNumber;
		this.membershipStatus = membershipStatus;
		
		
	}
	public Member(int membershipNumber, int password) {
		this.membershipNumber = membershipNumber;
		this.password = password;
	}

	
	//=========================================accessors
	public Member(int membershipNumber)
	{
		this.membershipNumber = membershipNumber;
	}
	
	public int getMembershipNumber() {
		return membershipNumber;
	}
	public void setMembershipNumber(int membershipNumber) {
		this.membershipNumber = membershipNumber;
	}
	public boolean isMembershipStatus() {
		return membershipStatus;
	}
	public void setMembershipStatus(boolean membershipStatus) {
		this.membershipStatus = membershipStatus;
	}
	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	//============================================== methods
	void displayMember()
	{
		System.out.println("Name: " + getName());
		System.out.println("Email: " + getEmail());
		System.out.println("Phone Number: " + getPhoneNumber());
		System.out.println("Membership Number: " + getMembershipNumber());
		System.out.println("Membership Status: " + isMembershipStatus());
	}
	public String toString()
	{
		
		return getName()+"     "+getEmail()+"      "+getPhoneNumber()+"          "+ membershipNumber+"           "+ membershipStatus;
	}

}
