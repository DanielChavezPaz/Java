//Daniel Chavez
public class Shape implements Comparable<Shape> {
String name;
double area;
//shape constructor
public Shape(String name, double area) {
	this.setName(name);
	this.setArea(area);
}
//default constructor
public Shape() {
	this.setName("");
	this.setArea(0);
}

//get name
public String getName() {
	return name;
}
//setName
public void setName(String name) {
	this.name = name;
}
//get Area
public double getArea() {
	return area;
}
//set Area
public void setArea(double area) {
	this.area = area;
}
//compareTo method compares area and names
public int compareTo(Shape shape) {
	int check = 0;
	if(this.getArea() > shape.getArea()) 
		check = 1;
	else if(this.getArea() < shape.getArea())
		check = -1;
	else if(this.getArea() == shape.getArea()) {
		check = this.getName().compareTo(shape.getName());
	}
	return check;
}


}
