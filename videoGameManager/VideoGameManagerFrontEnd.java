//Daniel Chavez
import java.util.Scanner;
public class VideoGameManagerFrontEnd {

	private static Scanner keyboard = new Scanner(System.in);
	public static VideoGameManager database;
	public static void main(String[]args) {
		database = new VideoGameManager();
		database.readVideoGameFile(); //reads video game file
		
		boolean running = true;
		printGreetings(); //prints greetings
		printChoices(); //prints choices
		while(running) {
			int choice = keyboard.nextInt(); //stores choice  
			keyboard.nextLine();
			switch(choice) {
			case 1:
				System.out.println("Whats the name of the video game?");
				String name = keyboard.nextLine();
				System.out.println("Whats the console of the video game?");
				String console = keyboard.nextLine();
				database.searchGames(name, console);
				System.out.println();
				printChoices();
				break;
			case 2:
				database.printUserVideoGames();
				System.out.println();
				printChoices();
				break;
			case 3:
				System.out.println("(1) Create  (2) Append");
				int option = keyboard.nextInt();
				keyboard.nextLine();
				if (option == 1)
				{
					System.out.println("Whats the name of your file?");
					String fileName = keyboard.nextLine();
					database.writeVideoGameFile(fileName);
					printChoices();
				} 
				else if (option == 2) {
					System.out.println("Whats the name of your file?");
					String existingFile = keyboard.nextLine();
					database.AppendVideoGameFile(existingFile, true);
					printChoices();
				}
				break;
			case 4:
				running = false;
				System.exit(0); //exits the program
				break;
			default:
			}
		}
	}
	/*
	 * Prints the greetings
	 */
	public static void printGreetings() {
	System.out.println("Welcome to the videogame database");
	}
	
	/*
	 * Prints the choices
	 */
	public static void printChoices() {
		System.out.println("Enter 1. to search games by name and console\n" 
				+ "Enter 2. to print results\n" 
				+ "Enter 3. to Write a Video-Game file\n"
				+ "Enter 4. to Exit");
	}
}