//Joshua Cheung
//CMPS-12A
//findAnagrams



import java.util.*;
import java.io.*;

public class AnagramFinder
{
    public static void main(String[] args)
    {
        List<List<String>> listOfWords = null;
	try { listOfWords = loadWords(args[0]); } catch (FileNotFoundException ex) { }
        boolean done = false;
	Scanner scanner = new Scanner(System.in);
	while (!done) 
        {
            List matchedWords = new ArrayList();
            System.out.println("Type a string of letters"); 
            String userWord = scanner.next();
            List wlist = findAnagramList(userWord, listOfWords);
            System.out.println("Do another (y/n)? ");
            String yesOrNo = scanner.next();
            if(yesOrNo.equals("y"))
            {
                done = true;
            }
	    System.out.println("yesOrNo: ###" + yesOrNo + "###");
	    else if(!yesOrNo.equals("y")) //this if-statement does not work, I can't figure out why.
            {
            		System.out.println("That is not a valid answer");
            }
	   	 Print out the yesOrNo value here.  and see what it is.
           	 System.out.println("yesOrNo: ###" + yesOrNo + "###");
        }
    }

    public static List<String> findListFor(String alphaWord,  List<List<String>> listOfWords)
    {
        for (List<String>  wlist : listOfWords) // loops through the entire lists of listOfWord.
	    {  
		String alphaWordsInList = wlist.get(0); // get the first element from the list (which represent alphaWord of the list)
            if (alphaWordsInList.equals(alphaWord)) // if the alphaWord is the same, then we found the list.
            {  
                return  wlist; // because you want a list of all the matched words
            }
        }
        return null; //because it's not there
    }

    public static List findAnagramList(String word, List<List<String>> listOfWords)
    {
        String alphaWord = alphabetize(word);
        List<String>  alphaWordList = findListFor(alphaWord, listOfWords); // return a new list that excludes word from alphaWordList.  
        List<String> buddiesList = new ArrayList<String>();
        for (int i = 1; i < alphaWordList.size(); i++) //one because you want to skip the first alphabetized word that is not part of the list
        {   
            if (!alphaWordList.get(i).equals(word))  
            {
                buddiesList.add(alphaWordList.get(i));
            }
        }
        return buddiesList;
    }


    public static List<List<String>> loadWords(String filename) throws FileNotFoundException
    {  
        List<List<String>> wordLists = new ArrayList<List<String>>();  // Create the List for List<String>, that is empty to start with.
        File file = new File(filename);   // create the File object.
        Scanner in = new Scanner(new FileInputStream(file));   // create the scanner of the file.
   
        int count = in.nextInt();  // take the first line, which should be the number of words.
        for (int i = 0; i < count; i++) // loop number of words times (to read the file)
        {  
            String word = in.next();    // take the next line (should be the words)
            String alphaWord = alphabetize(word);  // alphabetize word => alphaWord // search and see if alphaWord is already there.
            List<String> targetList = findListFor(alphaWord, wordLists);
            if (targetList != null) 
            {  // if the alphaWord list is already there 
                targetList.add(word);  // just need to add the new word with the same alphaWord into the list. 'items'
            }   
            else 
            {   // list is not found... we need to create a new list to append to the list of list of words.
                // new list.
                List newList = new ArrayList();  // creates the new list
                newList.add(alphaWord);  // add alphaWord as the first element. 'eimst'
                newList.add(word);       // add the first word. 'emits'
                wordLists.add(newList);
            }
        }
        return wordLists;
    }           
    static String alphabetize(String word) 
    {
	char[] alphaWord = word.toCharArray();
	Arrays.sort(alphaWord);
	return new String(alphaWord);
    }
}
