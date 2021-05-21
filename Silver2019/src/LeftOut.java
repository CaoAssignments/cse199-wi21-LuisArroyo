import java.io.*;
import java.util.*;


public class LeftOut{

    public static String process(int N, boolean[][] grid){
        // Walks through the top.
        for(int i = 0; i < N; i++){
            if(grid[0][i]){
                for(int j = 0; j < N; j++){
                    grid[j][i] = !grid[j][i];
                }
            }
        }

        // Walks through the first column.
        for(int i = 0; i < N; i++){
            if(grid[i][0]){
                for(int j = 0; j < N; j++){
                    grid[i][j] = !grid[i][j];
                }
            }
        }

        boolean isFirst = true;
        // Checks if the first is the missplaced cow.
        for(int i = 1; i < N && isFirst; i++){
            for(int j = 1; j < N && isFirst; j++){
                if(!grid[i][j])
                    isFirst = false;
            }
        }

        if(isFirst)
            return "1 1";

        int left = -1;
        int top = -1;
        // Checks top.
        for(int i = 1; i < N; i++){
            top = i;
            for(int j = 1; j < N; j++){
                if(!grid[j][i]){
                    top = -1;
                    break;
                }
            }
        }
        // Checks left.
        for(int i = 1; i < N; i++){
            left = i;
            for(int j = 1; j < N; j++){
                if(!grid[i][j]){
                    left = -1;
                    break;
                }
            }
        }


        int row = -1;
        int col = -1;

        // Check the rest of the grid.
        for(int i = 1; i < N; i++){
            for(int j = 1; j < N; j++){
                if(grid[i][j] && (row < 0)){
                    row = i;
                    col = j;
                }
            }
        }

        if((row < 0) && (col < 0))
            return "-1";
        if((top >= 0)&&(top < col))
            return "1 " + (col + 1) + "";
        if((left>=0)&&(left < row))
            return "" + (row + 1) + " 1";
        return "" + (row + 1) + " " + (col + 1) + "";
    }

    /**
     * The main method for executing the solution on test cases.
     * @param args - file input
     * @return none
     */
    public static void main(String[] args) throws FileNotFoundException{
        File file = new File("./" + args[0]);
        Scanner input = new Scanner(file);
        int N = Integer.parseInt(input.nextLine());
        boolean[][] grid = new boolean[N][N];
        char cows[];
        for(int i = 0; i < N; i++){
            String row = input.nextLine();
            cows = row.toCharArray();
            for(int j = 0; j < N; j++){
                if(cows[j] == 'L')
                    grid[i][j] = false;
                else
                    grid[i][j] = true;
            }
        }
        System.out.println(process(N, grid));
    }
}