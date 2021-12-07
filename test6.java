
public class test6 {

	public static void main(String[] args) {
		String s = "Hello Class Java";
		
		int count=0;
		
		for (int i = 0;i < s.length();i++)
		{
			if (s.charAt(i)=='a')
			{
				count++;
			}
		}
		System.out.println("frequency of character a: "+count);
		

		int index = s.indexOf("Java");
		
		if (index !=-1) {
			System.out.println("string contains the word Java");
		} else {
			System.out.println("string not contain the word java");
		}
	
		
		if (s.startsWith("Write"))
		{
			System.out.println("string starts with the word Write");
		} else {
			System.out.println("string not start with the word Write");
		}
		
		
		if (s.endsWith("easily"))
		{
			System.out.println("string ends with the word easily");
		} else {
			System.out.println("string not end with the word easily");
		}
		
		
		
		
	}

}
