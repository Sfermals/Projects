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
		File flightFile = new File("flight.txt");
		
		//SCANNERS
		Scanner s = new Scanner(System.in);
		
		//COLLECTIONS
		ArrayList<User> us = new ArrayList<User>();
		ArrayList<Flight> fl = new ArrayList<Flight>();
		
		//OOS/OIS/List Iterator
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		ListIterator li = null; //print as list orderly.
		
		
		
		do {
			/*System.out.println("\n1.SIGN UP ACCOUNT"); //user
			System.out.println("2.ADD FLIGHT");  //admin
			System.out.println("3.DISPLAY FLIGHT"); //user
			*/
			System.out.println("========================================");
			System.out.println("AIRLINE TICKET BOOKING SYSTEM ");
			System.out.println("========================================");
			
			System.out.println("1. Member?.. SIGN UP AS USER");
			System.out.println("97. add user ");
			
			
			
			System.out.println("0.EXIT");
			System.out.println("\nEnter your choice: ");
			choice = s.nextInt();
			
			switch(choice) {
				case 1: 
					
				break;
				
				case 2:
				
				break;
				
				case 3: 
					
				break;
				
				case 4:
				
				break;
				
				
				
				
				
			     //TRYIN TO SETUP ALL THE FEATURES OF THIS PROJECT TO STRUCTURE IT LATER
				case 95: 
					System.out.print("bla ...program running bla bla");
				break; 
	
			
				case 97: //add user 
					System.out.print("Enter UserID No: ");
					userID = s.next();
					
					System.out.print("Enter Name: ");
					name = s.next();
					
					System.out.print("Enter Email: ");
					email = s.next();
					
					System.out.print("Enter password: ");
					password = s.nextInt();
					
					us.add(new User(userID,name,email,password));
					
					oos = new ObjectOutputStream(new FileOutputStream(userFile)); //then only will write collection into file
					oos.writeObject(us);
					oos.close(); //put object into arraylist then persist it in a txt file
				break;
				
				case 96: //ADD FLIGHT
					String flightNum,airline,source,destination;
					int departureTime,arrivalTime,availableSeats;
					double price;
	
					
					System.out.print("Enter Flightnum No: ");
					flightNum = s.next();
					
					System.out.print("Enter Airlines: ");
					airline = s.next();
					
					System.out.print("Enter source: ");
					source = s.next();
					
					System.out.print("Enter destination: ");
					destination = s.next();
					
					System.out.print("Enter departureTime: ");
					departureTime = s.nextInt();
					
					System.out.print("Enter arrivaltime: ");
					arrivalTime = s.nextInt();
					
					System.out.print("Enter price: ");
					price = s.nextDouble();
					
					System.out.print("Enter availableSeats: ");
					availableSeats = s.nextInt();
					

					
					fl.add(new Flight(flightNum,airline,source,destination,departureTime,arrivalTime,price,availableSeats));
					
					oos = new ObjectOutputStream(new FileOutputStream(flightFile)); //then only will write collection into file
					oos.writeObject(fl);
					oos.close(); //put object into arraylist then persist it in a txt file
					
					
				break;
				
				
				
				// TO DISPLAY FLIGHT DETAILS
				
				case 98:
					if(flightFile.isFile()) { //if userFile exist? then... run the input stream
						
						ois = new ObjectInputStream(new FileInputStream(flightFile));
						fl = (ArrayList<Flight>)ois.readObject();
						ois.close();
						
						System.out.println("-------------------------------------------------------");
						li = fl.listIterator();
						while(li.hasNext())
							System.out.println(li.next());
						System.out.println("-------------------------------------------------------");
					}else {
						System.out.println("File do not exist..!");
					}
					break; //==========================================================================
				
				case 99:// DISPLAY USER
				if(userFile.isFile()) { //if userFile exist? then... run the input stream
					
					ois = new ObjectInputStream(new FileInputStream(userFile));
					us = (ArrayList<User>)ois.readObject();
					ois.close();
					
					System.out.println("-------------------------------------------------------");
					li = us.listIterator();
					while(li.hasNext())
						System.out.println(li.next());
					System.out.println("-------------------------------------------------------");
				}else {
					System.out.println("File do not exist..!");
				}
				break; //==========================================================================
			}
			
			
		}while(choice!=0);
		
		
	}

}
