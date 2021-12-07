package Chuong4;
import java.util.*;
public class Ex7 {

	public static void main(String[] args) {
		Scanner kb = new Scanner(System.in);
		int n = kb.nextInt();
		int arr[] = new int[n];
		System.out.print("Input an array of integers: ");
		for (int i = 0; i < n; i++) {
			arr[i] = kb.nextInt();
	}
System.out.println (arr.length >= 2 && arr[0] == arr[arr.length-1]);
	}
}
