import java.io.*;
import java.util.*;

/**
 * This file runs the WordProcessor class and uses main to test input.
 * WordProcessor takes in input n, k, and the essay, while separating the essay into lines such that
 * each line is no more than k characters long.
 */

public class Perimeter{


    private static int output = 0;
    private static int[][] field;
    private static int amount;

    /**
     * Takes in the essay parameters and formats the essay according to the question instructions.
     * @param wordCount - the number of words in the essay
     *        charCount - the number of characters allowed per line
     *        essay - a string array of essay words
     * @return none
     */
    public static void process(int x, int y){
        if((x < 0 || x > 99) || (y < 0 || y > 99))
            return;
        if(field[x][y] == 0){
            field[x][y] = 2;
            process(x, y + 1);
            process(x, y - 1);
            process(x + 1, y);
            process(x - 1, y);
            return;
        }
        if (field[x][y] == 2)
            return;
        else if(field[x][y] == 1){
             output++;
             return;
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
        amount = Integer.parseInt(input1);
        field = new int[100][100];
        int right = 0;
        int point = 0;
        for (int i = 0; i < amount; i++){
            int x = input.nextInt();
            int y = input.nextInt();
            if (x > right) {
                right = x;
                point = y;
            }
            field[x][y] = 1;
        }

        process(right + 1, point);
        System.out.println(output);
    }
}
