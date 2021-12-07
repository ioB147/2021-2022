package Chuong4;

import java.util.Scanner;

public class Ex10 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.println("Input a string and check if it starts with a specified words ");
		String str = kb.nextLine();
		char ch = str.charAt(0);
		if((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z') || (ch >= '0' && ch <= '9')) {
			System.out.println("False");
		} else System.out.println("True");
	}

}
