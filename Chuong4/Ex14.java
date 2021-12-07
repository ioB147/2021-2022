package Chuong4;

import java.util.*;
public class Ex14 {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		String arr1[] = new String[n];
		String arr2[] = new String[n];
		System.out.println("Input two arrays: ");
		for (int i = 0; i < n; i++) 
			arr1[i] = kb.next(); 
		for (int i = 0; i < n; i++)
			arr2[i] = kb.next();
		System.out.println("Array 1: "+Arrays.toString(arr1));
		System.out.println("Array 2: "+Arrays.toString(arr2));
		
		HashSet<String> set = new HashSet<String>();
		
		for (int i = 0; i < arr1.length; i++)
		{
			for (int j = 0; j < arr2.length; j++)
			{
				if (arr1[i].equals(arr2[j]))
				{
					set.add(arr1[i]);
				}
			}
		}
		System.out.print("Conmmon elements: "+set);
	}

}
