package Midterm;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Manage {

	public static void main(String[] args) throws ParseException {
		Scanner scanner = new Scanner(System.in);
		//	Main Manager
	    System.out.print("Enter the quantity of main manager: ");
	    int mainManager = scanner.nextInt();
	    MainManager[] m = new MainManager[mainManager];
	    for(int i = 0; i<mainManager; i++)
	    {
	    	MainManager m1 = new MainManager();
	    	m1.Input();
	    	m[i] = m1;
	    }
	    //	Manager
	    System.out.print("Enter the quantity of manager: ");
	    int manager = scanner.nextInt();
	    Manager[] m2 = new Manager[manager];
	    for(int i = 0; i<manager; i++)
	    {
	        m2[i] = new Manager().Input();
	    }
	    //	Employee
	    System.out.print("Enter the quantity of employee: ");
	    int e = scanner.nextInt();
	    Employee[] employees = new Employee[e];
	    for(int i = 0; i<e; i++)
	    {
	        employees[i] = new Employee().Input();
	    }
	    
	    // Display list of personnel
	    // Main Manager
	    System.out.println("*\tInformation of main manage\t*");
	    for(int i = 0; i < m.length  ; i++)
	    {
	        System.out.println(m[i].toString());
	    }
	    // Manager
	    System.out.println("\tList of managers: ");
	    for(int i = 0; i<m2.length; i++)
	    {
	        System.out.println(m2[i].toString());
	    }
	    // List of employee
	    System.out.println("\tList of employees: ");
	    for(int i = 0; i<employees.length; i++)
	    {
	        System.out.println(employees[i].toString());
	    }

//	    // Display manager who have highest sum of salary
//	    System.out.println("========================================================");
//	    System.out.println("\tDisplay the manager have highest salary");
//	    long max = m2[0].Sum0fSalary();
//	    int i, position = 0; // 
//	    for(i = 0; i<m2.length; i++)
//	    {
//	        if(m2[i].Sum0fSalary() > max)
//	        {
//	            max = m2[i].Sum0fSalary();
//	            position = i;
//	        }
//	    }
//	    System.out.println(m2[position].toString());
	    
//	    // display the person have the month of birth is 12 
//	    System.out.println("\tDisplay the person have the month of birth is 12");
//	    Arrays.stream(m).filter(month ->Integer.parseInt(new SimpleDateFormat("mm").format(month.getBirthday())) == 12 )
//	    .collect(Collectors.toList()).forEach(System.out::println);
	    

	    
	    
//	    // display the person have place of work is OOP
//	    System.out.println("\tDisplay the person have place of work is OOP");
//	    Arrays.stream(employees).filter(p -> p.getPlaceWorking().equals("OOP")).collect(Collectors.toList()).forEach(System.out::println);
	//    
	//    
	//    
	//    
//	    //	display the person have firt name is Nguyen
//	    System.out.println("\tDisplay the person have firt name is Nguyen");
//	    Arrays.stream(employees).filter(name -> name.getName().startsWith("Nguyen")).collect(Collectors.toList()).forEach(System.out::println);
	    
	    System.out.println("\n*****\tDisplay the manager who have the birthday in November*****");
	    Arrays.stream(m2).filter(month ->Integer.parseInt(new SimpleDateFormat("mm").format(month.getBirthday())) == 11)
	    .collect(Collectors.toList())
	    .forEach(System.out::println);

	}

}
