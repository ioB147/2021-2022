package Chuong6;

class Shape
{
	public void draw()
	{
		System.out.println("...drawing Shape");
	}
}
class Circle extends Shape // a circle is a shape
{
	//do nothing but inherits the method draw()
	public void draw() //overriding method draw
	{
		System.out.println("...drawing Circle");
	}
	
}
class Rectangle extends Shape  //a rectangle is a shape
{
	//do nothing but inherits the method draw()
	public void draw() //overriding method draw
	{
		System.out.println("...drawing Rectangle");
	}	
}

public class FunctionOverriding {

	public static void main(String[] args) {
	
		Shape S,C,R;
		
		S= new Shape();
		C = new Circle();
		R = new Rectangle();
		
		S.draw();
		C.draw();
		R.draw();
	}
}

