import java.util.*;
import java.io.*;

public class SimCraps
{
    public static void main(String[] args)
    {
        if(args.length < 1)
        {
            System.out.println("You did not enter an argument");
            System.exit(0);
        }
        int sims = Integer.parseInt(args[0]);
        double numOfWins = (double) keepCount(sims);
        double probability = (double)((numOfWins/sims)*100);
        System.out.println("Prob of Winning = " + probability);
        
    }

    public static int keepCount(int numOfSims)
    {
        int win = 0;
        int sims = numOfSims;
        for(int i = 0; i < sims; i++)
        {
            int point = rollDice();
            if(point == 7 || point == 11)
            {
                win+=1;
            }
            else if(point == 2 || point == 3 || point == 12)
            {
                win+=0;
            }
            else
            {
                boolean done = false;
                while(!done)
                {
                    int toss = rollDice();
                    if(toss == point)
                    {
                        win+=1;
                        done = true;
                    }
                    else if (toss == 7)
                    {
                        done = true;
                    }
                }

            }
        }
        return win;
    }

    public static int rollDice() //rolls the dice for the game and returns the point
    {
        int die1 = (int)(Math.random()*6+1);
        int die2 = (int)(Math.random()*6+1);
        int point = die1 + die2;
        return point;
    }
}

