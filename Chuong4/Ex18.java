package Chuong4;

import java.util.Scanner;

public class Ex18 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Input a given String:");
		String s1 = kb.nextLine();
		System.out.print("Input another String:");
		String s2 = kb.nextLine();
		
		System.out.println("After concatenating: "+s1.concat(s2));
	}

}
