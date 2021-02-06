import java.io.*;
import java.util.*;

/**
 * This file runs the WordProcessor class and uses main to test input.
 * WordProcessor takes in input n, k, and the essay, while separating the essay into lines such that
 * each line is no more than k characters long.
 */

public class Moocryption{


    private static char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
                                        'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    /**
     * Takes in the essay parameters and formats the essay according to the question instructions.
     * @param wordCount - the number of words in the essay
     *        charCount - the number of characters allowed per line
     *        essay - a string array of essay words
     * @return none
     */
    public int process1(int row, int col, char[][] letter){
        int possibleOutput = 0;
        int output = 0;
        char[] first = alphabet;
        char[] second = alphabet;
        for (int i = 0; i < alphabet.length; i++){
            for (int j = 0; j < alphabet.length; j++){
                if(((i != 12) && (i != 14)) && (i != j)) {
                    possibleOutput = process2(row, col, letter, first[i], second[j]);
                    if (possibleOutput > output)
                        output = possibleOutput;
                }
            }
        }
        return output;
    }

    /**
     * Takes in the essay parameters and formats the essay according to the question instructions.
     * @param wordCount - the number of words in the essay
     *        charCount - the number of characters allowed per line
     *        essay - a string array of essay words
     * @return none
     */
    public int process2(int row, int col, char[][] letter, char first, char second){
        int output = 0;
        for (int i = 0; i < row; i++){
            for (int j = 0; j < col; j++){
                if (letter[i][j] == first){
                    // Checks up
                    if (i - 1 >= 0 && i - 2 >= 0){
                        if (letter[i - 1][j] == second && letter[i - 2][j] == second)
                            output++;
                    }
                    // Checks up-right
                    if ((i - 1 >= 0 && i - 2 >= 0) && (j + 1 < col && j + 2 < col)){
                        if (letter[i - 1][j + 1] == second && letter[i - 2][j + 2] == second)
                            output++;
                    }
                    // Checks right
                    if (j + 1 < col && j + 2 < col){
                        if (letter[i][j + 1] == second && letter[i][j + 2] == second)
                            output++;
                    }
                    // Checks down-right
                    if ((i + 1 < row && i + 2 < row) && (j + 1 < col && j + 2 < col)){
                        if (letter[i + 1][j + 1] == second && letter[i + 2][j + 2] == second)
                            output++;
                    }
                    // Checks down
                    if (i + 1 < row && i + 2 < row){
                        if (letter[i + 1][j] == second && letter[i + 2][j] == second)
                            output++;
                    }
                    // Checks down-left
                    if ((i + 1 < row && i + 2 < row) && (j - 1 >= 0 && j - 2 >= 0)){
                        if (letter[i + 1][j - 1] == second && letter[i + 2][j - 2] == second)
                            output++;
                    }
                    // Checks left
                    if (j - 1 >= 0 && j - 2 >= 0){
                        if (letter[i][j - 1] == second && letter[i][j - 2] == second)
                            output++;
                    }
                    // Checks up-left
                    if ((i - 1 >= 0 && i - 2 >= 0) && (j - 1 >= 0 && j - 2 >= 0)){
                        if (letter[i - 1][j - 1] == second && letter[i - 2][j - 2] == second)
                            output++;
                    }
                }
            }
        }
        return output;
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
        String[] inputNumbers = input1.split(" ");
        int rows = Integer.parseInt(inputNumbers[0]);
        int columns = Integer.parseInt(inputNumbers[1]);
        char[][] lines = new char[rows][columns];
        String singleLine;
        for (int i = 0; i < rows; i++){
            singleLine = input.nextLine();
            for (int j = 0; j < columns; j++){
                lines[i][j] = singleLine.charAt(j);
            }
        }

        System.out.println(new Moocryption().process1(rows, columns, lines));
    }
}
