package Chuong4;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex17 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Input Str1: ");
		String s1 = kb.nextLine();
		System.out.print("Input Str2: ");
		String s2 = kb.nextLine();
		
		int result = s1.compareTo(s2);
		      if (result > 0) {
		         System.out.println("str1 is greater than str2");
		      } else if (result == 0) {
		         System.out.println("str1 is equal to str2");
		      } else {
		         System.out.println("str1 is less than str2");
		      }
	}

}
