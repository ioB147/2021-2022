package Chuong4;

import java.util.Scanner;

public class Ex20 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Input String:");
		String s1 = kb.nextLine();
		System.out.print("Input the specified Substring:");
		String s2 = kb.nextLine();
		
		System.out.println("Check if a given string contains the specified substring: "+s1.contains(s2));

	}

}
