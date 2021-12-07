package Chuong6;

/*Polymorphism = Many forms

a method has many forms of parameters--> Function overloading
- you can define many functions with the same name 
                             but different parameters
*/
public class FunctionOverloading {

	public static void print(String s)
	{
		System.out.println(s);
	}
	public static void print(double s)
	{
		System.out.println(s);
	}	
	public static void print(String s, double d)
	{
		System.out.println(s + d);
	}	
	public static void main(String[] args) {		
	
		

		FunctionOverloading.print("Hello");
		FunctionOverloading.print(183833.9);
		FunctionOverloading.print("Hello",183833.9);
		
		
	}

}