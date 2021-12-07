package Chuong4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Ex16 {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		String arr[] = new String[n];

		System.out.println("Input an array: ");
		List<String> list = Arrays.asList(arr);
		for (int i = 0; i < n; i++) 
		{
			arr[i] = kb.next(); 
		}
		System.out.println("Array list: "+list);
	}

}
