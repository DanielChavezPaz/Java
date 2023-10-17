//Daniel Chavez
public class Circle extends Shape {
	public static final double PI = 3.14159265358979;
	double radius;
	String circle = "circle";
	//default constructor
	public Circle() {
		radius = 1;
	}
	//public constructor
	public Circle(double radius) {
		if(radius > 0) {
			this.radius = radius;
		}
	}
	//get radius
	public double getRadius() {
		return radius;
	}
	//set radius
	public void setRadius(double radius) {
		this.radius = radius;
	}
	//get area
	public double getArea() {
		double area = this.radius*this.radius*PI;
		return area;
	}
	//get name
	public String getName() {
		return this.circle;
	}
	//compareTo
	public int compareTo(Shape t) {
		int check = 0;
		if(this.getArea() > t.getArea())
			check  = 1;
		else if(this.getArea() < t.getArea())
			check = -1;
		else if(this.getArea() == t.getArea()) {
			if(t.getName().equals("rectangle"))
				check = 1;
			else if(t.getName().equals("triangle"))
				check = 1;
			else if(t.getName().equals(this.getName()))
				check = 0;
		}
		return check;
	}
	//print
	public String toString() {
		return "Shape: " + this.getName() + " Area: " + this.getArea();
	}
	
}