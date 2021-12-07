import java.util.Random;
public class C2_ex3 {

	public static void main(String[] args) {
		Random generator = new Random();
		//1
		System.out.println("Random Integer: "+generator.nextInt());
		//2
		System.out.println("Random long: "+generator.nextLong());
		//3
		System.out.println("Random float: "+generator.nextFloat());
		//4
		System.out.println("Random double: "+generator.nextDouble());
		//5
		System.out.println("Random Boolean : "+generator.nextBoolean());
		//6
		byte[] bytes = "namphuc.org".getBytes(); 
		System.out.println("Before Random Bytes : " + new String(bytes));
		generator.nextBytes(bytes);
		System.out.println("After Random Bytes : " + new String(bytes));
		//7 generate a random 6 digit code
		int code = (int) Math.floor(((Math.random() * 899999) + 100000));
		System.out.println(code);
		//8 Random numbers from 1 to 4
		int r1 = generator.nextInt(4) + 1;
		System.out.println(r1);
		//9 Randomly a line with an angle from 0 to 360 degrees
		double r2 = generator.nextDouble() * 360.0;
		System.out.println(r2);
		//10 Random int number within the specified range.
		int r3 = generator.nextInt((10 - 5) + 1) + 5;
							  // (max - min)+ 1 ) + min
		System.out.println(r3);
		
	}

}
