package Chuong4;

import java.util.*;
public class Ex15 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int arr[][] = new int[8][8];
		for (int i = 0; i<8; i++)
		{
			for (int j = 0; j<8; j++)
			{
			    System.out.print("Enter the element [" + i + ", " + j + "]: ");
	            arr[i][j] = kb.nextInt();
			}
		}
		
		System.out.println("Entered matrix : ");
		for (int i = 0; i < 8; i++) 
		{
            for (int j = 0; j < 8; j++) {
                System.out.print(arr[i][j] + "\t");
            }
		}
		System.out.println("\n");
	}
}