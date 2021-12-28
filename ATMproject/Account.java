package ATMproject;
import java.util.*;
import java.util.ArrayList;

public class Account {
	private String name;
	

	
	private String userid;
	
	private User holder;
	
	private ArrayList<Transaction> transactions;
	
	public Account(String name, User holder, Bank theBank)
	{
		
		this.name = name;
		this.holder = holder;
		
		//	get new acc UID
		this.userid = theBank.getNewAccountUID();
		
		//	init transactions
		this.transactions = new ArrayList<Transaction>();
		
		//	add to holder and bank lists
		holder.addAccount(this);
		theBank.addAccount(this);
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
