//Daniel Chavez
public class Triangle extends Shape{
	public static final double HALF = 0.5;
	double base;
	double height;
	String rightTriangle = "right triangle";
	//default constructor
	public Triangle() {
		base = 1;
		height = 1;
	}
	//public constructor
	public Triangle(double xBase, double xHeight) {
		if(xBase > 0 && xHeight>0) {
			this.base = xBase;
			this.height = xHeight;
		}
	}
	//get base
	public double getBase() {
		return base;
	}
	//set base
	public void setBase(double base) {
		this.base = base;
	}
	//get height
	public double getHeight() {
		return height;
	}
	//set height
	public void setHeight(double height) {
		this.height = height;
	}
	//get area
	public double getArea() {
		double area = HALF*this.getBase()*this.getHeight();
		return area;
	}
	//get Name
	public String getName() {
		return this.rightTriangle;
	}
	//compareTo
	public int compareTo(Shape t) {
		int check = 0;
		if(this.getArea()> t.getArea())
			check  = 1;
		else if(this.getArea()< t.getArea())
			check = -1;
		else if(this.getArea() == t.getArea()) {
			if(t.getName().equals("circle"))
				check = -1;
			else if(t.getName().equals("rectangle"))
				check = -1;
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