class Rectangle {

	float width, height;
	
	public Rectangle(float width, float height) {
		this.width = width;
		this.height = height;
	}
	
		public float area() {
			return this.width * this.height;
	}

}

public class ex6 {
	public static void main(String[] args) {
		Rectangle rectangle = new Rectangle(2.0f, 5.0f);
		float area = rectangle.area();
		System.out.println("Area: " + area);
		

	}
}