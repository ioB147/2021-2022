package Chuong4;
import java.util.*;
public class Ex3 {
	public static int count_Words(String str) {
		int count=1;
		for (int i=0; i<str.length(); i++)
		{
			if (str.charAt(i)==' ') count++;
		}
		return count;
	}
	public static void main(String[] args) {
		Scanner kb= new Scanner(System.in);
		System.out.print("Input a string: ");
		String str = kb.nextLine();
		System.out.println("Number of words in the string: "+count_Words(str));
			
		
	}

}
