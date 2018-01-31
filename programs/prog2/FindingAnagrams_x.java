//Joshua Cheung
//CMPS-12A
//FindingAnagrams

import java.util.*;
import java.io.*;

public class FindingAnagrams
{
    public static void main(String[] args) throws FileNotFoundException
    {
        boolean done = false;
        while (!done) 
        {
            System.out.println("Type a string of letters"); 
            Scanner scanner = new Scanner(System.in);
            String userWord = scanner.next();
	    System.out.println(compareList(userWord, "wordList.txt"));
	    System.out.println("Do another (y/n)? ");
            String yesOrNo = scanner.next();
	    System.out.println("yesOrNo: ###" + yesOrNo + "###");
            if(yesOrNo.equals("n"))
            {
                done = true;
		System.out.println("yesOrNo: ###" + yesOrNo + "###");

            }
  	    // Print out the yesOrNo value here.  and see what it is.
            else if(!yesOrNo.equals("y"))
            {
		System.out.println("yesOrNo: ###" + yesOrNo + "###");
	
            	done = true;
		System.out.println("Sorry, that is not a valid answer");
            } 
	}
    }

    public static List loadWords(String filename) throws FileNotFoundException
    {
        List wordList = new ArrayList();
        File file = new File(filename); //should be a number to loop through entire list
        Scanner in = new Scanner(file);
        int count = in.nextInt();  // take the first line that is a number
        for (int i = 1; i < count; i++) 
        {
            String word = in.next(); //takes the next word/String
            wordList.add(word);
        st<String> wlist = compareList(userWord, "wordList.txt");
            for(int i = 0; i <= wlist.size(); i++)
            {
                String word = wlist.get(i);
                System.out.println(word);
            }}
        return wordList; // return the wordList because I want to load all the words into a new readable list
    }
    
    public static List<String> compareList(String word, String filename) throws FileNotFoundException
    {
        List<String> loadingWords = loadWords(filename);
        ArrayList<String> acceptedList = new ArrayList();
        for(int i = 0; i < loadingWords.size(); i++)
        { 
            String stri = loadingWords.get(i);
            if(stri.length() == word.length())
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







