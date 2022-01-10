package ie.gmit.dip;

import java.net.*;
import java.util.HashMap;
import java.util.Map;
import java.io.*;

/**
 * 
 * @author Valery Taustsiakou
 *class URLParser parses a local file saved from a URL
 *returns a HashMap
 */


public class URLParser extends FileParser {
	
	/**
	 * @method download() 
	 *
	 * The method in.read(byte[] buffer) reads bytes from the URL to the array chunk and
	 *	returns the number of bytes read. 
	 * @throws Exception
	 */
	
	public static void download() throws Exception {
		URL connection;
		String fileName;
		System.out.println("URL already in as input");
		//connection = new URL("http://www.gmit.ie"); //preset url
		//http://textfiles.com/100/captmidn.txt     example url 
		connection = new URL("https://en.wikipedia.org/wiki/Tony_Hoare"); //preset url
		//A URL connection is just a stream of bytes
		InputStream in = connection.openStream();
		//Writing bytes to a buffer is much more efficient than writing one byte at a time
		fileName = "./urlfile.txt";
		BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fileName));
		byte[] chunk = new byte[4096]; //The byte array acts a a buffer for reading bytes
		int bytesRead;
		while ((bytesRead = in.read(chunk)) > 0) {
		out.write(chunk, 0, bytesRead); //Write the bytes to the out stream (a file).
		}
		out.flush(); //Flush remaining bytes to the stream
		out.close(); //Close the stream.
	}
	
	/**
	 * @method HashMapFromURLfile()
	 * @return 	return (HashMap<String, String>);
	 * 
	 * @throws IOException
	 * @catch FileNotFoundException
	 * @catch Exception e
	 * @catch Exception e1
	 * @catch Exception e2 to close BufferedReader instance  
	 */
	
	
	public static HashMap<String, String> HashMapFromURLfile() throws IOException {

		// create file object
		File file = new File("/src/urltest.txt");

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

		} catch (Exception e1) {
			e1.getCause();
		} finally {

			// Always close the BufferedReader
			if (br != null) {
				try {

					br.close();

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		}

		return (HashMap<String, String>) hmap;
	}
}
	