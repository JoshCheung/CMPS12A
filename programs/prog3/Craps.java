import java.util.*;
import java.io.*;

public class Craps
{
    static Random rng;
    public static void main(String[] args)
    {
        System.out.println("Enter the seed."); //dont know what a seed is, but it was in the example program
        Scanner kbScanner = new Scanner(System.in);
        int seed = kbScanner.nextInt();
        rng = new Random(seed);
        System.out.println("How many chips do you want?"); //Chip count
        int numberOfChips = kbScanner.nextInt(); //User input for Chip count
        int quantityOfChips = numberOfChips; //This is what keeps track of the chip count
        boolean hasMoney = true;
        if(quantityOfChips <= 0)
        {
            hasMoney = false;
            System.out.println("Sorry, you cannot play because you have no money");
            System.exit(0);
        }
        int bet = enterBet(quantityOfChips); // user's valid bet
    
        while(hasMoney)
        { 
            if(quantityOfChips <= 0)
        	{
        	    break;
        	}
	    enterToPlay();
            int point = rollDice();
            if(point == 2 || point == 3 || point == 12) //losing conditions
            {
                quantityOfChips = (quantityOfChips - bet);
        	    System.out.println("You lost, you now have "+ quantityOfChips);
        	    if(quantityOfChips <= 0) //having no money
        	    {
        	        System.out.println("Sorry, you are out of money");
        	        break;
        	    }
        	    bet = enterBet(quantityOfChips); 
        	    enterToPlay(); // enterKey
            }
            else if(point == 7 || point == 11) //Winning conditions
            {
                quantityOfChips = (quantityOfChips + bet);
                System.out.println("You won, you now have " + quantityOfChips);
                bet = enterBet(quantityOfChips);
            }
            else //second and more rounds of rolling the dice for point
            {
                 System.out.println("The point is " + point);
                
                 boolean done = false;
                 while(!done) //not done unless conditions are met
                 {  
                     enterToPlay();
                     int toss = rollDice();
                     if(toss == point) // winning
                     {
                         quantityOfChips = (quantityOfChips + bet);
                         System.out.println("You win, you now have " + quantityOfChips);
                         done = true;
                         bet = enterBet(quantityOfChips);
                     }
                     else if (toss == 7) //losing
                     {
                         quantityOfChips = (quantityOfChips - bet);
                         System.out.println("You lost, you now have " + quantityOfChips);
                         if(quantityOfChips <= 0)
                         {
                             System.out.println("Sorry, you are out of money");
                             break;
                         }
                         done = true;
                         bet = enterBet(quantityOfChips);
                     }
                 }
            }
        }
    }
    
    public static int enterBet(int num) //enters bet, but only if it is a valid bet
    {
        int amountOfChips = num;
        System.out.println("Enter a bet");
        Scanner scanBet = new Scanner(System.in);
        int betSize = scanBet.nextInt();
        boolean invalid = true;
        if(betSize > amountOfChips)
        {
            while(invalid)
            {
                System.out.println("Not an ok bet");
                int newBet = scanBet.nextInt();
                if(newBet <= amountOfChips)
                { 
                    betSize = newBet;
                    invalid = false;
                   }
               }
        }
        return betSize;
    }
        
    public static String enterToPlay() //enterkey for pressing enter in order to start.
    {
        System.out.println("Hit enter to roll the dice");
        String enterKey;
        Scanner myScanner = new Scanner(System.in);
        enterKey = myScanner.nextLine();
        return enterKey;
    }
        
    public static int rollDice() //rolls the dice for the game and returns the point
    {
        int die1 = rng.nextInt(6)+1;
        int die2 = rng.nextInt(6)+1;
        //int die1 = (int)(Math.random()*6+1);
        //int die2 = (int)(Math.random()*6+1);
        System.out.println("roll is " + die1 + ", " + die2);
        int point = die1 + die2;
        return point;
    }
}
