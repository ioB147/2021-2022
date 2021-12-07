public class Ex13 {

	public static void main(String[] args) {
		for(int i = -3; i < 4; i++)
		{
		for (int j=0; j< (3 - Math.abs(i)); j++)
		{
			System.out.print("   ");
		}
		for (int j=0; j< (Math.abs(i)*2 + 4); j++)
		{
		System.out.print("*  ");
		}
		System.out.println();
		}
	}

}
