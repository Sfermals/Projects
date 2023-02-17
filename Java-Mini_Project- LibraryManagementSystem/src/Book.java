
public class Book extends Member{
	
	
	private String title;
	private String author;
	private boolean status;
	private int index;
	
	
	
	public Book() {
		getMembershipNumber();
		title = "untitled";
		author = "unnamed";
		status = true;
		index = 110060;
		
	}

	public Book(String title, String author, boolean status, int index, int membershipNumber) {
		super(membershipNumber);
		this.title=title;
		this.author=author;
		this.status=status;
		this.index=index;
	}
	

	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getAuthor() {
		return author;
	}



	public void setAuthor(String author) {
		this.author = author;
	}



	public boolean isStatus() {
		return status;
	}



	public void setStatus(boolean status) {
		this.status = status;
	}



	public int getIndex() {
		return index;
	}



	public void setIndex(int index) {
		this.index = index;
	}


	
	
	public String toString() {
		return title+"            "+author+"             "+status+"                  "+index+"                        "+getMembershipNumber();
	}
	
}
	



