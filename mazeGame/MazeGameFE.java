//Daniel Chavez
import java.util.Scanner;
public class MazeGameFE {
	public static void main(String[]args) {
		Scanner keyboard = new Scanner(System.in); //reads user input
		MazeGame game; //new game 
		boolean playGame = true; 
		while(playGame) { //while user wants to keep playing
			System.out.println("Welcome to maze game\n"+"What board would you like to play?");
			String board = keyboard.nextLine(); 
			game = new MazeGame(board); //takes in game board file
			System.out.println("What robot file?"); 
			String robCom = keyboard.nextLine();
			game.readRobotCommands(robCom); //takes in robot command file
			boolean allCommands = false;
			try { //used to avoid crashing program with the move method
				while(!allCommands) { //while not all commands have been run yet
					game.printMoveOptions(); 
					System.out.println();
					String input = game.dequeueCommand();
					game.move(input); //takes in command and moves around board
					if(game.getWin()) { //if at the bottom right corner
						allCommands = true;
						game.printFullMazeWithPath();
						System.out.println("you win!");
						System.out.println("Would you like to play Again?/n" + "(1) yes (2) no");
						int playAgain = keyboard.nextInt();
						keyboard.nextLine();
						if(playAgain == 2) {
							System.exit(0);
						}
					}
				}
			}
			catch(Exception e) {
				System.out.println("The Robot Has Crashed!\n");
			}
		}
		keyboard.close();	
	}
}