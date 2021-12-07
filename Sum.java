
public class Sum {

	public double Sumpow (double x, int n)
	   {
        double s = 0; double pow=1;
        for (int i = 1; i<=n;i++) {
            pow = pow*x;
            s=s+pow;
        }
        return s;
    }
	public static void main(String[] args) {
		Sum O = new Sum();
		double s = O.Sumpow(2, 5);
		System.out.println("Sum of 2^1+2^2+...+2^5= "+s);
	}

}
