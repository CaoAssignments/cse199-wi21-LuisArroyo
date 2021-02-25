import java.io.*;
import java.util.*;

public class Perimeter{


    private static int output = 0;
    private static int[][] field;
    private static int amount;

    public static void process(int x, int y){
        // 2D array boundary check
        if((x < 0 || x > 99) || (y < 0 || y > 99))
            return;
        // Visits surrounding points. 2 represents a visited point
        if(field[y][x] == 0){
            field[y][x] = 2;
            process(x, y + 1);
            process(x, y - 1);
            process(x + 1, y);
            process(x - 1, y);
            return;
        }
        // Returns when visited
        if (field[y][x] == 2)
            return;
        // Increments by 1 for each side of the square on the edge of the perimeter
        else if(field[y][x] == 1){
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
        int col = 0;
        int row = 0;
        for (int i = 0; i < amount; i++){
            int x = input.nextInt();
            int y = input.nextInt();
            if (x > col) {
                col = x;
                row = y;
            }
            field[y - 1][x - 1] = 1;
        }

        process(col + 1, row);
        System.out.println(output);
    }
}
