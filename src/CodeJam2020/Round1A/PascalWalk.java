package CodeJam2020.Round1A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.SocketOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalWalk {

    static int[][] NCR =new int[501][501];
    static boolean[][] inPath = new boolean[501][501];
    public static void main(String[] args) {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(reader);
        int nTestCases = sc.nextInt();

        for (int i = 0; i < nTestCases; i++) {
            long n = sc.nextLong();
            List<Integer> x = new ArrayList<>();
            List<Integer> y = new ArrayList<>();
            x.add(1);
            y.add(1);
            inPath[1][1] = true;
            NCR[1][1]=1;
            findPascalWalk(n, x, y, 1, 1);
            System.out.println("Case #"+ (i+1) + ":");
            long total = 0;
            for(int k=0; k<x.size(); k++){
                System.out.println(x.get(k) + " " + y.get(k));
                total += getNCR(x.get(k), y.get(k));
            }
            System.out.println(total);



            for(int a=0; a<501; a++)
                for(int b=0; b<501;b++)
                    inPath[a][b] = false;

        }
    }

    private static boolean findPascalWalk(long n, List<Integer> x, List<Integer> y, long sum, int length) {
        if(sum==n)
            return true;

        if(length == 500 || sum > n)
            return false;

        if(n-sum <= 500 - length){
            int r = x.get(length - 1);
            int k = y.get(length - 1);
            if(r==k || k == 1){
                boolean pathExists = true;
                int tempR = r;
                for(int a=0; a < n-sum; a++ ){
                    tempR++;
                    int tempK = k == 1? 1 : tempR;
                    if(inPath[tempR][tempK]){
                        pathExists = false;
                        break;
                    }
                }
                if(pathExists){
                    for(int a=0; a < n-sum; a++) {
                        r++;
                        k = k == 1 ? 1 : r;
                        x.add(r);
                        y.add(k);
                    }
                    return true;
                }
            }
        }


        for(int i=0;i<6; i++){
            // (ri - 1, ki - 1), (ri - 1, ki), (ri, ki - 1), (ri, ki + 1), (ri + 1, ki), (ri + 1, ki + 1)
           int X = x.get(length-1);
           int Y = y.get(length-1);
           X = getNextX(X,i);
           Y = getNextY(Y,i);
           if(X>0 && Y>0 && X < 501 && Y<501 && X>=Y && !inPath[X][Y]){
               inPath[X][Y] = true;
               int ncr = getNCR(X,Y);
               x.add(X);
               y.add(Y);

               if(findPascalWalk(n, x,y,sum+ncr, length+1 ))
                   return true;
               else {
                   inPath[X][Y] = false;
                   x.remove(length);
                   y.remove(length);
               }
           }
        }

        return false;
    }

    private static int getNextY(int y, int i) {
        // (ri - 1, ki - 1), (ri - 1, ki), (ri, ki - 1), (ri, ki + 1), (ri + 1, ki), (ri + 1, ki + 1)
        switch(i){
            case 0:
            case 2:
                return y - 1;
            case 1:
            case 4:
                return y;
            case 3:
            case 5:
                return y + 1;
            default: return -1;
        }

    }

    private static int getNextX(int x, int i) {
        // (ri - 1, ki - 1), (ri - 1, ki), (ri, ki - 1), (ri, ki + 1), (ri + 1, ki), (ri + 1, ki + 1)
        switch(i){
            case 0: return x - 1;
            case 1: return x - 1;
            case 2: return x;
            case 3: return x;
            case 4: return x + 1;
            case 5: return x + 1;
            default: return -1;
        }

    }

    public static int getNCR(int x, int y) {
        if(x == y || y == 1) {
            NCR[x][y] = 1;
            return 1;
        }

        if(NCR[x][y] != 0)
            return NCR[x][y];

        NCR[x][y] = getNCR(x-1,y-1) + getNCR(x-1, y);
        return  NCR[x][y];
    }
}
