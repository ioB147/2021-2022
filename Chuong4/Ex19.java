package Chuong4;

import java.util.Scanner;

public class Ex19 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Input a String:");
		String str = kb.nextLine();
		
		System.out.println("Length= "+str.length());
		
		System.out.print("Input two specified positions:");
		int m = kb.nextInt();
		int n = kb.nextInt();
		
		String new_str = str.substring(m, n);
		
		System.out.println("A substring form a given:"+new_str);
	}

}
