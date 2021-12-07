import java.util.*;

public class new1 {

	public static void main(String[] args) {
		int i=2,n;
		long f=1;
		Scanner keyboard = new Scanner(System.in);
		n=keyboard.nextInt();
		while (i<n)
		{
			f*=i;
			i++;
			System.out.println(f);
		}
	}
}