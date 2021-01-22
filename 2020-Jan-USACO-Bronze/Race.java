import java.io.*;
import java.util.*;

/**
 * This file is used to read in the desired top speed at the finish line and produce an array of possible times.
 */

public class Race{


    /**
     * Takes distance and top speed to produce the fastest possible run time for an array of speeds.
     * @param k - distance of the track
     *        n - the number of speeds to test
     *        x - array of different speeds
     * @return fastest time used
     */
    public void raceProj(int k, int n, int[] xValues){
        int[] output = new int[n];
        for (int i = 0; i < n; i++){                    // Will loop through each of the n elements
            output[i] = raceSpeed(k, xValues[i]);
        }
        System.out.println(Arrays.toString(output));    // Prints the final array of outputs.
    }

    /**
     * Takes distance and top speed to produce the fastest possible run time.
     * @param k - distance of the track
     *        x - current top speed
     * @return fastest time used
     */
    public int raceSpeed(int k, int x){
        int time = 0;
        int firstHalf = 0;                           // Current distance covered
        int secondHalf = 0;                          // Projected distance that will be covered when slowing


        for(int speed = 1;; speed++){                // Will iterate through the acceleration throughout
            firstHalf+=speed;                        // This refers to initial acceleration
            time++;
            if(firstHalf + secondHalf >= k)          // Returns time if total distance is greater than the finish line
                return time;
            if(speed >= x){                          // This point is when we consider speeds from the later half
                secondHalf+=speed;
                time++;
                if(firstHalf + secondHalf >= k)      // Does a second check if the total distance is greater than k
                    return time;
            }
        }
    }


    /**
     * The main method for executing the solution on test cases.
     * @param args - file input
     * @return none
     */
    public static void main(String[] args) throws FileNotFoundException{
        File file = new File("./" + args[0]);
        Scanner input = new Scanner(file);
        String input1 = input.nextLine();
        String[] line1 = input1.split(" ");
        int k = Integer.parseInt(line1[0]);
        int n = Integer.parseInt(line1[1]);
        int[] xValues = new int[n];
        for(int i = 0; i < n; i++){
            xValues[i] = Integer.parseInt(input.nextLine());
        }

        new Race().raceProj(k, n, xValues);
    }
}
