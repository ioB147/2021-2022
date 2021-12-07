package Chuong4;

import java.util.*;
public class Ex9 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int arr1[] = new int[n];
		int arr2[] = new int[n];
		System.out.println("Input two array of integers: ");
		for (int i = 0; i < n; i++) 
			arr1[i] = kb.nextInt(); 
		for (int i = 0; i < n; i++)
			arr2[i] = kb.nextInt();
		System.out.println("Array 1: "+Arrays.toString(arr1));
		System.out.println("Array 2: "+Arrays.toString(arr2));
		
		int result[] = new int[arr1.length];
		  
        for (int i = 0; i < arr1.length; i++) 
        	result[i] = arr1[i] * arr2[i];
        
        System.out.print("Result: ");
        for (int i = 0; i < arr1.length; i++)
        {
            System.out.print(result[i] + " ");
		}
	}

}
