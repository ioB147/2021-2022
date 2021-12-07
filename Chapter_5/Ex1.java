package Chapter_5;

import java.util.*;


class Point2D {
	int width, height, area, perimeter;

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public Point2D(int width, int height){
		this.width = width;
		this.height = height;
	}
	
	public Point2D() {}
	public Point2D Input() {
		Scanner kb = new Scanner(System.in);
		System.out.print("Enter width= ");
		width = kb.nextInt();
		System.out.print("Enter height= ");
		height = kb.nextInt();

		Point2D point2d = new Point2D(width, height);
		return point2d;
	}
}

class Rectangle2D {
	Point2D size;
	
	int area, perimeter;
	
	public Point2D getSize() {
		return size;
	}
	
	public void getSize(Point2D size) {
		this.size = size;
	}
	
	public Rectangle2D() {}
	
	public Rectangle2D(Point2D size) {
		this.size = size;
	}
	
	public Rectangle2D Input() {
		Scanner kb = new Scanner(System.in);
		
		size = new Point2D().Input();
		
		Rectangle2D rectangle2d = new Rectangle2D(size);
		
		return rectangle2d;
	}
	
	public int area() {
		this.area = size.getWidth()*size.height;
		return area;
	}
	
	public int perimeter() {
		this.perimeter = (size.height+size.width)*2;
		return perimeter;
	}

	public void display() {
		System.out.println("Area= "+this.area);
		System.out.println("Perimeter= "+this.perimeter);
	}
}
public class Ex1 {
	public static void main(String[] args) {
		Rectangle2D h1 = new Rectangle2D().Input();
		h1.area();
		h1.perimeter();
		h1.display();

	}

}
