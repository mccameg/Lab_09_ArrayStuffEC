import java.util.Random;
import java.util.Scanner;

public class Main {
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int rangedInt = 0;
        boolean done = false;
        String trash = "";

        do
        {
            System.out.print(prompt + " [" + low + " - " + high + "]: "); // show the prompt and the range
            if(pipe.hasNextInt()) // input is an integer
            {
                rangedInt = pipe.nextInt(); // stores the input
                pipe.nextLine(); // clear the buffer
                if(rangedInt >= low && rangedInt <= high) // input is an int and is in range
                {
                    done = true; // input is valid, program will not continue to loop
                }
                else // input is an int but out of range
                {
                    System.out.println("You must enter a value that is in range [" + low + " - " + high + "]: " + rangedInt); // echoes invalid response back to user and re-states the range
                }
            }
            else // input is invalid - not an int
            {
                trash = pipe.nextLine(); // stores input in trash so that it can be echoed back to user
                System.out.println("You must enter a valid number [" + low + " - " + high + "]: " + trash); // invalid input is echoed back to the user and range is re-stated
            }

        } while(!done); // program loops until a valid input is entered

        return rangedInt;
    }

    public static int min(int values[])  // Returns the min value found
    {
        int retMin = values[0];
        for (int x = 0; x < values.length; x++)
        {
            if (retMin > values[x]) //if min is greater than the value that appears in the array
            {
                retMin = values[x]; // the value in the array will be the new min
            }
        }
        return retMin;
    }

    public static int max(int values[])  // Returns the max value found
    {
        int retMax = values[0];
        for (int x = 0; x < values.length; x++)
        {
            if(retMax < values[x]) //if max is less than the value that appears in the array
                {
                    retMax = values[x]; // the value in the array will be the new max
                }
        }
        return retMax;
    }

    public static int occuranceScan(int values[], int target)
    {
        int count = 0;

        for (int x = 0; x < values.length; x++)
        {
            if (values[x] == target) // checks to see if target is equal to the value at each location in the array
            {
                count = count + 1; // keeps count of the number of times the value comes up in the array by adding
            }
        }
        return count;
    }

    public static int sum(int values[]) // Returns the sum of the values array elements
    {
        int retSum = 0;
        for (int x = 0; x < values.length; x++)
        {
            retSum = retSum + values[x]; // calculates the sum of all array values
        }
        return retSum;
    }

    public static boolean contains(int values[], int target) // Returns true if the values array contains target
    {
        boolean containsTarget = false;

        for (int x = 0; x < values.length; x++)
        {
            if (values[x] == target) // checks to see if target is equal to the value at each location in the array
            {
                containsTarget = true; // if target appears in the array
            }

        }return containsTarget;
    }



    public static void main(String[] args)
    {
	    int ARRAY_SIZE = 100;
	    int [] dataPoints = new int[ARRAY_SIZE];
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);

        for (int val = 0; val < dataPoints.length; val++)
        {
            dataPoints[val] = rnd.nextInt(100) + 1; // assign each element in the array a random number between 1-100
        }
        for (int val = 0; val < dataPoints.length; val++)
        {
            System.out.print(dataPoints[val] + " | "); // print all values separated by |
        }

        System.out.println("\n\nThe minimum value is " + min(dataPoints)); // call method and output min value
        System.out.println("The maximum value is " + max(dataPoints)); // call method and output max value

        int userInput = 0;
        int countTarget = 0;

        userInput = getRangedInt(in, "\nEnter a value to search", 1, 100); // call getRangedInt and have user input a value 1-100
        countTarget = occuranceScan(dataPoints, userInput); //call method to determine how many times a user entered value appears in the array
        System.out.println("Value " + userInput + " found " + countTarget + " time(s)"); // output number of times value appears in array

        System.out.println("\nThe sum of the values is " + sum(dataPoints)); // call method to output the sum of array values

        int userValue = 0;

        userValue = getRangedInt(in, "\nEnter a value to search", 1, 100); // call getRangedInt and have user input a value 1-100
        System.out.println(userValue + " appears in the array?: " + contains(dataPoints, userValue)); // output to show true/false based upon if the value entered by the user appears in the array


    }
}
