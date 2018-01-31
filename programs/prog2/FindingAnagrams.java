//Joshua Cheung                                                                                                                                  
//CMPS-12A                                                                                                                                       
//FindingAnagrams                                                                                                                                

//What my program does is it takes the length of the input word and compares it to the arrayList of words already sorted from                    
//shortest to longest word in the dicitonary.                                                                                                    
//In doing this, the function compareWord looks at the alphabetized words of each on in the list.                                                
//for example, if the word length inputed was 4, it would look through the bucket that contains the words                                        
//in the dictionary with the length of four letters.                                                                                             
//Then by comparing the alphabetized order of the words, it checks if they are equal to one another.                                             
//if it is, then it is an anagram and adds into a list.


import java.util.*;
import java.io.*;

public class FindingAnagrams
{
    public static void main(String[] args) throws FileNotFoundException
    {
	List<String>[] loadedWords = loadWords(args[0]);

        boolean done = false;
        while (!done) 
	    {
		System.out.println("Type a string of letters"); 
		Scanner scanner = new Scanner(System.in);
		String userWord = scanner.next();
		List<String> words = compareWord(userWord, loadedWords);
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
			System.out.println("Goodbye");
			done = true;
			
		    }
	    }
    }

    public static List[] loadWords(String filename) throws FileNotFoundException
    {
	List<String>[] listByLength = new ArrayList[40];
	for(int i = 0; i < 40; i++)
	{
	    listByLength[i] = new ArrayList<String>();
	}
        //List wordList = new ArrayList();
        File file = new File(filename); //should be a number to loop through entire list
        Scanner in = new Scanner(file);
        int count = in.nextInt();  // take the first line that is a number
        for (int i = 0; i < count; i++) 
	    {
		String word = in.next(); //takes the next word/String
		List<String> listToUse = listByLength[word.length()];
		listToUse.add(word);
	    }
        return listByLength; // return the wordList because I want to load all the words into a new readable list
    }
    
    
    public static List<String> compareWord(String word, List<String>[] loadedWords)
    {
        List<String> acceptedList = new ArrayList<String>();
	if (word.length() > loadedWords.length)
	{
	    return new ArrayList<String>();
	}
	List<String> listToUse = loadedWords[word.length()];
        for(String stri : listToUse)
        { 
	    if(alphabetize(stri).equals(alphabetize(word)) && !(stri.equals(word)))
	    {
		acceptedList.add(stri);
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
