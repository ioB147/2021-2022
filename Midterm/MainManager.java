package Midterm;

import java.util.*;
import java.text.ParseException;
import java.util.Date;

public class MainManager extends Personnel
{
	private double coefficient;

	public double getCoefficient() {
		return coefficient;
	}

	public void setCoefficient(double coefficient) {
		this.coefficient = coefficient;
	}

	public MainManager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MainManager(String name, Date birthday, double salary, double coefficient) {
		super(name, birthday, salary);
		this.coefficient = coefficient;
		// TODO Auto-generated constructor stub
	}
	
public MainManager Input() throws ParseException
{
	super.InputPersonnel();
	System.out.println("Enter the coefficient: ");
	double coefficient = Double.parseDouble(kb.nextLine());
	return new MainManager(this.getName(), this.getBirthday(), this.getSalary(), coefficient);
}
	
	public long Sum0fSalary()
	{
		long sum;
		return sum = (long) (this.getSalary() + coefficient)*1150000;
	}
	
	public String toString()
	{
		return super.toString() + " Coefficient: " + this.coefficient + " Sum of salary: " + Sum0fSalary();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
