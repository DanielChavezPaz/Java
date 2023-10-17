//Daniel Chavez
import java.io.File;
import java.util.Scanner;
public class FruitTreeTester {
	public static void main(String[] args) {
	LinkedBST<Fruit> Fruits = new LinkedBST<Fruit>(); //new binary search tree of type fruit
	Scanner keyboard = new Scanner(System.in);
	System.out.println("Welcome to Fruit Tree Tester!\n" + "What's the name of the file?");
	String fileName = keyboard.nextLine();
	try {
		Scanner fileScanner = new Scanner(new File(fileName)); //new scanner to read file games
		while(fileScanner.hasNextLine()) //while file has another line
		{
			String textLine = fileScanner.nextLine(); //Separates line from line
			String [] splitLines = textLine.split("\t");
			String name = splitLines[0];
			double weight = Double.parseDouble(splitLines[1]);
			Fruit temp = new Fruit(name, weight);
			Fruits.add(temp); //add to binary search tree	
		}
	}
	catch(Exception e){
			e.printStackTrace();
	}
	Fruit juicy = new Fruit("Banana",0.006167454282033358);
	System.out.println("\nPrinting in Preorder");
	Fruits.printPreorder();
	System.out.println("\nPrinting in Order");
	Fruits.printInorder();
	System.out.println("\nPrinting in Postorder");
	Fruits.printPostorder();
	Fruits.remove(juicy);
	System.out.println("\nRemoving a fruit and Printing in Order");
	Fruits.printInorder();
	}
}
