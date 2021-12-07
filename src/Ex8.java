
public class Ex8 {

	public static void main(String[] args) {
        int sum = 0;
        float avg;
        for(int i = 1; i<= 100; ++i){
            sum+=i;
        }
        avg = (sum/100);
        System.out.println("The average of all integer numbers between 1 and 100= "+avg);
	}

}
