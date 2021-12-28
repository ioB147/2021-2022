package ATMproject;
import java.util.*;
import java.util.ArrayList;

public class Bank {
	
	private String name;
	
	private ArrayList<User> users;
	
	private ArrayList<Account> accounts;
	
	
	
	
	public String getNewUserUID()
	{
		String userid;
		Random rng = new Random();
		int len = 6;
		boolean nonUnique = false;
		
		
		
		return userid;
	}
	
	public String getNewAccountUID()
	{
		return null;
	}
	
	public void addAccount(Account anAcc)
	{
		this.accounts.add(anAcc);
	}
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
