package Chuong4;

import java.util.Arrays;
import java.util.Scanner;

public class Ex8 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int arr[] = new int[n];
		System.out.print("Input an array of integers: ");
		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
			}
		 
		int x = arr[0];
		arr[0] = arr[arr.length-1];
		arr[arr.length-1] = x;
		System.out.println("New array after swaping: "+Arrays.toString(arr)); 
	}

}
