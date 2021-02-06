import java.io.*;
import java.util.*;
/*
    Code used in USACO solution by Nick Wu
    http://www.usaco.org/current/data/sol_trapped_bronze.html
 */
public class Haybales {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("trapped.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("trapped.out")));
        int n = Integer.parseInt(br.readLine());
        Haybale[] bales = new Haybale[n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = Integer.parseInt(st.nextToken());
            int position = Integer.parseInt(st.nextToken());
            bales[i] = new Haybale(size, position);
        }
        // sort haybales by location
        Arrays.sort(bales);
        int ans = 0;
        for(int i = 0; i < n-1; i++) {
            int areaOfInterval = bales[i+1].position - bales[i].position;
            int leftmostBale = i;
            int rightmostBale = i+1;
            // while Bessie could still be trapped
            while(leftmostBale >= 0 && rightmostBale <= n-1) {
                boolean broke = false;
                int currDist = bales[rightmostBale].position - bales[leftmostBale].position;
                if(currDist > bales[leftmostBale].size) {
                    leftmostBale--;
                    broke = true;
                }
                if(currDist > bales[rightmostBale].size) {
                    rightmostBale++;
                    broke = true;
                }
                // Bessie couldn't break through either the left or the right bale, so stop
                if(!broke) {
                    break;
                }
            }
            // Bessie couldn't break out
            if(leftmostBale >= 0 && rightmostBale <= n-1) {
                ans += areaOfInterval;
            }
        }
        pw.println(ans);
        pw.close();
    }

    static class Haybale implements Comparable<Haybale> {
        public int position, size;
        public Haybale(int sizeIn, int positionIn) {
            size = sizeIn;
            position = positionIn;
        }
        public int compareTo(Haybale h) {
            // this will sort haybales from left to right
            return position - h.position;
        }
    }

}
/*
public class Haybales{


    public void process(int amount, int[] size, int[] pos){
        int output = 0;
        Pair[] haybale = Pair[amount];
        for(int i = 0; amount; i++){
            haybale[i] = new Pair(pos[i], size[i]);
        }
        Pair temp;
        for (int i = 0; i < amount; i++){
            for (int j = i; j < amount; j++){
                if(haybale[j].id > haybale[j + 1].id){
                    temp = haybale[j];
                    haybale[j] = haybale[j + 1];
                    haybale[j + 1] = temp;
                }
            }
        }

        int currSpace;
        Pair left;
        Pair right;
        for (int i = 0; i < amount - 1; i++){
            currSpace = haybale[i + 1].value - haybale[i].value;
            left = haybale[i];
            right = haybale[i + 1];
            if (left.value < currSpace && right.value < currSpace){
                output += currSpace;
                continue;
            }
            if(left.equals(haybale[0])){}
            while (!(left.value < currSpace && right.value < currSpace)){

            }
        }
    }


    public static void main(String[] args) throws FileNotFoundException{
        File file = new File("./" + args[0]);
        Scanner input = new Scanner(file);
        String input1 = input.nextLine();
        int amount = Integer.parseInt(input1);
        int[] haybaleSize = new int[];
        int[] haybalePos = new int[];

        for (int i = 0; i < amount; i++){
            haybaleSize[i] = input.nextInt();
            haybalePos[i] = input.nextInt();
        }

        new Haybales().process(amount, haybaleSize, haybalePos);
    }
}
*/