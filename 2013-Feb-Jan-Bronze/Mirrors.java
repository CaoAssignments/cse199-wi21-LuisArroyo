import java.io.*;
import java.util.*;

public class Mirrors{

    static final int HOME = -1;
    static final int BACKSLASH = 1;
    static final int FORWARDSLASH = 2;
    static final int BARN = 3;

    static final int NORTH = 0;
    static final int SOUTH = 1;
    static final int EAST = 2;
    static final int WEST = 3;

    public static int process(String[] locations, int[][] farm){
        int x;
        int y;
        int index = 0;

        // Checks if you can reach the barn already.
        if(search(farm))
            return 0;

        // Flips each fence and searches through for correct solution.
        for (String point : locations) {
            index++;
            x = Integer.parseInt(point.split(",")[0]);
            y = Integer.parseInt(point.split(",")[1]);
            // Temporarily flip.
            if (farm[1000 - y][1000 + x] == BACKSLASH){
                farm[1000 - y][1000 + x] = FORWARDSLASH;
                if(search(farm))
                    return index;
                farm[1000 - y][1000 + x] = BACKSLASH;
            }else {
                farm[1000 - y][1000 + x] = BACKSLASH;
                if(search(farm))
                    return index;
                farm[1000 - y][1000 + x] = FORWARDSLASH;
            }
        }
        // Reaches here if none are possible
        return -1;
    }

    private static boolean search (int[][] farm) {
        String house = 1000 + "," + 1000;
        int height = farm.length;
        int width = farm[0].length;
        boolean[][] visited = new boolean[height][width];
        int direction = EAST;
        int row = 1000;
        int col = 1000;

        while (true) {
            // Boundary check
            if(row<0 || col<0 || row>=height || col>=width || visited[row][col])
                break;

            // Checks if we are at the barn
            if(farm[row][col] == BARN)
                return true;
            
            if(farm[row][col] == BACKSLASH || farm[row][col] == FORWARDSLASH || farm[row][col] == BARN)
                visited[row][col] = true;

            if(farm[row][col] == BARN)
                direction = EAST;

            // Direction changes for BACKSLASH
            if(farm[row][col] == BACKSLASH){
                if(direction == NORTH)
                    direction = WEST;
                else if (direction == SOUTH)
                    direction = EAST;
                else if (direction == WEST)
                    direction = NORTH;
                else if (direction == EAST)
                    direction = SOUTH;
            }

            // Direction changes for FORWARDSLASH
            if(farm[row][col] == FORWARDSLASH){
                if(direction == NORTH)
                    direction = EAST;
                else if (direction == SOUTH)
                    direction = WEST;
                else if (direction == WEST)
                    direction = SOUTH;
                else if (direction == EAST)
                    direction = NORTH;
            }


            if(direction == NORTH)
                row--;
            else if (direction == SOUTH)
                row++;
            else if (direction == EAST)
                col++;
            else if (direction == WEST)
                col--;
        }

        return false;
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
        int N = Integer.parseInt(inputNumbers[0]);
        int a = Integer.parseInt(inputNumbers[1]);
        int b = Integer.parseInt(inputNumbers[2]);
        int[][] farm = new int[2001][2001];
        String[] locations = new String[N];
        farm[1000][1000] = HOME;
        farm[1000 - b][1000 + a] = BARN;
        String singleLine;
        for (int i = 0; i < N; i++){
            singleLine = input.nextLine();
            String[] mirrorData = singleLine.split(" ");
            int x = Integer.parseInt(mirrorData[0]);
            int y = Integer.parseInt(mirrorData[1]);
            if(mirrorData[2].charAt(0) == '\\')
                farm[1000 - y][1000 + x] = BACKSLASH;
            else
                farm[1000 - y][1000 + x] = FORWARDSLASH;
            locations[i] = x + "," + y;
        }
        System.out.println(process(locations, farm));
    }
}