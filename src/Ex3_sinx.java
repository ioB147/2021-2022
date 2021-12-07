import java.util.Scanner;

public class Ex3_sinx {

public static void main(String[] args) {
int i, j;
double sinx, x, result_power, cal_factorial;

Scanner scan = new Scanner(System.in);
System.out.print("Input the angle in degrees (0 till 360) : ");
x = scan.nextDouble();

x=(x/180)*(22/7);

System.out.println("Angle in radians : "+x);

sinx = x;
for (i = 2; i <= 100; i++) {

// Calculate the factorial
cal_factorial = 1;
for (j = 2 * i - 1; j >= 1; j--) {
cal_factorial = cal_factorial * j;
}

// Calculate x power
result_power = 1;
for (j = 1; j <= 2 * i - 1; j++) {
result_power *= x;
}

// Calculate amount till tribes to-i
if (i % 2 == 0) // conditions even
{
sinx = sinx - result_power / cal_factorial;
} else {
sinx = sinx + result_power / cal_factorial;
}
}

System.out.println("Sin x according with Maclaurin Series : " + sinx);
System.out.println("Sin x with class in java : " + Math.sin(x));
}
}