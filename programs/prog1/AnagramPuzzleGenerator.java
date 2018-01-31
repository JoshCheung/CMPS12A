//Joshua Cheung
//CMPS12A
//AnagramGeneratorPuzzle

import java.util.*;
import java.io.*;

class AnagramPuzzleGenerator
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner in = new Scanner(new FileInputStream(args[0]));
        int size = in.nextInt();
        Random rng = new Random();
        int randNum = rng.nextInt(size);
        int i = 0;
        while ( i < size )
	    {
		if(i == randNum )
		    {
			String chosen = in.next();
			//call scambleWord here and print the result and then exit.  Otherwise you will keep reading the words.
			System.out.println("[" + i + "] -> " + chosen + " scrambled => " + scrambleWord(chosen));
			break;  // This break out of the loop, and exit the program.
		    }
		String not_chosen = in.next();
		// if this is placed here, it will keep reading past i==rand
		//System.out.println("[" + i + "] not-chosen: " + not_chosen);
		i++;
	    }
    }
    public static String scrambleWord(String chosen)
    {
        StringBuffer chosenWord = new StringBuffer(chosen); //selected word
        char [] newPhrase = new char [chosenWord.length()]; //create a new char array with length of chosenWord
        Random rand = new Random(); // initiate random function
        //System.out.println(chosenWord); 
        //System.out.println(chosenWord.length());
        for(int i = 0; i < newPhrase.length; i++) // for the first letter in the list, randomly place it in the new location of the new list.
	    {
		int randNum = rand.nextInt(chosenWord.length()); // random number generator
		//System.out.println("randNum: " + randNum);
		newPhrase[i] = chosenWord.charAt(randNum); // takes the randomly selected letter from chosenWord and places it in the newPhrase
		chosenWord.deleteCharAt(randNum);  // removes the selected letter
		//System.out.println(chosenWord);
		//System.out.println("newPhrase: " + newPhrase[i]);
	    }
        return new String(newPhrase);
    }
}
