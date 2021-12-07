package Chuong4;

import java.util.*;
public class Ex13 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int arr[] = new int[n];
		System.out.print("Input an array of integers: ");
		for (int i = 0; i < n; i++)
		{
			arr[i] = kb.nextInt();
		}
		for (int i = arr.length-1; i>=0; i--)
		{
			System.out.print(arr[i]+" ");
		}

	}

}
