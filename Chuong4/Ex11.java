package Chuong4;

import java.util.*;

public class Ex11 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int arr1[] = new int[n];
		System.out.print("Input a given array of integers: ");
		for (int i = 0; i < n; i++) {
			arr1[i] = kb.nextInt();
			}
		System.out.println("Given array: "+Arrays.toString(arr1));
		int arr2[] = new int[arr1.length];
		for (int i = 0; i < arr1.length; i++) {
			arr2[i]=arr1[i];
		}
System.out.println("A new array from a given: "+Arrays.toString(arr2));
	}

}
