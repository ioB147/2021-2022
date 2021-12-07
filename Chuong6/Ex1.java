package Chuong6;

abstract class Shape {

    // Area
    public abstract double area();

    // Perimeter
    public abstract double perimeter();

    // Draw     
    

    // display 
    public String display()
    {
        return "The area is: " + area() + " The perimeter is: " + perimeter() ;
    }

}

class Rectangle extends Shape {

    private double width, height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Area
    public double area() {
        return width * height;
    }

    // Perimeter
    public double perimeter() {
        return (width + height)*2;
    }
}

class Circle extends Shape {

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    // Area
    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    // Perimeter
    public double perimeter() {
        return Math.PI * radius * 2;
    }
}

class EquilaterialTriangle extends Shape{
    private double edge_one, edge_two, edge_three, triangleHeight;

    public EquilaterialTriangle(double edge_one, double edge_two, double edge_three, double triangleHeight)
    {
        this.edge_one = edge_one;
        this.edge_two = edge_two;
        this.edge_three = edge_three;
        this.triangleHeight = triangleHeight;
    }

    // Check equilaterial triangle

    // Area
    public double area()
    {
        return (edge_one * triangleHeight) * 0.5;
    }

    // Perimeter
    public double perimeter()
    {
        return edge_one + edge_two + edge_three;
    }
}


public class Ex1 {
    public static void main(String[] args) {
        Shape[] vec = {new Circle(2), new Rectangle(4, 5), new EquilaterialTriangle(12, 12, 12, 3)}; // NEW
        
        for(int i = 0; i < vec.length; i++)
        {
            System.out.println(vec[i].display());
        }
    }
}
