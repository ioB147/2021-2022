package Midterm;

import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Personnel {
		Scanner kb = new Scanner(System.in);
		
		private String name;
		private Date birthday;
		private double salary;
		
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Date getBirthday() {
			return birthday;
		}
		public void setBirthday(Date birthday) {
			this.birthday = birthday;
		}
		public double getSalary() {
			return salary;
		}
		public void setSalary(double salary) {
			this.salary = salary;
		}
		public Personnel(String name, Date birthday, double salary) {
			super();
			this.name = name;
			this.birthday = birthday;
			this.salary = salary;
		}
		public Personnel() {
			super();
		}
		
		public void InputPersonnel() throws ParseException
		{

	        System.out.print("Enter name: ");
	        this.name = kb.nextLine();
	        System.out.print("Enter birthday: ");
	        SimpleDateFormat df = new SimpleDateFormat("dd/mm/yyyy");
	        this.birthday = df.parse(kb.nextLine());
	        System.out.print("Enter the salary: ");
	        this.salary = Double.parseDouble(kb.nextLine());
		}
		
		public String toString()
		{
			return "Name: " + this.name + " Birthday: " + this.birthday + " Salary: " + this.salary;
		}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
