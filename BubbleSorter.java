//Daniel Chavez
import java.util.Scanner;
public class BubbleSorter {
	public static void main(String[]args) {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("how big is your list?");
		int[] sort = new int[keyboard.nextInt()];
		for(int i = 0; i < sort.length; i++) {
			System.out.println("Enter number " + (i + 1));
			sort[i] = keyboard.nextInt();
		}
		boolean swapped = true;
		while(swapped) {
			swapped = false;	
			for(int i = 0; i < sort.length - 1; i++) {
				if (sort[i] > sort[i + 1]) {
					int temp = sort[i];
					sort[i] = sort[i + 1];
					sort[i + 1] = temp;
					swapped = true;
				}
			}
		}
		System.out.println("\nThis is your list organized in ascending order");
		for(int i = 0; i < sort.length; i++) {
			System.out.println(sort[i]);
		}
	keyboard.close();
	}
}
