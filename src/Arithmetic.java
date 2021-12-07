
public class Arithmetic {

public static void main ( String [] arg)
{
int num = 5, num1 = 12, num2 = 20, result;
result = num + num1;
System.out.println("Sum of num and num1 is : (num + num1) " + result);
result = num % num1;
System.out.println("Modulus of num and num1 is : (num % num1) " + result);
result *= num2;
System.out.println("Product of result and num2 is : (result *= num2) " + result);
System.out.println("Value of num before the operation is : " + num);
num ++;
System.out.println("Value of num after ++ operation is : " + num);
double num3 = 25.75, num4 = 14.25, res;
res = num3 - num4;
System.out.println("num3 – num4 is : " +res);
res -= 2.50;
System.out.println("res -= 2.50 " + res);
System.out.println("Value of res before -- operation is : "+ res);
res--;
System.out.println("Value of res after -- operation is : " + res);
}
}