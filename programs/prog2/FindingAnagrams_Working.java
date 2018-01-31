import java.util.*;
import java.io.*;

public class FindingAnagrams
{
    public static void main(String[] args) throws FileNotFoundException
    {
	List<String> loadedWords = loadWords(args[0]);
        boolean done = false;
        while (!done) 
	    {
		System.out.println("Type a string of letters"); 
		Scanner scanner = new Scanner(System.in);
		String userWord = scanner.next();
		List<String>  words = compareWord(userWord, loadedWords);
		for (String word : words)
		{
		    System.out.println(word);
		}
		System.out.println("Do another (y/n)? ");
		String yesOrNo = scanner.next();
		if(yesOrNo.equals("n"))
		    {
			done = true;
		    }
		else if(!yesOrNo.equals("y"))
		    {
			System.out.println("Sorry, that is not a valid input");
		    }
	    }
    }

    public static List loadWords(String filename) throws FileNotFoundException
    {
        List wordList = new ArrayList();
        File file = new File(filename); //should be a number to loop through entire list
        Scanner in = new Scanner(file);
        int count = in.nextInt();  // take the first line that is a number
        for (int i = 0; i < count; i++) 
	    {
		String word = in.next(); //takes the next word/String
		wordList.add(word);
	    }
        return wordList; // return the wordList because I want to load all the words into a new readable list
    }
    
    public static List<String> compareWord(String word, List<String> loadedWords)
    {
        ArrayList<String> acceptedList = new ArrayList();
        for(String stri : loadedWords)
        { 
	    if (stri.length() == word.length())
		{
		    if(alphabetize(stri).equals(alphabetize(word)) && !(stri.equals(word)))
			{
			    acceptedList.add(stri);
			}
		}
	}
        return acceptedList;
    }
    
    static String alphabetize(String word)
    {
        char[] alphaWord = word.toCharArray();
        Arrays.sort(alphaWord);
        return new String(alphaWord);
    }
}
