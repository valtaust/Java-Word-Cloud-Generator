
Student number & name: G00296946 Valery Taustsiakou

Advanced Object Oriented Programming "Word Cloud".

For this project we had to create a visual representation of text using the users input of a URL or Text File Directory and the limit of words they would like to have displayed. The visual representation should also not include the ignored specified words which were taken from a file that is hardcoded into the program. The user must also be given the option to decide the name of the output file. 

## Built With
*  [Eclipse](https://www.eclipse.org/) - The IDE used
Java used is javac 15.0.2

## Acknowledgments
* Oracle.
* Java 8 doc's.
* Advanced OOP (HashMaps / TreeMaps, DictionaryParser lecture);
* StackOverflow when facing issues.
Reference:
//https://www.geeksforgeeks.org/reading-text-file-into-java-hashmap/
//https://www.baeldung.com/java-map-to-string-conversion

## Running the Jar File
The Run the JAR file on command line use the following commands :

java -cp ./wcloud.jar ie.gmit.dip.Runner   

from the src folder directory
--------------------------------------------------------------------------------
JavaDocs are located in D:\G00296946wdcloud\G00296946wcloud\src\doc\ie\gmit\dip 
in the first folder called "ie\gmit\dip".

--------------------------------------------------------------------------------

RunningTime: Hashmap has O1 Running time. Hashmap put and get operation time complexity is O(1) with 
assumption that key-value pairs are well distributed in storage.

Design: The abstract FileParser class calls the local text file for scanner input and 
the generated HashMap is passed into CloudRender class. The file not found exception was 
dealt with in try catch statement to progress the build. Garbage collection was also
tried to remove file as object in case of further exceptions in other class. 
The URLParser class generates a local file of the url object.
The file is converted to a HashMap and passed in to be converted into a String in 
the PaintURLFile class. 

The Runner class runs the Menu class. The Menu class runs the necessary methods called
by instances of the classes. The design was designed in mind to choose number of 
words or characters at the end for agile deployment time.
The PaintInterface was created for the PaintURLFile & CloudRender classes to override 
similar methods. The interface methods are also static for the menu to be able to call
the static class paint methods.
 
The PaintURLFile & CloudRender classes use enums called Colours.java & ConsoleColour.java 
public class URLParser extends FileParser in inheritance to use the similar parser method without an interface.
In UML the FileParser should be above the URLParser in hierarchy and have towards it a white blank arrow, a change
needed to the attached UML diagram.

The HashMap<String,String> datatype was used instead of <String,Integer> to keep the implementation similar as in 
reference. It was tried to implement the lecture code for List<String> and HashMap<String,Integer>
to suit the pseudocode required. The obstacle was handling the FileNotFoundException and handling 
any other exception to progress the project.

FutureWork: It is possible to get the map String converted to a substring using a java substring method, or to
select a number of chars by the menu to parse.

------------------------------------------------------------------------------------
--------------------------------------------------------------------------------------------------------------------
Miscellaneous code not used: //method for converting to treemap to sort the map into alphabet order and back to hashmap
/*public static HashMap<String, String> conversionMapSort(HashMap<String, String> map) {
TreeMap<String, String> treeMap = new TreeMap<>(map); // treemap sorts the values O log n
Map<String, String> finalMap = new HashMap<>(treeMap); // O log n
return (HashMap<String, String>) finalMap; // O1 time x O logn = O log n time of conversion
} */

------------------------------------------------------------------------------------------------------------------
https://www.javatpoint.com/post/java-scanner-usedelimiter-method
method to use a delimiter via scanner to remove <img> and <html> tags from url

--------------------------------------------------------------------------------------------------------------------

