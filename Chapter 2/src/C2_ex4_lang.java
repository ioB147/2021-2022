import java.lang.Runtime;
public class C2_ex4_lang {

	public static void main(String[] args) {
		//1 returns the instance or Runtime object associated with the current Java application
        	Runtime run = Runtime.getRuntime();
        	System.out.println("" + run.freeMemory());
        //2 returns the amount of free memory in the JVM
        	System.out.println("" + Runtime.getRuntime().freeMemory());
        //3 returns the amount of total memory in the JVM
        	System.out.println("" + Runtime.getRuntime().totalMemory());
        //4 returns the number of processors available to the JVM
        	System.out.println("" + Runtime.getRuntime().availableProcessors());
        //5 print the maximum memory
        	System.out.println("" + Runtime.getRuntime().maxMemory());
        	
        	
}
}