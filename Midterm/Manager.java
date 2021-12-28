package Midterm;

import java.util.*;
import java.text.ParseException;
import java.util.Date;

public class Manager extends Personnel
{
	private int quantity0femployee;

	public int getQuantity0femployee() {
		return quantity0femployee;
	}

	public void setQuantity0femployee(int quantity0femployee) {
		this.quantity0femployee = quantity0femployee;
	}

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(String name, Date birthday, double salary) {
		super(name, birthday, salary);
		// TODO Auto-generated constructor stub
	}

	public Manager(String name, Date birthday, double salary, int quantity0femployee) {
		super(name, birthday, salary);
		this.quantity0femployee = quantity0femployee;
	}
	
	public Manager Input() throws ParseException
	{
		super.InputPersonnel();
		System.out.println("Enter the quantity need to manage: ");
		int quantity0femployee = Integer.parseInt(kb.nextLine());
		return new Manager(this.getName(), this.getBirthday(), this.getSalary(), quantity0femployee);
	}
	
	public String toString() {
        return super.toString() + " Quantity: " + this.quantity0femployee;
	}

	public long Sum0fSalary() {
		long sum;
		return sum = (long) (this.getSalary())*1150000;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
