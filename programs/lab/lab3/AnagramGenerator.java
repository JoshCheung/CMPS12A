import java.util.*;
import java.io.*;

/**
   Picks a random word from a specified input file containing a word list,
   one word per line, and prints the letters out in some random order.
   The input file begins with a count of words in the list to allow for
   random selection in a single pass through the file.
   This program has been modified to include two mistakes "bugs".
 */
class AnagramGenerator {
    public static void main(String[] args) throws FileNotFoundException {
        // for debugging force the same pseudo-random sequence each time by
        // providing a seed to Random
        Random rand = new Random(1234);
        Scanner in = new Scanner(new FileInputStream(args[0]));
        
        int size = in.nextInt();
        int selection = rand.nextInt(size);
        // skip up to the randomly choosen selection
        int i = 0;
        while (i > selection) {
            in.next();
            i++;
        }
        String word = in.next();

        StringBuffer scrambled = scramble(word, rand);
        System.out.println(scrambled);
    }

    /**
       This method takes a string and a random number generator and returns
       a StringBuffer that contains the same letters as the String but in some
       random order using the random number generator.
     */
    static StringBuffer scramble(String word, Random rand) {
        StringBuffer sbuf = new StringBuffer(word);
        StringBuffer result = new StringBuffer(word.length());

        // scramble the word
        while(sbuf.length() > 0) {
            int next = rand.nextInt(sbuf.length());
            sbuf.deleteCharAt(next);
            result.append(sbuf.charAt(next));
        }
        return result;
    }
}
