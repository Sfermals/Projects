                                                                                                                                         //PASSWORD FOR MEMBER AND ADMIN EDITING IN ADMINSTRATION NOT SETUP YET.
import java.io.*;
import java.util.*;


public class MainLMS {

	public static void main(String[] args) throws Exception {
	
		int choice = -1;
		Scanner s = new Scanner(System.in);
		Scanner s1 = new Scanner(System.in);
		
		
		File file = new File("member.txt");
		File memsPassFile = new File("memberPassword.txt");
		File adminfile = new File("admin.txt");
		File adPfile = new File("adminPassword.txt");
		File bkfile = new File("book.txt");
		
		ArrayList<Member> mems = new ArrayList<Member>();
		ArrayList<Member> memsPass = new ArrayList<Member>();
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		
		ArrayList<Admin> admin = new ArrayList<Admin>();
		ArrayList<Admin> adP = new ArrayList<Admin>();
		
		ArrayList<Book> bk = new ArrayList<Book>();
		ObjectOutputStream oos2 = null;
		ObjectInputStream ois2 = null;
		
		ListIterator li = null;
		
		
		
		
		
		do { 
			System.out.println("\n\n===============================");
			System.out.println("  Library Management System");
			System.out.println("===============================");
			
			
			System.out.println("(1) Member Access");
			
			
			
			System.out.println("(2) Discover Books");
			System.out.println("(3) Access Book Loan Function");
			System.out.println("(4) Library Administration [*Admin Login Required]");
			System.out.println("\n(0) EXIT"); //supposed to be exit on 6 - to be fix. 
			
			System.out.print("\nEnter your choice: ");
			choice = s.nextInt();
			

		
		switch(choice) {
			
//=====================(1) Member Access ==============================================================================================================================================================================================================
			
				
				
			case 1: //.................................................................................................................................................................................................................................
				
					//DISPLAY OPTIONS =========(1)MEMBER LOGIN - (2)SIGN UP AS MEMBER =================================================================================================================================================================
					System.out.println("\n(1)Member Login \n(2)Sign Up As Member");
					System.out.println("\nEnter Selection: ");
					                            
					
					
					int memberAccessChoice = -1;
					memberAccessChoice = s.nextInt();
					
					switch(memberAccessChoice) {
					
					case 1: //******** (1) MEMBER LOGIN ************************************************************************************************************************************************************************************************
											
							//===AUTHENTICATION ==================================================================================================================
							if(file.isFile()) {
								ois = new ObjectInputStream(new FileInputStream(memsPassFile));       //read into the file & load it into our collection 
								memsPass = (ArrayList<Member>)ois.readObject();
								ois.close();
								int password =-1;	
								boolean found = false;
								boolean auth = false;
								int p1=0;
								String n1="";
								System.out.println("-----------------------------------------------------------------------------------");
								System.out.println("Enter Membership Number: ");
								int membershipNumber = s.nextInt();
								System.out.println("Enter login password: ");
								password = s.nextInt();
								System.out.println("----------------------------------------------------------------------------------");
								li = memsPass.listIterator();
								while(auth != true) {
									while(li.hasNext()) {
										Member e = (Member) li.next();
										if(e.getMembershipNumber() == membershipNumber) {
											p1 = e.getPassword();
											n1 = e.getName();
										}
									}//while hasNext
										if(p1!= password) {
										System.out.println("Invalid password, please re-enter password");
										password = s.nextInt();
										}else if(password == 0){
											System.out.println("Program terminated");
											System.exit(0);
										}else {
											System.out.println("Login Successful.");
											auth = true;
										}
								}//while unless password is right then can go out  
								System.out.println(auth);
								
								//===AUTHENTICATION =============================================================================================================
								
								//===MEMBER ACCESS =============================================================================================================
								
								int InnerMemberAccessChoice = -1;
								
								
								System.out.println("\n\n==============================================================================================================================");
								System.out.println("                                                    MEMBER ACCESS                              ");
								System.out.println("==============================================================================================================================");
								
								System.out.println("\n\n=============================================================================================================================");
								System.out.println("     > Your Profile                        ");
								System.out.println("=============================================================================================================================");
								System.out.println("Name             Email              Phone Number      Membership No      Membership Status");
								System.out.println("------------------------------------------------------------------------------------------------------------------------------");
								
								
								if(file.isFile()) {
									ois = new ObjectInputStream(new FileInputStream(file));       //read into the file & load it into our collection 
									mems = (ArrayList<Member>)ois.readObject();
									ois.close();
										
									
									li = mems.listIterator();
									while(li.hasNext()) {
											Member e = (Member) li.next();
											if(e.getMembershipNumber() == membershipNumber) {
												System.out.println(e);		
										}
									}
								}
								//===AUTHENTICATION ^^^==================================================================================================================
								
								//===DISPLAY BOOK MEMBER LOANING ==================================================================================================================
								if(file.isFile()) {
									ois2 = new ObjectInputStream(new FileInputStream(bkfile));       //read into the file & load it into our collection 
									bk = (ArrayList<Book>)ois2.readObject();
									ois2.close();
										
									
									System.out.println("------------------------------------------------------------------------------------------------------------------------------");
									System.out.println("\n\n=============================================================================================================================");
									System.out.println("     > BOOKS YOU BORROW                             ");
									System.out.println("=============================================================================================================================");
									System.out.println("Title                        Author                   status                       index                      location       ");
									System.out.println("------------------------------------------------------------------------------------------------------------------------------");
									li = bk.listIterator();
									while(li.hasNext()) {
											Book e = (Book) li.next();
											if (e.getMembershipNumber() == membershipNumber) {
													if(e.isStatus() == false) {
														System.out.println(e);
														break;
													}
											}	
									}
								}
								System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
								//====================================================================================================================================
								
								
								System.out.println("\n(1)Edit Profile   \n(0)Return to Main Menu");
								System.out.print("\nEnter Selection: ");
								InnerMemberAccessChoice = s.nextInt();
								
								
								
								System.out.println("\n\n========================================================================================");
								while(auth == true) {
									switch(InnerMemberAccessChoice)
									{
									case 1: //======== (1) Edit Profile ===============
										
									if(file.isFile()) {
										ois = new ObjectInputStream(new FileInputStream(file));       //read into the file & load it into our collection 
										mems = (ArrayList<Member>)ois.readObject();
										ois.close();
											
										found = false;
										
										
										System.out.println("---------------------------------------------------------");
										li = mems.listIterator();
										while(li.hasNext()) {
												Member e = (Member) li.next();
												if(e.getMembershipNumber() == membershipNumber) {
													System.out.println("Enter new profile name: ");
													String name = s1.next();
													System.out.println("Enter new profile email: ");
													String email = s1.next();
													System.out.println("Enter new profile phone number: ");
													int phoneNumber = s.nextInt();
												
													boolean membershipStatus = true;
													
													li.set(new Member(name,email,phoneNumber,membershipNumber,membershipStatus));
													
													found = true;
												}	
										}
										if(found) {
											oos = new ObjectOutputStream(new FileOutputStream(file));
											oos.writeObject(mems);
											oos.close();
											System.out.println("---------------------------------------------------------");
											System.out.println("Record Updated Successfully...!");
										}else {
											System.out.println("Record Not Found...!");
											}
										System.out.println("---------------------------------------------------------");
										}else {
											System.out.println("File does not exist...!");
										}
											
										break; //============================================================================================================================================================
										
										}
										
										auth = false;
										}//while auth
									
									}//ISFILE.FILE
										break;
										
				case 2://******** (2)Sign Up As Member *****************************************************************************************************************************************************************************************************************
														
															
									
									//AUTOMATE MEMBERSHIPNUMBER ALLOCATION
									if(file.isFile()) {
										ois = new ObjectInputStream(new FileInputStream(file));       //read into the file & load it into our collection 
										mems = (ArrayList<Member>)ois.readObject();
										ois.close();
											
										
										li = mems.listIterator();
										Member e = mems.get(mems.size() -1);
										int index = e.getMembershipNumber()+1;
										
									 //========================================================
										System.out.println("=================================================================================");
										System.out.println("                           MEMBER ACCOUNT SIGN UP");
										System.out.println("=================================================================================");
										
										System.out.print("\nEnter name: ");
										String name = s1.next();
										
										System.out.print("Enter email: ");
										String email = s1.next();
										
										System.out.print("Enter Phone No: ");
										int phoneNumber = s.nextInt();
										
										int membershipNumber = index;
										System.out.println("=================================================================================");
										System.out.println("              Great Mr/Ms "+name+"!, Sign up successful! you are now a member! \n\n                   your Membership Number: "+ index);
										System.out.println("=================================================================================");
										//AUTO SET NEW MEMBER's STATUS to TRUE
										boolean membershipStatus = true;
										
										System.out.print("\nOne last thing! Complete your setup with a new password for your account! \n\npassword: ");
										int password = s.nextInt();
										
										
										mems.add(new Member(name,email,phoneNumber,membershipNumber,membershipStatus));
                                     
										memsPass.add(new Member(membershipNumber,password));

								
								}
								oos = new ObjectOutputStream(new FileOutputStream(file));                        
								oos.writeObject(mems);                                                              //Arraylist will be written to file
								oos.close();
								
								oos = new ObjectOutputStream(new FileOutputStream(memsPassFile));                        
								oos.writeObject(memsPass);                                                              //Arraylist will be written to file
								oos.close();
								
							break; //======================================================= CREATE NEW PROFILE =============================================================================
												
											}// SWITCH - memberAccessChoice
									break;
//=====================(2) DISCOVER BOOKS ==============================================================================================================================================================================================================
			case 2:
				
				int selection = -1;
				do{
				
					System.out.println("==========================");
					System.out.println("       DISCOVER BOOKS");
					System.out.println("==========================");
					
					System.out.println("(1) Add New Book  \n(2) Update Existing Book \n(3) Search \n(4) Display All Books \n(0) Return to Main Menu");
					System.out.print (" \nSelection: ");
					
					
					selection = s.nextInt();
					
					
				
							switch(selection) {
										//========= SUB (4)- (1) Add New Book =================================================================================================================================================
									case 1:	
										
									
										System.out.println("\nEnter number of books you wish to add to record: ");
										int o = s.nextInt();
										for(int i=0;i<o;i++) {
											System.out.println("\nEnter book name: ");
											String title = s1.nextLine();
											
											System.out.println("Enter author: ");
											String author = s1.nextLine();
											
											System.out.println("Enter book index number: ");
											int index = s.nextInt();
											
											//NEW BOOK WILL BE AVAILABLE ONCE REGISTERED BY DEFAULT
											boolean status = true;
											
											//IF BOOK AVAILABLE IN LIBRARY SET TO DEFAULT LIBRARY MEMBERSHIP NUMBER
											int membershipNumber = 11000666;
						
											bk.add(new Book(title,author,status,index,membershipNumber));
											}
										
										
										oos2 = new ObjectOutputStream(new FileOutputStream(bkfile));                        
										oos2.writeObject(bk);                                                              //Arraylist will be written to file
										oos2.close();
									break;
									//============ SUB (4)- (2) Update Existing Book ==============================================================================================================================================
									case 2:
										if(file.isFile()) {
											ois2 = new ObjectInputStream(new FileInputStream(bkfile));       //read into the file & load it into our collection 
											bk = (ArrayList<Book>)ois2.readObject();
											ois2.close();
												
											boolean found = false;
											System.out.print("Enter book index number to update: ");
											int index = s.nextInt();
											System.out.println("---------------------------------------------------------");
											li = bk.listIterator();
											while(li.hasNext()) {
													Book e = (Book) li.next();
													if(e.getIndex() == index) {
														System.out.println("\nEnter book name: ");
														String title = s1.nextLine();
														
														System.out.println("Enter author: ");
														String author = s1.nextLine();
														
														System.out.println("Enter book index number: ");
														index = s.nextInt();
														
														//NEW BOOK WILL BE AVAILABLE ONCE REGISTERED BY DEFAULT
														boolean status = true;
														
														//IF BOOK AVAILABLE IN LIBRARY SET TO DEFAULT LIBRARY MEMBERSHIP NUMBER
														int membershipNumber = 11000666;
														
														li.set(new Book(title,author,status,index,membershipNumber));
														
														found = true;
													}	
											}
											if(found) {
												oos2 = new ObjectOutputStream(new FileOutputStream(bkfile));
												oos2.writeObject(bk);
												oos2.close();
												System.out.println("---------------------------------------------------------");
												System.out.println("Record Updated Successfully...!");
											}else {
												System.out.println("Record Not Found...!");
												}
											System.out.println("---------------------------------------------------------");
											}else {
												System.out.println("File does not exist...!");
											}
									
									break;
									//============== SUB (4)- (3) Search ============================================================================================================================================
									case 3:
										
													if(file.isFile()) {
															ois2 = new ObjectInputStream(new FileInputStream(bkfile));       //read into the file & load it into our collection 
															bk = (ArrayList<Book>)ois2.readObject();
															ois2.close();
																
															boolean found = false;
															System.out.println("------------------------------------------------------------------------------------------------------------------------------");
															System.out.println("Enter book index number to search: ");
															int index = s.nextInt();
															System.out.println("------------------------------------------------------------------------------------------------------------------------------");
															li = bk.listIterator();
															while(li.hasNext()) {
																	Book e = (Book) li.next();
																	if(e.getIndex() == index) {
																		System.out.println(e);
																		found = true;
																		
																	}	
															}
															if(!found)
																System.out.println("Record Not Found...!");
															System.out.println("-------------------------------------------------------------------------------------------------------------------------------\n\n");
															}else {
																System.out.println("File does not exist...!");
															}
										
										
									
									break;
									//=============== SUB (4) - (4) Display all books  ===========================================================================================================================================
									case 4: 
										if(file.isFile()) {
											ois2 = new ObjectInputStream(new FileInputStream(bkfile));       //read into the file & load it into our collection 
											bk = (ArrayList<Book>)ois2.readObject();
											ois2.close();
											
										System.out.println("============================================================================================================================");
										System.out.println("Title                        Author                   status                       index                      location       ");
										System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
										li = bk.listIterator();
										while(li.hasNext())
												System.out.println(li.next());
										
										System.out.println("-----------------------------------------------------------------------------------------------------------------------------\n\n\n");
										}else {
											System.out.println("File does not exist...!");
										}
									break;
									//==========================================================================================================================================================
						
						
						
					}
				}while(selection!=0);
					
			
			break;
//=====================(3) Access Book Loan Function ==============================================================================================================================================================================================================
			case 3:
				
				//MEMBER LOGIN
				if(file.isFile()) {
					ois = new ObjectInputStream(new FileInputStream(memsPassFile));       //read into the file & load it into our collection 
					memsPass = (ArrayList<Member>)ois.readObject();
					ois.close();
					int password =-1;	
					boolean found = false;
					boolean auth = false;
					int p1=0;
					String n1= "";
					System.out.println("-----------------------------------------------------------------------------------");
					System.out.println("Enter Membership Number: ");
					int membershipNumber = s.nextInt();
					System.out.println("Enter login password: ");
					password = s.nextInt();
					System.out.println("----------------------------------------------------------------------------------");
					li = memsPass.listIterator();
					while(auth != true) {
						while(li.hasNext()) {
							Member e = (Member) li.next();
							if(e.getMembershipNumber() == membershipNumber) {
								p1 = e.getPassword();
								n1 = e.getName();
							}
						}//while hasNext
							if(p1!= password) {
							System.out.println("Invalid password, please re-enter password");
							password = s.nextInt();
							}else if(password == 0){
								System.out.println("Program terminated");
								System.exit(0);
							}else {
								System.out.println("login successful");
								auth = true;
							}
					}//while unless password is right then can go out  
					System.out.println(auth);
				
				//============= LOGIN ===============================================
				
				

				//============= DISPLAY BOOKS =======================================
					if(file.isFile()) {
						ois2 = new ObjectInputStream(new FileInputStream(bkfile));       //read into the file & load it into our collection 
						bk = (ArrayList<Book>)ois2.readObject();
						ois2.close();
						
					System.out.println("\n-------------------------------------------------------------------------------------------------------------------------");
					System.out.println("LOAN A BOOK");
					System.out.println("\n-------------------------------------------------------------------------------------------------------------------------");
						
					System.out.println("\n\n============================================================================================================================");
					System.out.println("\t Title                      Author                status                       index                      location       ");
					System.out.println("-----------------------------------------------------------------------------------------------------------------------------");
					li = bk.listIterator();
					while(li.hasNext())
							System.out.println(li.next());
					
					System.out.println("-----------------------------------------------------------------------------------------------------------------------------\n\n\n");
					}else {
						System.out.println("File does not exist...!");
					}
			
					
					int menu = 0;
					System.out.println("(1) LOAN BOOK \n(2)RETURN BOOK");
					menu = s.nextInt();
					
					int index= 0;
					System.out.print("\nEnter book index number: ");
					System.out.println("\n-------------------------------------------------------------------------------------------------------------");
					index = s.nextInt();
					
					
					System.out.println("----------------------------------------------------------------------------------------------------------------");
					
					switch(menu) {
					case 1:
					
					
							
							li = bk.listIterator();
							while(li.hasNext()) {
									Book e = (Book) li.next();
									if(e.getIndex() == index) {
										
										String title = e.getTitle();
										String author =  e.getAuthor(); 
										//BOOK WILL BE UNAVAILABLE ONCE MEMBER LOAN IT
										boolean status = false;
										//LOAN BOOK SET TO TAG TO MEMBER MEMBERSHIP NUMBER
										
										
		
										li.set(new Book(title,author,status,index,membershipNumber));
										
										found = true;
									}	
							}
							if(found) {
								oos2 = new ObjectOutputStream(new FileOutputStream(bkfile));
								oos2.writeObject(bk);
								oos2.close();
								System.out.println("---------------------------------------------------------");
								System.out.println("Book loan Successfully registered...!");
							}else {
								System.out.println("Record Not Found...!");
								}
							System.out.println("---------------------------------------------------------");
					break;
					case 2: //============================================================================================================
							li = bk.listIterator();
							while(li.hasNext()) {
									Book e = (Book) li.next();
									if(e.getIndex() == index) {
										
										String title = e.getTitle();
										String author =  e.getAuthor(); 
										//BOOK WILL BE AVAILABLE ONCE MEMBER RETURN IT
										boolean status = true;
										//LOAN BOOK SET TO TAG TO LIBRARY MEMBERSHIP NUMBER
										membershipNumber = 11000666;
										
		
										li.set(new Book(title,author,status,index,membershipNumber));
										
										found = true;
									}	
							}
							if(found) {
								oos2 = new ObjectOutputStream(new FileOutputStream(bkfile));
								oos2.writeObject(bk);
								oos2.close();
								System.out.println("---------------------------------------------------------");
								System.out.println("Book return Successfully registered...!");
							}else {
								System.out.println("Record Not Found...!");
								}
							System.out.println("---------------------------------------------------------");
					
					break;
					}
				}		
	
					
				
				
				
				//SELECT BOOK TO LOAN 
				    //- SET BOOK MEMBERSHIP NUMBER TO USER's MEMBERSHIP NUMBER
				    //- SET BOOK STATUS AS ON LOAN 
				
				//RETURN TO DISPLAY BOOK 
					
				
			break;
			
			
//=====================(4) Library Administration [*Admin Login Required] ==============================================================================================================================================================================================================
			case 4:
				
				
								//============================================================================================= ADMINISTRATION =============================
								if(file.isFile()) {
									ois = new ObjectInputStream(new FileInputStream(adPfile));       //read into the file & load it into our collection 
									adP = (ArrayList<Admin>)ois.readObject();
									ois.close();
									int password =-1;	
									boolean found = false;
									boolean auth = false;
									int p1=0;
									System.out.println("-----------------------------------------------------------------------------------");
									System.out.println("Enter staffNumber: ");
									int staffNumber = s.nextInt();
									System.out.println("Enter login password: ");
									password = s.nextInt();
									System.out.println("----------------------------------------------------------------------------------");
									li = adP.listIterator();
									while(auth != true) {
										while(li.hasNext()) {
											Admin e = (Admin) li.next();
											if(e.getStaffNumber() == staffNumber) {
												p1 = e.getPassword();
											}
										}//while hasNext
											if(p1!= password) {
											System.out.println("Invalid password, please re-enter password");
											password = s.nextInt();
											}else if(password == 0){
												System.out.println("Program terminated");
												System.exit(0);
											}else {
												System.out.println("login successful");
												auth = true;
											}
									}//while unless password is right then can go out  
									System.out.println(auth);
									
												while(auth == true) //while - ADMINISTRATION OPTION //***************************************************************************************************
												{
													
													System.out.println("\n\n===============================");
													System.out.println("   Administration ");
													System.out.println("===============================");
													
													System.out.println("\n\n(1) Create New Library Admin profile");
													System.out.println("(2) Display All Admin's Profile ");
													System.out.println("(3) Display All Member's Profile");
													System.out.println("(4) Edit Existing Member/Admin Profile");  
													System.out.println("(5) Search Member/Admin Profile");
													System.out.println("\n\n(0) Return to main menu");
													
													
													System.out.print("\nEnter Selection: ");
													int InChoice =-1;
													InChoice = s.nextInt();
													
													switch(InChoice)
													{
													case 1: //======= (1) Create New Library Admin profile ===========================================================================================================================
														System.out.println("\n\n(1) Create New Library Admin profile");
														
														System.out.println("Enter how many profile you wish to add: ");
														int m = s.nextInt();
														for(int i=0;i<m;i++) {
															System.out.print("\nEnter admin name: ");
															String name = s1.next();
															
															System.out.print("Enter admin email: ");
															String email = s1.next();
															
															System.out.print("Enter admin Phone No: ");
															int phoneNumber = s.nextInt();
															
															System.out.print("Enter admin staff number");
															staffNumber = s.nextInt();
															
															System.out.print("Enter admin staff login password ");
															password = s.nextInt();
															
															System.out.print(name + "'s admin profile created successfully! ");
															
															
															admin.add(new Admin(name,email,phoneNumber,staffNumber));
															adP.add(new Admin(staffNumber,password));
															
														}
														oos = new ObjectOutputStream(new FileOutputStream(adminfile));                        
														oos.writeObject(admin);                                                              //Arraylist will be written to file
														oos.close();
														
														oos = new ObjectOutputStream(new FileOutputStream(adPfile));                        
														oos.writeObject(adP);                                                              //Arraylist will be written to file
														oos.close();
														
													
													
													break; //========== (1) Create New Library Admin profile ========================================================================================================================
													
													case 2: //========= (2) Display All Admin's Profile =========================================================================================================================
														if(file.isFile()) {
															ois = new ObjectInputStream(new FileInputStream(adminfile));       //read into the file & load it into our collection 
															admin = (ArrayList<Admin>)ois.readObject();
															ois.close();
															
														System.out.println("===================================================================");
														System.out.println("Name        Email               Phone Number      Membership No    ");
														System.out.println("-------------------------------------------------------------------");
														li = admin.listIterator();
														while(li.hasNext())
																System.out.println(li.next());
														
														System.out.println("------------------------------------------------------------------");
														}else {
															System.out.println("File does not exist...!");
														}
													break;//=========== (2) Display All Admin's Profile =======================================================================================================================
													
													case 3: //========= (3) Display All Member's Profile =========================================================================================================================
														if(file.isFile()) {
															ois = new ObjectInputStream(new FileInputStream(file));       //read into the file & load it into our collection 
															mems = (ArrayList<Member>)ois.readObject();
															ois.close();
															
														System.out.println("==========================================================================================");
														System.out.println("Name             Email              Phone Number      Membership No      Membership Status");
														System.out.println("------------------------------------------------------------------------------------------");
														li = mems.listIterator();
														while(li.hasNext())
																System.out.println(li.next());
														
														System.out.println("------------------------------------------------------------------------------------------");
														}else {
															System.out.println("File does not exist...!");
														}
														
													break; //=========== (3) Display All Member's Profile =======================================================================================================================
													
													case 4: //========== (4) Edit Member/Admin Profile ========================================================================================================================
														
														System.out.println("\n========================================= ");
														System.out.println(" Edit Profile  ");
														System.out.println("========================================== ");
														
														
														System.out.println("(1) Admin's Profile");
														System.out.println("(2) Member's Profile");
														
														System.out.println("\n\n(0) Return back to Administration");
														
														int InChoice2 = 0;
														
														System.out.print("\nEnter Selection: ");
														InChoice2 = s.nextInt();
														
														switch(InChoice2)  //================ (12) Library Administration >> (4) Edit Member/Admin Profile >> =====================================
														{
														case 1://=============================(12) Library Administration >> (4) Edit Member/Admin Profile >> (1) Admin Profile ======================================
															System.out.println("\n>>>>> Admin Profile ");
															
															//display admin Profile
															if(file.isFile()) {
																ois = new ObjectInputStream(new FileInputStream(adminfile));       //read into the file & load it into our collection 
																admin = (ArrayList<Admin>)ois.readObject();
																ois.close();
																
															System.out.println("===================================================================");
															System.out.println("Name        Email               Phone Number      Membership No    ");
															System.out.println("-------------------------------------------------------------------");
															li = admin.listIterator();
															while(li.hasNext())
																	System.out.println(li.next());
															
															System.out.println("------------------------------------------------------------------");
															}else {
																System.out.println("File does not exist...!");
															}
															
															
															
															
																		//UPDATE OR DELETE
																		System.out.println("\n\n(1) Update \n(2) Delete ");
																		
																		int InnerChoice2 = -1;
																		System.out.print("\nEnter Selection: ");
																		InnerChoice2 = s.nextInt();
																		
																		switch(InnerChoice2) 
																		{
																		
																		case 1: //=========(12) Library Administration >> (4) Edit Member/Admin Profile >> (2) Admin's Profile >> (1) UPDATE  ======================================
																			if(file.isFile()) {
																				ois = new ObjectInputStream(new FileInputStream(adminfile));       //read into the file & load it into our collection 
																				admin = (ArrayList<Admin>)ois.readObject();
																				ois.close();
																					
																				found = false;
																				System.out.print("\nEnter staff number to update: ");
																				staffNumber = s.nextInt();
																				System.out.println("---------------------------------------------------------");
																				li = admin.listIterator();
																				while(li.hasNext()) {
																						Admin e = (Admin) li.next();
																						if(e.getStaffNumber() == staffNumber) {
																							System.out.print("\nEnter admin name: ");
																							String name = s1.next();
																							
																							System.out.print("Enter admin email: ");
																							String email = s1.next();
																							
																							System.out.print("Enter admin Phone No: ");
																							int phoneNumber = s.nextInt();
																							
																							System.out.print("Enter admin staff number:");
																							staffNumber = s.nextInt();
																							
																							System.out.print("Enter admin staff login password: ");
																							password = s.nextInt();
																							
																							System.out.print(name + "'s admin profile created successfully! ");
																							
																							
																							li.set(new Admin(name,email,phoneNumber,staffNumber));

																							found = true;
																						}	
																				}
																				if(found) {
																					oos = new ObjectOutputStream(new FileOutputStream(adminfile));
																					oos.writeObject(admin);
																					oos.close();
																					
																					System.out.println("---------------------------------------------------------");
																					System.out.println("Record Updated Successfully...!");
																				}else {
																					System.out.println("Record Not Found...!");
																					}
																				System.out.println("---------------------------------------------------------");
																				}else {
																					System.out.println("File does not exist...!");
																				}
																		break;
																		
																		case 2: //=========(12) Library Administration >> (4) Edit Member/Admin Profile >> (2) Admin's Profile >> (2) DELETE  ======================================
																			if(file.isFile()) {
																				ois = new ObjectInputStream(new FileInputStream(adminfile));       //read into the file & load it into our collection 
																				admin = (ArrayList<Admin>)ois.readObject();
																				ois.close();
																					
																				found = false;
																				System.out.print("\nEnter staff number to delete: ");
																				staffNumber = s.nextInt();
																				System.out.println("---------------------------------------------------------");
																				li = admin.listIterator();
																				while(li.hasNext()) {
																						Admin e = (Admin) li.next();
																						if(e.getStaffNumber() == staffNumber) {
																							li.remove();
																							found = true;
																						}	
																				}
																				if(found) {
																					oos = new ObjectOutputStream(new FileOutputStream(adminfile));
																					oos.writeObject(admin);
																					oos.close();
																					System.out.println("Record Deleted Successfully...!");
																				}else {
																					System.out.println("Record Not Found...!");
																					}
																				System.out.println("---------------------------------------------------------");
																				}else {
																					System.out.println("File does not exist...!");
																				}
																		break;
																		
																		}
															
											
																		
															
														break;//============== (1) Admin Profile ====================================================================================================================
														
														case 2://=============================(12) Library Administration >> (4) Edit Member/Admin Profile >> (2) Member's Profile ======================================
															System.out.println("\n>>>>> Member's Profile ");
															
															//display Member Profile
															if(file.isFile()) {
																ois = new ObjectInputStream(new FileInputStream(file));       //read into the file & load it into our collection 
																mems = (ArrayList<Member>)ois.readObject();
																ois.close();
																
															System.out.println("==========================================================================================");
															System.out.println("Name             Email              Phone Number      Membership No      Membership Status");
															System.out.println("------------------------------------------------------------------------------------------");
															li = mems.listIterator();
															while(li.hasNext())
																	System.out.println(li.next());
															
															System.out.println("------------------------------------------------------------------------------------------");
															}else {
																System.out.println("File does not exist...!");
															}
															
																		//UPDATE OR DELETE
																		System.out.println("\n\n(1) Update \n(2) Delete ");
																		
																		int InnerChoice3 = -1;
																		System.out.print("\nEnter Selection: ");
																		InnerChoice3 = s.nextInt();
																		
																		switch(InnerChoice3) 
																		{
																		case 1: //=========(12) Library Administration >> (4) Edit Member/Admin Profile >> (2) Member's Profile >> (1) UPDATE  ======================================
																			if(file.isFile()) {
																				ois = new ObjectInputStream(new FileInputStream(file));       //read into the file & load it into our collection 
																				mems = (ArrayList<Member>)ois.readObject();
																				ois.close();
																					
																				found = false;
																				System.out.print("\nEnter membership number to update: ");
																				int membershipNumber = s.nextInt();
																				System.out.println("---------------------------------------------------------");
																				li = mems.listIterator();
																				while(li.hasNext()) {
																						Member e = (Member) li.next();
																						if(e.getMembershipNumber() == membershipNumber) {
																							System.out.println("Enter new profile name: ");
																							String name = s1.next();
																							System.out.println("Enter new profile email: ");
																							String email = s1.next();
																							System.out.println("Enter new profile phone number: ");
																							int phoneNumber = s.nextInt();
																						
																							boolean membershipStatus = true;
																							System.out.println("New profile: " + name + " is now a member! ");
																							li.set(new Member(name,email,phoneNumber,membershipNumber,membershipStatus));
																							
																							found = true;
																						}	
																				}
																				if(found) {
																					oos = new ObjectOutputStream(new FileOutputStream(file));
																					oos.writeObject(mems);
																					oos.close();
																					System.out.println("---------------------------------------------------------");
																					System.out.println("Record Updated Successfully...!");
																				}else {
																					System.out.println("Record Not Found...!");
																					}
																				System.out.println("---------------------------------------------------------");
																				}else {
																					System.out.println("File does not exist...!");
																				}
																		break;
																		
																		case 2: //=========(12) Library Administration >> (4) Edit Member/Admin Profile >> (2) Member's Profile >> (2) DELETE  ======================================
																			if(file.isFile()) {
																				ois = new ObjectInputStream(new FileInputStream(file));       //read into the file & load it into our collection 
																				mems = (ArrayList<Member>)ois.readObject();
																				ois.close();
																					
																				found = false;
																				System.out.print("\nEnter membership number to delete: ");
																				int membershipNumber = s.nextInt();
																				System.out.println("---------------------------------------------------------");
																				li = mems.listIterator();
																				while(li.hasNext()) {
																						Member e = (Member) li.next();
																						if(e.getMembershipNumber() == membershipNumber) {
																							li.remove();
																							found = true;
																						}	
																				}
																				if(found) {
																					oos = new ObjectOutputStream(new FileOutputStream(file));
																					oos.writeObject(mems);
																					oos.close();
																					System.out.println("Record Deleted Successfully...!");
																				}else {
																					System.out.println("Record Not Found...!");
																					}
																				System.out.println("---------------------------------------------------------");
																				}else {
																					System.out.println("File does not exist...!");
																				}
																		break;
																		
																		}
															
														break;//========(1) Member's Profile==========================================================================================================================
														case 0: 
															break;
															
														
															
														
														}
														
													break; //==================================================================================================================================
													
													case 5: //==================================================================================================================================
														
														System.out.println("\n\nSearch: ");
														System.out.println("(1) Admin's Profile - [IN PROGRESS] ");
														System.out.println("(2) Member's Profile");
														
														InChoice2 = 0;
														
														System.out.print("\nEnter Selection: ");
														InChoice2 = s.nextInt();
														
														switch(InChoice2)
														{
														case 1:
															System.out.println("(1)Search Admin's Profile ");
															
														break;
														
														case 2:
															System.out.println("(2)Search Member's Profile ");
															
															if(file.isFile()) {
																ois = new ObjectInputStream(new FileInputStream(file));       //read into the file & load it into our collection 
																mems = (ArrayList<Member>)ois.readObject();
																ois.close();
																	
																found = false;
																System.out.println("-----------------------------------------------------------------------------------");
																System.out.println("Enter membership number to search: ");
																int membershipNumber = s.nextInt();
																System.out.println("----------------------------------------------------------------------------------");
																li = mems.listIterator();
																while(li.hasNext()) {
																		Member e = (Member) li.next();
																		if(e.getMembershipNumber() == membershipNumber) {
																			System.out.println(e);
																			found = true;
																		}	
																}
																if(!found)
																	System.out.println("Record Not Found...!");
																System.out.println("-----------------------------------------------------------------------------------");
																}else {
																	System.out.println("File does not exist...!");
																}
															
														break;
														}
														
														
														
													break; //==================================================================================================================================
													
													case 0: //==================================================================================================================================
														
														auth = false;
													break;
													
													}//while - ADMINISTRATION OPTION ***************************************************************************************************
										
									}
									
								}//if file exist		
								//============================================================================================= ADMINISTRATION =============================
				
			break;
			case 6:

				if(file.isFile()) {
					ois = new ObjectInputStream(new FileInputStream(file));       //read into the file & load it into our collection 
					mems = (ArrayList<Member>)ois.readObject();
					ois.close();
						
					boolean found = false;
					li = mems.listIterator();
					Member e = mems.get(mems.size() -1);
					System.out.println(e.getMembershipNumber());
					int membershipNumber = e.getMembershipNumber()+1;
					System.out.println(membershipNumber);
					
					if(!found)
						System.out.println("Record Not Found...!");
					System.out.println("-----------------------------------------------------------------------------------");
					}else {
						System.out.println("File does not exist...!");
					}
					
				
				
			break;	
			case 99: //========================= NEW UPDATE & FEARTURES ====================================================================================================
				
			    
			break;//========================================================================================================================================================
			}//MAIN switch
			
			
			
		}while(choice!=0);
		
		
		
		
		
		
		
		
		

	}

}
