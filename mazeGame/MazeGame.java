//Daniel Chavez
import java.io.*;
import java.util.Scanner;

public class MazeGame {
	public static final int MAZE_SIZE = 10; //maze size
	private char [][] maze; //maps out game board
	public static final char EMPTY = '_'; 
	public static final char OBST = 'X';
	public static final char PLAYER = 'O';
	public static final char PATH = '#';
	
	public static final String UP = "Up";
	public static final String DOWN = "Down";
	public static final String LEFT = "Left";
	public static final String RIGHT = "Right";
	
	private LLQueue<int[]> locations; //used to keep track of previous locations
	private int[] currentLocation; //keeps track of current location
	private LLQueue<String> commands = new LLQueue<String>(); //keeps track of commands that the robot has
	
	/*
	 * Takes in boardFile for methods in init
	 * 
	 */
	public MazeGame(String boardFile){
		this.init(boardFile);
	}
	/*
	 * takes boardFile and uses addBoard method to populate 2d array
	 */
	private void init(String boardFile) {
		maze = new char[MAZE_SIZE][MAZE_SIZE]; //creates gameboard
		readBoardFile(boardFile);
		maze[0][0] = PLAYER; //starts at top left corner
		currentLocation = new int[] {0,0};
		locations = new LLQueue<int[] > ();
	}
	
	/*
	 * reads boardFile and populates char 2d array
	 */
	public void readBoardFile(String boardFile){
		try {
			Scanner fileScanner = new Scanner(new File(boardFile)); //new scanner to read file games
			int n = 0;
			while(fileScanner.hasNextLine()) //while file has another line
			{
				String textLine = fileScanner.nextLine(); //Separates line from line
				for(int i = 0; i < textLine.length(); i++) {
					maze[n][i] = textLine.charAt(i);
				}
				n++;
			}
		}
		catch(Exception e){
				e.printStackTrace();
		}
	}
	
	//reads robot commands and populates command queue with commands
	public void readRobotCommands(String RobComFile) {
		try {
			Scanner fileScanner = new Scanner(new File(RobComFile));
			while(fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				String [] lineSplit = line.split(" ");
				commands.enqueue(lineSplit[1]);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * prints all of the robot commands
	 */
	public void printCommands() {
		commands.print();
	}

	/*
	 * prints the full maze
	 */
	public void printFullMaze() {
		for(int i = 0; i < maze.length; i++) {
			for(int j = 0; j < maze.length; j++) {
				System.out.print(maze[i][j]);
			}
			System.out.println();
		}
	}
	/*
	 * depending on your current location and the obstacles around you
	 * this will give you the options available to you of where to go
	 */
	public void printMoveOptions() {
		int yCoordinate = currentLocation[0];
		int xCoordinate = currentLocation[1];
		//North
		if(isValid(yCoordinate-1) && maze[yCoordinate-1][xCoordinate] != OBST) {
			System.out.println(UP);
		}
		//South
		if(isValid(yCoordinate+1) && maze[yCoordinate+1][xCoordinate] != OBST) {
			System.out.println(DOWN);
		}
		//West
		if(isValid(xCoordinate-1) && maze[yCoordinate][xCoordinate-1] != OBST) {
			System.out.println(LEFT);
		}
		//East
		if(isValid(xCoordinate+1) && maze[yCoordinate][xCoordinate+1] != OBST) {
			System.out.println(RIGHT);
		}
	}
	
	/*
	 * checks to see if index is in bounds of 2d array
	 */
	private boolean isValid(int index) {
		return index >= 0 && index < maze.length;
	}
	
	/*
	 *given user input of where to go this moves your current location 
	 *based on that user input
	 *if wrong move prints out crash and game ENDS 
	 */
	public void move(String input) {
		maze[currentLocation[0]][currentLocation[1]] = EMPTY;
		int yCoordinate = currentLocation[0];
		int xCoordinate = currentLocation[1];
		int [] copyLoc = {currentLocation[0],currentLocation[1]};
			if(input.equalsIgnoreCase(UP)) {
				if(isValid(yCoordinate - 1) && maze[yCoordinate - 1][xCoordinate] != OBST) {
					locations.enqueue(copyLoc); 
					currentLocation[0]--;
				}
				else {
					System.out.println("CRASH");
					currentLocation[0] = 10;
				}
			}
			if(input.equalsIgnoreCase(DOWN)) {
				if(isValid(yCoordinate + 1) && maze[yCoordinate + 1][xCoordinate] != OBST) {
					locations.enqueue(copyLoc); 
					currentLocation[0]++;
				}
				else {
					System.out.println("CRASH");
					currentLocation[0] = 10;
				}
			}
			if(input.equalsIgnoreCase(LEFT)) {
				if(isValid(xCoordinate - 1) && maze[yCoordinate][xCoordinate - 1] != OBST) {
					locations.enqueue(copyLoc); //QUEUE OR STACK?
					currentLocation[1]--;
				}
				else {
					System.out.println("CRASH");
					currentLocation[1] = 10;
				}
			}
			if(input.equalsIgnoreCase(RIGHT)) {
				if(isValid(xCoordinate + 1) && maze[yCoordinate][xCoordinate + 1] != OBST) {
					locations.enqueue(copyLoc); //QUEUE OR STACK?
					currentLocation[1]++;
				}
				else {
					System.out.println("CRASH");
					currentLocation[1] = 10;
				}
			}
	
			
			maze[currentLocation[0]][currentLocation[1]] = PLAYER;	
		}
	
	/*
	 * returns true if you are at the bottom right corner of the 2d array
	 */
	public boolean getWin() {
		return currentLocation[0] == maze.length - 1 && currentLocation[1] == maze.length - 1;
	}
	
	/*
	 * resets the game 
	 * does so by reinitalizing everything to the starting values
	 */
	public void reset(String boardFile) {
		this.init(boardFile);
	}
	
	/*
	 *prints the full maze with the path taken by the user 
	 */
	public void printFullMazeWithPath() {
		while(locations.peek() != null) {
			int [] temp = locations.dequeue();
			maze[temp[0]][temp[1]] = PATH;
			this.printFullMaze();
		}
	}
	
	/*
	 * dequeues commands
	 */
	public String dequeueCommand() {
		return commands.dequeue();
	}	
}