import java.io.*;
import java.util.*;

/**
 * This file takes in Bessie's list and uses the information to find the original permutation of cows.
 */

public class Photoshoot{


    /**
     * Takes in the b list and sorts it to match the original list.
     * @param cowCount - the total number of cows
     *        cowNumber - the numbers from Bessie's list
     * @return none
     */
    public void cowSort(int cowCount, int[] cowNumber){
        int[] output = new int[cowCount];
        boolean[] check = new boolean[cowCount];              // An array used to check for repeating elements
        for(int i = 0; i < cowCount; i++){                    // Checks through every possible first number
            output[0] = i + 1;
            boolean edgeStop = false;                          // Catches unusual numbers like 0.
            for(int j = 1; j < cowCount; j++) {                // Reverses Bessie's formula
                output[j] = cowNumber[j - 1] - output[j - 1];
                if(output[j] < 1 || output[j] > cowCount)
                    edgeStop = true;
            }
            if(edgeStop)                                      // When edgeStop picks up a strange number, skip
                continue;
            for(int j = 0; j < cowCount; j++) {               // Checks for repeating elements. Returns if correct
                if(check[output[j] - 1])
                    break;
                else
                    check[output[j] - 1] = true;
                if(j == (cowCount - 1)){
                    System.out.println(Arrays.toString(output));
                    return;
                }
            }
            for (int j = 0; j < cowCount; j++)                        // Resets check array
                check[j] = false;
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
        int cowCount = Integer.parseInt(input1);
        String input2 = input.nextLine();
        String[] cowString = input2.split(" ");
        int[] cowNumber = new int[cowString.length];

        for(int i = 0; i < cowString.length; i++){
            cowNumber[i] = Integer.parseInt(cowString[i]);
        }

        new Photoshoot().cowSort(cowCount, cowNumber);
    }
}
