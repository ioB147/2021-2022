import java.lang.Character;
public class C2_ex1 {

	public static void main(String[] args) {
		//1 boolean isLetter
		 System.out.println(Character.isLetter('A')); 
	     System.out.println(Character.isLetter('0'));
	     //2 boolean isDigit
	     System.out.println(Character.isDigit('A')); 
         System.out.println(Character.isDigit('0'));
         //3 boolean isWhitespace
         System.out.println(Character.isWhitespace('A')); 
         System.out.println(Character.isWhitespace(' ')); 
         System.out.println(Character.isWhitespace('\n')); 
         System.out.println(Character.isWhitespace(9)); //tab ngang
         System.out.println(Character.isWhitespace('9')); 
         //4 boolean isUpperCase
         System.out.println(Character.isUpperCase('A'));
         System.out.println(Character.isUpperCase('a'));
         System.out.println(Character.isUpperCase(65));
         //5 boolean isLowerCase
         System.out.println(Character.isLowerCase('A')); 
         System.out.println(Character.isLowerCase('a')); 
         System.out.println(Character.isLowerCase(97));
         //6 char toUpperCase
         System.out.println(Character.toUpperCase('a')); 
         System.out.println(Character.toUpperCase(97)); 
         System.out.println(Character.toUpperCase(48));
         //7 char toLowerCase
         System.out.println(Character.toLowerCase('A')); 
         System.out.println(Character.toLowerCase(65)); 
         System.out.println(Character.toLowerCase(48)); 
         //8 toString
         System.out.println(Character.toString('x')); 
         System.out.println(Character.toString('Y')); 
         //9 String toString
         char ch = 'R';
         System.out.println(Character.toString(ch));
         //10 Character.isLetterOrDigit
         char c1 = 'D', c2 = '/';
         boolean bool1 = Character.isLetterOrDigit(c1);
         System.out.println(c1 + " is a letter/digit ? " + bool1);
         boolean bool2 = Character.isLetterOrDigit(c2);
         System.out.println(c2 + " is a letter/digit ? " + bool2);
	}

}
