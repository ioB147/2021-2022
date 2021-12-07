import java.util.*;
public class ArrayExample {

	public static void main(String[] args) {
      
		int i;
		//want to store 10 values of mark
		double M[] = new double[10];
		/*
		 equivalent 10 variables 
		 variable names: M[0], M[1],..........M[9]
         */
		Scanner key= new Scanner(System.in);
		
		 for (i=0;i<10;i++)
		 {
			System.out.print("M["+i+"]= "); 
		  M[i]=key.nextDouble();
		 }
		 for (i=0;i<10;i++)
			 System.out.println("M["+i+"]= "+M[i]);
	}	
}