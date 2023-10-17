//Daniel Chavez
public class Rectangle extends Shape{
	double length;
	double width;
	String rectangle = "rectangle";
	//default constructor
	public Rectangle() {
		length = 1;
		width  = 1;
	}
	//public constructor
	public Rectangle(double length, double width) {
		if(length > 0 && width > 0) {
			this.length = length;
			this.width = width;
		}
	}
	//get length
	public double getLength() {
		return length;
	}
	//set length
	public void setLength(double length) {
		this.length = length;
	}
	//get width
	public double getWidth() {
		return width;
	}
	//set width
	public void setWidth(double width) {
		this.width = width;
	}
	//get area
	public double getArea() {
		double area = this.getLength() * this.getWidth();
		return area;
	}//get name
	public String getName() {
		return this.rectangle;
	}//compareTo
	public int compareTo(Shape t) {
		int check = 0;
		if(this.getArea() > t.getArea())
			check  = 1;
		else if(this.getArea() < t.getArea())
			check = -1;
		else if(this.getArea() == t.getArea()) {
			if(t.getName().equals("circle"))
				check = -1;
			else if(t.getName().equals("triangle"))
				check = 1;
			else if(t.getName().equals(this.getName()))
				check = 0;
		}
	return check;
	}
	//toString
	public String toString() {
		return "Shape: " + this.getName() + " Area: " + this.getArea();
	}
	
}