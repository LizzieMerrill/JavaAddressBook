public class Entry {
	//instance variables
	private String firstName;
	private String lastName;
	private long phoneNumber;
	private String emailAddress;
	
	//getter methods
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public long getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getEmailAddress() {
		return emailAddress;
	}
	
	//setter methods
	public void setFirstName(String name) {
		firstName = name;
	}
	
	public void setLastName(String name) {
		lastName = name;
	}
	
	public void setPhoneNumber(long num) {
		phoneNumber = num;
	}
	
	public void setEmailAdress(String email) {
		emailAddress = email;
	}
	
	//constructors
	public Entry() {
		firstName = "";
		lastName = "";
		phoneNumber = -1;
		emailAddress = "";
	}
	
	public Entry(String first, String last, long phone, String email) {
		firstName = first;
		lastName = last;
		phoneNumber = phone;
		emailAddress = email;
	}
	
	//toString method
	public String toString() {
		String result;
		result = "\n************" + "\nFirst Name: " + firstName + "\nLast Name: " + lastName + "\nPhone Number: " + phoneNumber + "\nEmail: " + emailAddress + "\n************\n";
		return result;
	}
}
