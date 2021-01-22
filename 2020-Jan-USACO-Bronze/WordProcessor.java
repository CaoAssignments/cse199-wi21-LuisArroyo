import java.io.*;
import java.util.*;

/**
 * This file runs the WordProcessor class and uses main to test input.
 * WordProcessor takes in input n, k, and the essay, while separating the essay into lines such that
 * each line is no more than k characters long.
 */

public class WordProcessor{

    /**
     * Takes in the essay parameters and formats the essay according to the question instructions.
     * @param wordCount - the number of words in the essay
     *        charCount - the number of characters allowed per line
     *        essay - a string array of essay words
     * @return none
     */
    public void process(int wordCount, int charCount, String[] essay){
        int lineCount = 0;
        String output = "";
        for(int i = 0; i < wordCount; i++){                     // for loop that iterates through each word
            if((lineCount + essay[i].length()) <= charCount) {  // case where line can hold more words
                if(i == wordCount - 1)                          // this will print if it contains the final word
                    System.out.println(output+=essay[i]);
                lineCount += essay[i].length();
                output += essay[i] + " ";
            } else{                                             // case where a new line is necessary
                System.out.println(output);
                lineCount = essay[i].length();
                output = essay[i] + " ";
                if(i == wordCount - 1)                          // checks if this is the last word
                    System.out.println(output);
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
        String[] inputNumbers = input1.split(" ");
        int wordCount = Integer.parseInt(inputNumbers[0]);
        int charCount = Integer.parseInt(inputNumbers[1]);
        String input2 = input.nextLine();
        String[] essay = input2.split(" ");

        new WordProcessor().process(wordCount, charCount, essay);
     }
}
