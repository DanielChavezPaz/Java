/*
 * Daniel Chavez
 */
public class Fruit implements Comparable<Fruit>{
String name;
double weight;
//public constructor
public Fruit(String xName, double xWeight) {
	name = xName;
	if(xWeight >= 0) {
		weight = xWeight;
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
public int compareTo(Fruit aFruit) {
	int check = 0;
	if(aFruit.getName().equalsIgnoreCase("apple") || aFruit.getName().equalsIgnoreCase("orange") || aFruit.getName().equalsIgnoreCase("banana")
		|| aFruit.getName().equalsIgnoreCase("kiwi") || aFruit.getName().equalsIgnoreCase("tomato")) {
		if(this.getWeight() > aFruit.getWeight())
			check = 1;
		else if(this.getWeight() < aFruit.getWeight())
			check = -1;
		else if(this.getWeight() == aFruit.getWeight()) {
			check = this.getName().compareTo(aFruit.getName());
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
