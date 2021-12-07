package Chuong6;

/*write a prog to manage a university,
Manage?
- students
- teacher
..
*/
import java.util.*;
class Person
{
	private String name;
	private String address;
	private Date birthday;
    public Person()
    {
    	
    }
	public Person(String name, String address, Date birthday)
   {
	this.name=name;
	this.address=address;
	this.birthday=birthday;
   }
	public String getName()
	{
		return this.name;		
	}
	public String getAddress()
	{
		return this.address;		
	}
	public Date getBirthday()
	{
		return this.birthday;		
	}
}

class Student extends Person
{
 	String ID;
	double GPA;
  public Student()
  {
	  
  }
public Student(String name, String address, Date birthday, String id, double GPA)
{
	super(name,address, birthday);//call the constructor of superclass/Person
	this.ID=id;
	this.GPA=GPA;
	
}
public void display()
{
	System.out.println(this.getName()+", "+this.getAddress()+
			", "+this.getBirthday()+", "+this.ID+", "+this.GPA);
}

	
	//methods...	
}
class Teacher extends Person
{
	//
	String domain;
	float salary;
	  public Teacher()
	  {
		  
	  }
	public Teacher(String name, String address, Date birthday, String domain, float salary)
	{
		super(name,address, birthday);
		this.domain=domain;
		this.salary=salary;
		
	}
	public void display()
	{
		System.out.println(this.getName()+", "+this.getAddress()+
				", "+this.getBirthday()+", "+this.domain+", "+this.salary+"$.");
	}


}

public class InheritanceExample {
public static void main(String[] args)
{
	Student O = new Student("Jonh", "Danang", new Date(1990),"VKU01",8.9f);
	O.display();
	/*your responsibility is to complete Teacher
	 
	 Teacher T = new Teacher(....);
	 T.display();
	 
	 * */
	Teacher T = new Teacher("Ken","Hue",new Date(1985),"GIT",800f);
	T.display();
	
}
}
