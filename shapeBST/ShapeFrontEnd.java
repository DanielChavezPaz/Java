//Daniel Chavez
import java.io.*;
import java.util.Scanner;
public class ShapeFrontEnd {
public static final String TAB = "\t";
public static void main(String[]args) {
	LinkedBST shapes = new LinkedBST();
	Scanner keyboard = new Scanner(System.in);
	boolean running = true;
	System.out.println("Welcome to the Shape BST");
	while (running) {
		System.out.println("\nWhat would you like to do?");
		System.out.println("(1) Add a Shape\n" + "(2) Remove a shape\n" + "(3) Search for a shape\n"
						+ "(4) Get shape with max area\n" + "(5) Read a shape file\n" 
						+ "(6) Print your list of shapes\n" + "(7) Exit the program\n");
		int options = keyboard.nextInt();
		switch (options) {
		case 1: //Adding a Shape
			keyboard.nextLine();
			System.out.println("What shape are you looking to add?");
			String shape = keyboard.nextLine().toLowerCase();
			switch(shape){
				case "right triangle":
					System.out.println("What is the base of the Triangle?");
					double base = keyboard.nextDouble();
					System.out.println("What is the height of the Triangle?");
					double height = keyboard.nextDouble();
					Triangle triangle = new Triangle(base, height);
					shapes.add(triangle);
					break;
				case "rectangle":
					System.out.println("What is the length of the Rectangle?");
					double length = keyboard.nextDouble();
					System.out.println("What is the width of the Rectangle?");
					double width = keyboard.nextDouble();
					Rectangle rectangle = new Rectangle(length, width);
					shapes.add(rectangle);
					break;
				case "circle":
					System.out.println("What is the radius of the Circle?");
					double radius  = keyboard.nextDouble();
					Circle circle = new Circle(radius);
					shapes.add(circle);
					break;
				default:
					System.out.println("\nInvalid input\n");
					break;
				}
			break;
		case 2: //removing a shape
			keyboard.nextLine();
			System.out.println("What shape are you currently removing?");
			String shape2 = keyboard.nextLine().toLowerCase();
			switch(shape2) {
			case "right triangle":
				System.out.println("What is the base of the triangle?");
				double base = keyboard.nextDouble();
				System.out.println("What is the height of the triangle?");
				double height = keyboard.nextDouble();
				Triangle triangle = new Triangle(base,height);
				shapes.remove(triangle);
				break;
			case "rectangle":
				System.out.println("What is the length of the rectangle?");
				double length = keyboard.nextDouble();
				System.out.println("What is the height of the rectangle?");
				double width = keyboard.nextDouble();
				Rectangle rectangle = new Rectangle(length, width);
				shapes.remove(rectangle);
				break;
			case "circle":
				System.out.println("What is the radius of the circle?");
				double radius = keyboard.nextDouble();
				Circle circle = new Circle(radius);
				shapes.remove(circle);
				break;
			default:
				System.out.println("\nInvalid input\n");
				break;
			}
			break;
		case 3: //Search for a shape
			try {
			keyboard.nextLine();
			System.out.println("What shape are you currently looking for?");
			String shape3 = keyboard.nextLine().toLowerCase();
			switch(shape3) {
			case "right triangle":
				System.out.println("What is the base of the triangle?");
				double base = keyboard.nextDouble();
				System.out.println("What is the height of the triangle?");
				double height = keyboard.nextDouble();
				Triangle triangle = new Triangle(base , height);
				System.out.println(shapes.search(triangle));
				break;
			case "rectangle":
				System.out.println("What is the length of the rectangle?");
				double length = keyboard.nextDouble();
				System.out.println("What is the height of the rectangle?");
				double width = keyboard.nextDouble();
				Rectangle rectangle = new Rectangle(length , width);
				System.out.println(shapes.search(rectangle));
				break;
			case "circle":
				System.out.println("What is the radius of the circle?");
				double radius = keyboard.nextDouble();
				Circle circle = new Circle(radius);
				System.out.println(shapes.search(circle));
				break;
			default:
				System.out.println("\n Shape not found");
			}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			break;
		case 4: //Max Area
			System.out.println("\n" + shapes.findMax());
			break;
		case 5: //Reading a Shape File
			keyboard.nextLine();
			System.out.println("What's the name of the file?");
			String file = keyboard.nextLine();
			try {
				Scanner fileScanner = new Scanner(new File(file)); //new scanner to read file games
				while(fileScanner.hasNextLine()){
					String textLine = fileScanner.nextLine(); //Separates line from line
					String[] splitLines = textLine.split(TAB); // splits line into array
					if (splitLines[0].equalsIgnoreCase("Rectangle") && splitLines.length == 3)  //Validates line
					{
						double length = Double.parseDouble(splitLines[1]);
						double width = Double.parseDouble(splitLines[2]);
						Rectangle rectangle = new Rectangle(length, width); 
						shapes.add(rectangle);
					}
					else if (splitLines[0].equalsIgnoreCase("Right Triangle") && splitLines.length == 3) {
						double base = Double.parseDouble(splitLines[1]);
						double height = Double.parseDouble(splitLines[2]);
						Triangle rightTriangle = new Triangle(base, height); 
						shapes.add(rightTriangle);
					}
					else if (splitLines[0].equalsIgnoreCase("Circle") && splitLines.length == 2) {
						double radius = Double.parseDouble(splitLines[1]);
						Circle circle = new Circle(radius);
						shapes.add(circle);
					}
				}
			}
			catch(Exception e){
					e.printStackTrace();
			}
			break;
		case 6: //Printing Shapes
			shapes.printPreorder();
			System.out.println();
			shapes.printInorder();
			System.out.println();
			break;
		case 7: //Exit
			System.out.println("Exit");
			System.exit(0);
			break;
		}
	}
	keyboard.close();
}
}