import java.util.*;
public class LoopExample {

	public static void main(String[] args) {
        
		Scanner sc = new Scanner(System.in);
		int m,n,k, j=2;
	    long f=1, t=1;
	   
	    do 
		{
			System.out.print("Input your n number: ");
			n = sc.nextInt();
			
		}while (n<=0);		
	    do 
		{
			System.out.print("Input your m number: ");
			m = sc.nextInt();
			
		}while (m<=0);		
		do 
		{
			System.out.print("Input your k number: ");
			k = sc.nextInt();
			
		}while (k<=0);		
	    for(int i=1;i<=k;i++) {
			t*=m;
		}
		while(j<=n) {
			f*=j;
			j++;
					
		}
		System.out.println(n+"! + "+m+"^"+k + "= "+(f+t));
	
	}
}