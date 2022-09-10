import java.util.Scanner;
import java.util.ArrayList;

public class AddressBook {
	public static void main(String[] args) {
		ArrayList<Entry> addressBook = new ArrayList<Entry>();
		printMenu(addressBook);
	}//end of main
	
	//prints menu and executes switch case
	public static void printMenu(ArrayList<Entry> addressBook) {
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("1) Add an entry");
		System.out.println("\n2) Remove an entry");
		System.out.println("\n3) Search for a specific entry");
		System.out.println("\n4) Print Address Book");
		System.out.println("\n5) Delete Book");
		System.out.println("\n6) Quit");
		System.out.print("\nPlease choose what you'd like to do with the database: ");
		
		int choice = scnr.nextInt();
		
		switch(choice) {
		case 1:
			printMenu(addEntry(addressBook));
			break;
		case 2:
			printMenu(removeEntry(addressBook));
			break;
		case 3:
			printMenu(searchEntries(addressBook));
			break;
		case 4:
			printMenu(printBook(addressBook));
			break;
		case 5:
			printMenu(deleteBook(addressBook));
			break;
		case 6:
			System.exit(0);//exits program
		default:
			System.out.println("Invalid input, try again!");
			printMenu(addressBook);
			break;
		}//end of switch case
	}//end of printMenu method
	
	//adds entry
	public static ArrayList<Entry> addEntry(ArrayList<Entry> addressBook) {
		Scanner scnr = new Scanner(System.in);
		
		System.out.print("\nFirst Name: ");
		String firstName = scnr.next();
		System.out.print("\nLast Name: ");
		String lastName = scnr.next();
		System.out.print("\nPhone Number: ");
		long phoneNumber = scnr.nextLong();
		System.out.print("\nEmail Address: ");
		String emailAddress = scnr.next();
		
		Entry entry = new Entry(firstName, lastName, phoneNumber, emailAddress);
		addressBook.add(entry);
		System.out.println("\nAdded new entry!\n");
		
		return addressBook;
	}
	
	//removes entry
	public static ArrayList<Entry> removeEntry(ArrayList<Entry> addressBook) {
		Scanner scnr = new Scanner(System.in);
		
		System.out.print("\nEnter an entry's email to remove: ");
		String emailToRemove = scnr.next();
		//for post-removal checking purposes
		int size = addressBook.size();
		
		for(int i = 0; i < addressBook.size(); ++i) {
			if(addressBook.get(i).getEmailAddress().equals(emailToRemove) == true) {
				System.out.println("\nDeleted the following entry:");
				System.out.print(addressBook.get(i).toString() + "\n");
				addressBook.remove(i);
			}
		}
		
		//if list size hasn't changed/deletion didn't take place
		if(size == addressBook.size()) {
			System.out.println("\nEntry not found!\n");
		}
		return addressBook;
	}
	
	//searches for an entry
	public static ArrayList<Entry> searchEntries(ArrayList<Entry> addressBook) {
		Scanner scnr = new Scanner(System.in);
		
		System.out.println("\n1) First Name");
		System.out.println("\n2) Last Name");
		System.out.println("\n3) Phone Number");
		System.out.println("\n4) Email Adress");//typo in grader test case, so I copied it to maintain exactness
		System.out.print("\nChose a search type: ");//typo in grader test case, so I copied it to maintain exactness
		String choice = scnr.nextLine();
		
		switch(choice) {
		case "1"://first name
			int outputChecker1 = 0;
			System.out.print("\nEnter your search: ");
			String fName = scnr.next();
			for(int i = 0; i < addressBook.size(); ++i) {
				if(addressBook.get(i).getFirstName().contains(fName) == true) {
					System.out.print(addressBook.get(i).toString());
					outputChecker1++;
				}
			}
			//if nothing was found
			if(outputChecker1 == 0) {
				System.out.println("\nNo results found!\n");
			}
			return addressBook;
			
		case "2"://last name
			int outputChecker2 = 0;
			System.out.print("\nEnter your search: ");
			String lName = scnr.next();
			for(int i = 0; i < addressBook.size(); ++i) {
				if(addressBook.get(i).getLastName().contains(lName) == true) {
					System.out.print(addressBook.get(i).toString());
					outputChecker2++;
				}
			}
			//if nothing was found
			if(outputChecker2 == 0) {
				System.out.println("\nNo results found!\n");
			}
			return addressBook;
		case "3"://phone number
			int outputChecker3 = 0;
			System.out.print("\nEnter your search: ");
			String phoneSearched = scnr.next();
			for(int i = 0; i < addressBook.size(); ++i) {
				//converts phone num in current entry to string for string comparison
				String actualPhone = String.valueOf(addressBook.get(i).getPhoneNumber());
				if(actualPhone.contains(phoneSearched) == true) {
					System.out.print(addressBook.get(i).toString());
					outputChecker3++;
				}
			}
			//if nothing was found
			if(outputChecker3 == 0) {
				System.out.println("\nNo results found!\n");
			}
			return addressBook;
		case "4"://email address
			int outputChecker4 = 0;
			System.out.print("\nEnter your search: ");
			String email = scnr.next();
			for(int i = 0; i < addressBook.size(); ++i) {
				if(addressBook.get(i).getEmailAddress().contains(email) == true) {
					System.out.print(addressBook.get(i).toString());
					outputChecker4++;
				}
			}
			//if nothing was found
			if(outputChecker4 == 0) {
				System.out.println("\nNo results found!\n");
			}
			return addressBook;
		default:
			System.out.println("\nInvalid search option.\n");
			return addressBook;
		}
	}
	
	//prints whole address book
	public static ArrayList<Entry> printBook(ArrayList<Entry> addressBook) {
		if (addressBook.isEmpty() == true) {
			System.out.println("\nAddress Book is empty! \n");
			return addressBook;
		}
		else {
			for(int i = 0; i < addressBook.size(); ++i) {
				System.out.print(addressBook.get(i).toString());
			}
			System.out.print("\n");
			return addressBook;
		}
	}
	
	//deletes whole address book
	public static ArrayList<Entry> deleteBook(ArrayList<Entry> addressBook) {
		addressBook.clear();
		System.out.println("\nAddress book cleared!\n");
		return addressBook;
	}
}//end of class
