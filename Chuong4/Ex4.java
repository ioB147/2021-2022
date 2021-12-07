package Chuong4;
import java.util.*;
public class Ex4 {
	
	public static void main(String[] args) {
		int i,sum=0;
		Scanner kb=new Scanner(System.in);
		System.out.print("Enter an integer: ");
		i=kb.nextInt();
		while (i!=0) {
			sum+=i%10;
			i=i/10;
		}
		System.out.println("Sum of the digits= "+sum);
	}
}
