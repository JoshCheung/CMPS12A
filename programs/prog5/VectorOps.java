//Joshua Cheung
//CMPS-12A
//Vector_Operations

import java.util.*;
import java.io.*;

public class VectorOps
{
    public static void main(String[] args)
    {
        System.out.println("1. Sum of two vectors");
        System.out.println("2. Difference of two vectors");
        System.out.println("3. Magnitude of a vector");
        System.out.println("4. Scalar Product of a vector");
        System.out.println("5. Dot Product of two vector");
        System.out.println("6. Angle between two vectors");
        
        System.out.println("Enter your choice...");
       
        boolean done = false;
        while(!done)
        {
            Scanner kbScanner = new Scanner(System.in);
            int choice = kbScanner.nextInt();
            
            if(choice > 6 || choice < 1)
            {
                System.out.println("Please enter a number that is available.");
                choice = kbScanner.nextInt();
            }
            
            switch (choice) 
            {
                case 1: sumOfTwoVectors();//case 1
                        break;
                case 2: differeceOfTwoVectors();//case 2
                        break;
                case 3: magnitudeOfVectors();//case 3
                        break;
                case 4: scalarProduct();//case 4
                        break;
                case 5: productOfVectors();//case 5
                        break;
                case 6: findAngle();//case 6
                        break;
        
            }
            System.out.println("Would you like to continue? (y/n)");
            String answer = kbScanner.next();
            if(answer.equals("y"))
            {
                System.out.println("Enter your choice...");
            }
            else if(answer.equals("n"))
            {
                done = true;
            }
            else
            {
                System.out.println("That is an invalid input, Goodbye");
                break;
            }
        }
    }
    
    public static int [] findVectors()
    {
        Scanner kbScanner = new Scanner(System.in);
        String numbers = kbScanner.next();
        String [] num = numbers.split(",");
        int [] vectors = new int [2];
        for(int i = 0; i < num.length; i++)
        {
            vectors[i] = Integer.parseInt(num[i]);
        }
        return vectors;
    }

    public static int[] sumOfTwoVectors() 
    {
        System.out.println("Enter the first vector: (x,y)");
        int [] v1 = findVectors();
        System.out.println("Enter the second vector: (x,y)");
        int [] v2 = findVectors();
        int [] newVect = new int [2];
        newVect[0] = v1[0] + v2[0];
        newVect[1] = v1[1] + v2[1];
        System.out.println("Your new point is " + newVect[0] + "," + newVect[1]);
        return newVect;
    }
    
    public static int[] differeceOfTwoVectors()
    {
         System.out.println("Enter the first vector: (x,y)");
        int [] v1 = findVectors();
        System.out.println("Enter the second vector: (x,y)");
        int [] v2 = findVectors();
        int [] newVect = new int [2];
        newVect[0] = (v1[0] - v2[0]);
        newVect[1] = (v1[1] - v2[1]);
        System.out.println("Your new point is " + newVect[0] + "," + newVect[1]);
        return newVect;   
    }
    
    public static double magnitudeOfVectors() //|b| = √( 6^2 + 8^2 ) = √( 36+64 ) = √100 = 10
    {
        System.out.println("Enter the vector: (x,y)");
        int [] findMag = findVectors();
        double a = (double) findMag[0];
        double b = (double)findMag[1];
        
        double answer = Math.sqrt(a*a + b*b);
        System.out.println(answer);
        return answer;
    }
    
    public static int []  scalarProduct() //x*scalar, y*scalar
    {
        System.out.println("Enter the vector: (x,y)");
        int [] vex = findVectors();
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the scalar: ");
        int scalar = scan.nextInt();
        int [] points = new int [2];
        points[0] = vex[0] * scalar;
        points[1] = vex[1] * scalar;
        System.out.println("Your new point is " + points[0] + "," + points[1]);
        return points;
    }
    
    public static double productOfVectors() //a · b = ax × bx + ay × by
    {
        System.out.println("Enter the first vector: (x,y)");
        int [] vecA = findVectors();
        System.out.println("Enter the second vector: (x,y)");
        int [] vecB = findVectors();
        double product = (((double)vecA[0]*(double)vecB[0]) + ((double)vecA[1]*(double)vecB[1]));
        System.out.println(product);
        return product;
    }
   
    public static double findAngle() // theta = arccos( ((x1 * y1) + (x2 * y2))/sqrt((x1^2) + (x1^2)) * sqrt((y2^2) + (y2^2)))
    {  
        System.out.println("Enter the first vector: (x,y)");
        int [] vecA = findVectors();
        double a1 = (double)vecA[0];
        double a2 = (double)vecA[1];
        System.out.println("Enter the second vector: (x,y)");
        int [] vecB = findVectors();
        double b1 = (double)vecB[0];
        double b2 = (double)vecB[1];
        
        double preAnswer = ((a1 * b1) + (a2 * b2))/((Math.sqrt((a1*a1) + (a2*a2))) * (Math.sqrt((b1*b1) + (b2*b2))));
       
        double theta = Math.acos(preAnswer);
        System.out.println(theta);
        return theta;
    }
}


