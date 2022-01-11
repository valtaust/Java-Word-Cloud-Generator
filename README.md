# Java-Word-Cloud-Generator
URL or File parse

pseudocode: 
Read the ignore words into a set (TreeSet or HashSet)
Parse the target text file
  For each line in the  text file
     Break the line into words
     For each word
	If the word is not in the ignore list
	   add to the map or increment frequency if already in the map
        End If
     End For
  End For
End Parse
