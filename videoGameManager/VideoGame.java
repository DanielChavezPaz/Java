//Daniel Chavez
public class VideoGame {
	String name;
	String console;
	
	//public contstructor for future classes
	public VideoGame(String name, String console) {
		this.name = name;
		this.console  = console;
	}

	public String getName() { //returns name
		return name;
	}

	public void setName(String name) { //changes name
		this.name = name;
	}

	public String getConsole() { //returns console
		return console;
	}

	public void setConsole(String console) { //changes console
		this.console = console;
	}
	
	public String toString() { //prints
		return
				this.name + "\t" + this.console;
	}
}