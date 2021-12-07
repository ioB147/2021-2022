
public class Ex15 {

	public static void main(String[] args) {
		int i, j;
		for (i=-3; i<= 3; i++)
		{
		for (j=0; j < Math.abs(i); j++)
		{
			System.out.print("    ");	
		}
		for (j=0; j < 7-2*Math.abs(i); j++)
		{
			System.out.print("*   ");
		}
		System.out.println();
	}
	}
}
