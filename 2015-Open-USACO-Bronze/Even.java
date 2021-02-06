import java.io.*;
import java.util.*;

/**
 * This file runs the WordProcessor class and uses main to test input.
 * WordProcessor takes in input n, k, and the essay, while separating the essay into lines such that
 * each line is no more than k characters long.
 */

public class Even{

    /**
     * The main method for executing the solution on test cases.
     * @param args - file input
     * @return none
     */
    public static void main(String[] args) throws FileNotFoundException{
        File file = new File("./" + args[0]);
        Scanner input = new Scanner(file);
        String input1 = input.nextLine();
        int inputNumbers = Integer.parseInt(input1);
        int output = 0;

        int[][] val = new int[256][2];


        for (int i = 0; i < inputNumbers; i++){
            char variable = input.next().charAt(0);
            int value = input.nextInt();
            if (value % 2 == 0)
                val[variable][0]++;
            else
                val[variable][1]++;
        }

        for (int b = 0; b < 2; b++)
            for (int e = 0; e < 2; e++)
                for (int s = 0; s < 2; s++)
                    for (int i = 0; i < 2; i++)
                        for (int g = 0; g < 2; g++)
                            for (int o = 0; o < 2; o++)
                                for (int m = 0; m < 2; m++){
                                    if(((b + e + s + s + i + e) * (g + o + e + s) * (m + o + o)) % 2 == 0)
                                        output += (val['B'][b] * val['E'][e] * val['S'][s] * val['I'][i]
                                                * val['G'][g] * val['O'][o] * val['M'][m]);
                                }

        System.out.println(output);
    }
}
