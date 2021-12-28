package Midterm;

import java.util.*;
import java.text.ParseException;
import java.util.Date;


public class Employee extends Personnel
{
	private String placeWorking;

	public String getPlaceWorking() {
		return placeWorking;
	}

	public void setPlaceWorking(String placeWorking) {
		this.placeWorking = placeWorking;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, Date birthday, double salary) {
		super(name, birthday, salary);
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, Date birthday, double salary, String placeWorking) {
		super(name, birthday, salary);
		this.placeWorking = placeWorking;
	}
	
	public Employee Input() throws ParseException
	{
		super.InputPersonnel();
		System.out.println("Enter place of working: ");
		String placeWorking = kb.nextLine();
		return new Employee(this.getName(), this.getBirthday(), this.getSalary(), placeWorking);
	}
	
	public String toString()
	{
		return super.toString() + " Place of work: " + placeWorking;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
