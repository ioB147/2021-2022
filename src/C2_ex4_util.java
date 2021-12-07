import java.util.ArrayList;
import java.util.Collections; //need collections class to sort 
public class C2_ex4_util {

	public static void main(String[] args) {
		//1 Add Items
		ArrayList<String> cars = new ArrayList<String>();
	    cars.add("Volvo");
	    cars.add("BMW");
	    cars.add("Ford");
	    cars.add("Mazda");
	    	System.out.println(cars);
	    //2 Access an Item
	    	System.out.println(cars.get(0));
	    //3 Change an Item
	    cars.set(0, "Vinfast");
	    	System.out.println(cars);
	    //4 Sort an ArrayList
	        Collections.sort(cars);
	        for (String i : cars) {
	          System.out.println(i);
	        }
	    //5 Remove an Item
	    cars.remove(3);
	    	System.out.println(cars);
	    //6 ArrayList Size
	    	System.out.println(cars.size());
	    //7 Loop Through an ArrayList
	        for (String i : cars) {
	            System.out.println("7: "+i);
	        }
	    //8 ArrayList isEmpty()
	        System.out.println(cars.isEmpty());
	    //9 Checking if the specified element exists in the given list or not.
	        System.out.println(cars.contains("BMW"));
		//10 Remove all
		    cars.clear();
		    System.out.println(cars);
	}

}
