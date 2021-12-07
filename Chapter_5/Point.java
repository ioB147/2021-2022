package Chapter_5;

public class Point {

	private int x,y;//attributes
	
	//constructor
	public Point()//default constructor with no parameter
	{
	  	System.out.println("Constructor Point() is called automatically");
		x=0;
		y=0;
	}
	
	public Point (int x)
	{
		this.x = x;
		y = 0;
	}
	
	
	public void display()
	{
		System.out.println("("+x+","+y+")");
	}
	
	public static void main(String[] args) {
		
		Point O1 = new Point();

		Point O = new Point(100);
		
		O1.display();

		O.display();
	}

}