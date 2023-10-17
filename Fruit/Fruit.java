//Daniel Chavez
public class Fruit implements Comparable<Fruit>{
String name;
double weight;
//public constructor
public Fruit(String name, double weight) {
	this.name = name;
	if(weight >= 0) {
		this.weight = weight;
	}
}
//default constructor
public Fruit() {
	name = "apple";
	weight = 1.0;
}
//get name
public String getName() {
	return name;
}
//set name
public void setName(String name) {
	this.name = name;
}
//get weight
public double getWeight() {
	return weight;
}
//set weight
public void setWeight(double weight) {
	this.weight = weight;
}
//compareTo
public int compareTo(Fruit fruit) {
	int check = 0;
	if(fruit.getName().equalsIgnoreCase("apple") || fruit.getName().equalsIgnoreCase("orange") || fruit.getName().equalsIgnoreCase("banana")
		|| fruit.getName().equalsIgnoreCase("kiwi") || fruit.getName().equalsIgnoreCase("tomato")) {
		if(this.getWeight() > fruit.getWeight())
			check = 1;
		else if(this.getWeight() < fruit.getWeight())
			check = -1;
		else if(this.getWeight() == fruit.getWeight()) {
			check = this.getName().compareTo(fruit.getName());
		}
	}
	else
		check = -1;
	
	return check;
}
//print
public String toString() {
	return "Type: " + this.name + " Weight:" + this.weight;
}
}