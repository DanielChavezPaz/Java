//Daniel Chavez
import java.io.*;
import java.util.Scanner;
public class VideoGameManager {
	public static final String TAB = "\t"; //separates info
	public static final String NEW_LINE = "\n"; //creates new line
	public static final int LINE_AMT = 2; //amount of info in one line
	private  GenLL <VideoGame> videoGames;
	private static GenLL <VideoGame> userVideoGames; //new array to hold user game
	public VideoGameManager() {
		videoGames = new GenLL<VideoGame>();
		userVideoGames = new GenLL<VideoGame>();
		
	}

	public void readVideoGameFile() {
		try {
			Scanner fileScanner = new Scanner(new File("./games")); //new scanner to read file games
			while(fileScanner.hasNextLine()) //while file has another line
			{
				String textLine = fileScanner.nextLine(); //Separates line from line
				String[] splitLines = textLine.split(TAB); // splits line into array
				if(splitLines.length == LINE_AMT)  //Validates line
				{
					VideoGame temp = new VideoGame(splitLines[0], splitLines[1]); 
					videoGames.add(temp);
				}
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}		
	}
	
	public void writeVideoGameFile(String fileName) {
		try {
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(fileName));
			userVideoGames.reset();
			while(userVideoGames.hasMore()) {
				VideoGame aVideoGame = userVideoGames.getCurrent();
				fileWriter.println(aVideoGame.getName()+TAB+aVideoGame.getConsole()+NEW_LINE);
				userVideoGames.gotoNext();
			}
			fileWriter.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public void AppendVideoGameFile(String name, boolean userPreference) {
		try {
			//PrintWriter fileWriter = new PrintWriter(new FileOutputStream(aName), userPreference);
			PrintWriter print = new PrintWriter(new BufferedWriter(new FileWriter(name, userPreference)));
			userVideoGames.reset();
			while(userVideoGames.hasMore()) {
				VideoGame aVideoGame = userVideoGames.getCurrent();
				print.println(aVideoGame.getName()+TAB+aVideoGame.getConsole()+NEW_LINE);
				userVideoGames.gotoNext();
			}
			print.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void searchGames(String name, String console){			
		userVideoGames.remove();
		videoGames.reset();
		while(videoGames.hasMore()) {
			if((videoGames.getCurrent().getName().toLowerCase().contains(name.toLowerCase()) && videoGames.getCurrent().getConsole().toLowerCase().contains(console.toLowerCase())) 
			|| (name.equals("*") && videoGames.getCurrent().getConsole().toLowerCase().contains(console.toLowerCase())) 
			|| (videoGames.getCurrent().getName().toLowerCase().contains(name.toLowerCase())&& console.equals("*")))
			{
				userVideoGames.add(videoGames.getCurrent());
			}
			videoGames.gotoNext();
		}
		
	}
	
	public void print() {
		videoGames.print();
	}
	
	public void printUserVideoGames() {
		userVideoGames.print();
	}
}