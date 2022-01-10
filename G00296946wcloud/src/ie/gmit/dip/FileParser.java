package ie.gmit.dip;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * @author Valery Taustsiakou
 * @Class FileParser
 * writing in input as /src/words.txt will locate the text file
 * return (HashMap<String, String>) hmap;
 */
public abstract class FileParser {
	
	/**
	 * @Instances File file
	 * Scanner scan
	 * HashMap<String,String>hmap;
	 */

	protected static File file;
	private static Scanner scan = new Scanner(System.in);
	protected static Map<String, String> hmap = new HashMap<String, String>();

	/**
	 * @method scanFile
	 * @return File
	 * @throws IOException
	 */
	public static File scanFile() throws IOException {
		String dir = System.getProperty("user.dir");
		System.out.println(dir);
		System.out.println("write in file name here e.g. ./words.txt"); // show user input by string
		String userPath = scan.next();
		file = new File(userPath);
		System.out.println(file.getPath());
		return file;
	}

	@SuppressWarnings("unused")
	private void scanClose() {
		scan.close();
	}

	/**
	 * @method getFile
	 * @return File
	*/
	
	static File getFile() {
		return file;
	}
	
	/**
	 * @method setFile
	 * @return void
	 */
	

	void setFile(File file) {
		FileParser.file = file;
	}

	/**
	 * 
	 * @return HashMap<String, String>
	 * @throws IOException
	 */
	public static HashMap<String, String> HashMapFromTextFile() throws IOException {

		// create file object
		File file = getFile();

		BufferedReader br = null;
		try {

			// create BufferedReader object from the File
			br = new BufferedReader(new FileReader(file));

			String line = null;

			// read file line by line
			while ((line = br.readLine()) != null) {

				// split the line by :
				String[] parts = line.split(":");

				// first part is name, second is number
				String name = parts[0].trim(); // trim whitespace
				String number = parts[0].trim(); // was [1] changed to [0] because array index max is 1

				// outputs a letters only from the array
				// put name, number in HashMap if they are not empty

				if (!name.equals("") && !number.equals(""))
					hmap.put(name, number); // O(1) times to go over Strings by hashmap

				// iterate over HashMap entries
				for (Map.Entry<String, String> entry : hmap.entrySet()) {
					System.out.println(entry.getKey() + " : " + entry.getValue());
					//continue;
				}
			}
			br.close();
		} catch (FileNotFoundException fnfe) {
			fnfe.toString();

		} catch (Exception e) {
			e.getCause();
		} finally {

			// Always close the BufferedReader
			if (br != null) {
				try {

					br.close();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		return (HashMap<String, String>) hmap;
	}
	
	/**
	 * @method finalize()
	 * garbage collection to get objects and dispose of stored objects
	 * @return void
	 */

	protected void finalize() throws Throwable {
		// will print name of object
		System.out.println(FileParser.file + " successfully garbage collected");
		System.gc();
	}
}


