package atbs;

import java.io.*;
import java.util.*;



public class MainSystem {

	public static void main(String[] args) throws Exception {
		
		//VARIABLES
		int choice = -1;
		String userID,name, email;
		int password;
		
		//TXT FILES. 
		File userFile = new File("User.txt");
		
		//SCANNERS
		Scanner s = new Scanner(System.in);
		
		//COLLECTIONS
		ArrayList<User> al = new ArrayList<User>();
		
		//OOS/OIS/List Iterator
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		ListIterator li = null; //print as list orderly.
		
		
		
		do {
			System.out.println("\n1.CREATE USER");
			System.out.println("2.DISPLAY USER");
			
			System.out.println("0.EXIT");
			System.out.println("Enter your choice: ");
			choice = s.nextInt();
			
			switch(choice) {
				case 1: 
					System.out.print("Enter UserID No: ");
					userID = s.next();
					
					System.out.print("Enter Name: ");
					name = s.next();
					
					System.out.print("Enter Email: ");
					email = s.next();
					
					System.out.print("Enter password: ");
					password = s.nextInt();
					
					al.add(new User(userID,name,email,password));
					
					oos = new ObjectOutputStream(new FileOutputStream(userFile)); //then only will write collection into file
					oos.writeObject(al);
					oos.close(); //put object into arraylist then persist it in a txt file
					
					
				break;
				case 2:
					ois = new ObjectInputStream(new FileInputStream(userFile));
					al = (ArrayList<User>)ois.readObject();
					ois.close();
					
					System.out.println("-------------------------------------------------------");
					li = al.listIterator();
					while(li.hasNext())
						System.out.println(li.next());
					System.out.println("-------------------------------------------------------");
				break;
			}
			
			
		}while(choice!=0);
		
		
	}

}
