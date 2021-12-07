package Chuong4;

import java.util.*;
public class Ex12 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int arr[] = new int[n];
		System.out.print("Input an array of integers: ");
		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
			}
		Arrays.sort(arr);

	    System.out.println("Maximum number = " 
	         + arr[arr.length - 1] + " Minimum number = " + arr[0]);	
	}

}
