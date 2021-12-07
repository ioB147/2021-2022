package Chuong4;
import java.util.*;
public class Ex2 {

	public static int count_Vowels(String str)
    {
        int count = 0;
        
        for ( char ch : str.toCharArray()) 
        {
        	ch = Character.toLowerCase(ch);
        if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
            {
                count++;
            }
        }
        return count;
    }
	public static void main(String[] args) {
		Scanner kb= new Scanner(System.in);
		System.out.print("Input a string: ");
		String str = kb.nextLine();
		System.out.println("Number of Vowels in the string: "+count_Vowels(str));
	}

}
