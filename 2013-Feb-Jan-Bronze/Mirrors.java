import java.io.*;
import java.util.*;

public class Mirrors{



    public static void process(int count, char[][] farm, int[] mirrorX, int[] mirrorY){
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
        char[2000000][2000000] farm = new char[rows][columns];
        farm[1000000][1000000] = 'H';
        farm[a + 1000000][b + 1000000] = 'B';
        String singleLine;
        int[] mirrorX = new int[N];
        int[] mirrorY = new int[N];
        for (int i = 0; i < N; i++){
            singleLine = input.nextLine();
            String[] mirrorData = singleLine.split(" ");
            int x = Integer.parseInt(mirrorData[0]);
            int y = Integer.parseInt(mirrorData[1]);
            farm[x + 1000000][y + 1000000] = mirrorData[3].charAt(0);
            mirrorX[i] = x;
            mirrorY[i] = y;
        }
        process(N, farm, mirrorX, mirrorX);
        System.out.println();
    }
}
