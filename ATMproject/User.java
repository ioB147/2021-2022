package ATMproject;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
import java.util.ArrayList;
public class User {
	private String firstName, lastName;
	
	private String userid;
	
	private byte pinHash[];
	
	private ArrayList<Account> accounts;

	
	
	public User(String firstName, String lastName, String pin, Bank theBank)
	{
		this.firstName = firstName;
		this.lastName = lastName;
		
		
		try {
		MessageDigest md = MessageDigest.getInstance("MD5");
		this.pinHash = md.digest(pin.getBytes());
		} catch (NoSuchAlgorithmException e) {
			System.err.println("error, no such Exception");
			e.printStackTrace();
			System.exit(1);
		}
		
		this.userid = theBank.getNewUserUID();
		
		// create empty list of accounts
		this.accounts = new ArrayList<Account>();
		
		// sout in4
		System.out.print("New user: " + this.firstName + " " + this.lastName + " with ID: " + this.userid + " created.\n");
		
	}
	public void addAccount(Account anAcc)
	{
		this.accounts.add(anAcc);
	}








	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
