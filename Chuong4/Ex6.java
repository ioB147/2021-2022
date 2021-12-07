package Chuong4;
import java.util.*;
import java.util.Scanner;
public class Ex6 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter the number of elements of the array: ");
		int n = kb.nextInt();
		int[] arr = new int[n];
		System.out.print("Input an array of integers: ");
		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
		}
		for (int i = 0; i < arr.length; i++)   
		{  
		for (int j = i + 1; j < arr.length; j++)   
		{  
		int tmp = 0;  
		if (arr[i] < arr[j])   
		{  
		tmp = arr[i];  
		arr[i] = arr[j];  
		arr[j] = tmp;  
		}  
	}  
 
		System.out.print(arr[i]+" ");  
		}  
		
	}
}
