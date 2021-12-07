package Chuong4;

public class Ex5 {
	public static long fact (long value) {
		long result=1;
		for (int i=1; i <= value; i++)
		{
			result*=i;
		}
		return result;
	}
	public static void main(String[] args) {
		long arr[]= new long [10];
		for (int i=0; i < 10; i++)
		{
			arr[i]=fact(i+1);
		}
		for (int i=9; i >= 0; i--)
		{
			System.out.println(arr[i]+" ");
		}
		
	}

}
