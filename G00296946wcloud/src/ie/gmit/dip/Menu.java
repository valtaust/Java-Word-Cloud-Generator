package ie.gmit.dip;

import java.io.File;
import java.net.URL;
import java.util.Scanner;

/**
 * 
 *@author Valery Taustsiakou
 *@Class Menu
 */

public class Menu {

	private static Scanner scnr = new Scanner(System.in);
	private static boolean firstRunning = true; // boolean for menu to begin the menu
	protected static URL url;
	protected static File file;
	
	/**
	 * @method showOptions
	 * @return void
	 * Returns menu options for selection, case 3 not built
	 */

	public static void showOptions() {
		System.out.println("1) Enter File"); // Ask user to specify the file to process.
		System.out.println("2) Enter url Name");
		System.out.println("3) Not available option; Select a max number of words to display in image"); // for additional workings
		System.out.println("4) Quit"); // Restarts the menu to terminate the menu to start again
		System.out.println("\nSelect Option [1-3]>");
		System.out.print(ConsoleColour.BLACK_BOLD_BRIGHT);
	}
	
	/**
	 * @method runMenu()
	 * @return void
	 * @throws Exception
	 * @return case1 Local File is scanned in
	 * case 2 URL is already preset
	 * case 3 is not built to filter words
	 * case 4 is a quit restart method
	 */

	public static void runMenu() throws Exception { // start method to start the menu display
		showOptions(); // apply showMenu in this method
		while (firstRunning) { // keeps menu alive
			Integer choice = null;
			try {
				choice = Integer.parseInt(scnr.next());
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} // replaced with parseInt for consistent user design
			switch (choice) { // switch based on scanner input
			case 1:
				FileParser.scanFile();
				FileParser.HashMapFromTextFile();
				FileParser.getFile();
				CloudRender.paint();
				break;
			case 2:
				URLParser.download();
				URLParser.HashMapFromURLfile();
				PaintURLFile.paintUrl();
				break;
			case 3:
				// TODO number of words in word cloud future work
				break;
			case 4:
				quit();
				break;
			default: // equivalent of else statement
				firstRunning = false; // breaks out of the menu
				System.out.println("menu has ended");
				System.out.println("[Error] Invalid input.");
				break; // added in break statement here to validate menu method and image convo class
			}
		}
		scnr.close(); // closed the scanner
	}

	/**
	 * @method quit()
	 * @return void
	 * @throws Exception
	 */
	private static void quit() throws Exception {
		do {
			runMenu(); // restart the menu by start() method again
		} while (firstRunning = true);
		System.out.println("Menu successfully restarted");
	}
}
