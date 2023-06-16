package CodeJam2022.Round1A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Weightlifting {
    public static void main(String[] args) {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(reader);
        int nTestCases = sc.nextInt();

        for (int testCase = 0; testCase < nTestCases; testCase++) {
            int E = sc.nextInt();
            int W = sc.nextInt();
            int[][] exerciseWeights = new int[E][W];

            for(int i=0; i<E; i++){
                for (int j=0; j<W; j++){
                    exerciseWeights[i][j] = sc.nextInt();
                }
            }

            int minOps = getMinOps(E,W, exerciseWeights);

            System.out.println("Case #" + (testCase + 1) + ": " + minOps);

        }
    }

    private static int getMinOps(int e, int w, int[][] exerciseWeights) {

        int[][] cache = new int[e][e];
        for(int i=0; i<e; i++){
            for (int j=0; j<e; j++){
                cache[i][j] = -1;
            }
        }
        int[][] cwcache = new int[e][e];
        for(int i=0; i<e; i++){
            for (int j=0; j<e; j++){
                cwcache[i][j] = -1;
            }
        }
        int cw = getCommonWeightCount(exerciseWeights,0,e-1, cwcache);

        int min = getMin(e, w, exerciseWeights, 0, e-1, cw, cache, cwcache);

        return min + 2*cw;
    }

    private static int getCommonWeightCount(int[][] exerciseWeights, int left, int right, int[][] cwcache) {
        if(cwcache[left][right] > -1)
            return cwcache[left][right];

        int e = exerciseWeights.length;
        int w = exerciseWeights[0].length;

        int[] cw = new int[w];
        for(int j=0; j<w; j++){
            int minw = Integer.MAX_VALUE;
            for(int i=left; i<=right; i++){
                minw = Math.min(minw, exerciseWeights[i][j]);
            }
            cw[j] = minw;
        }
        cwcache[left][right] = Arrays.stream(cw).sum();
        return cwcache[left][right];    }

    private static int getMin(int e, int w, int[][] exerciseWeights, int left, int right, int cw, int[][] cache, int[][] cwcache) {
        if(left == right)
            return 0;

        if(cache[left][right] > -1)
            return cache[left][right];

        int minlr = Integer.MAX_VALUE;
        for(int x=left; x<right; x++){

            int cwlx = getCommonWeightCount(exerciseWeights,left,x, cwcache);
            int cwxr = getCommonWeightCount(exerciseWeights,x+1,right, cwcache);

            int minlx = getMin(e,w, exerciseWeights, left,x, cwlx, cache, cwcache);
            int minxr = getMin(e,w, exerciseWeights, x+1,right, cwxr, cache, cwcache);

            int min = minlx + minxr + 2*(cwlx + cwxr - 2*cw);
            minlr = Math.min(minlr, min);

        }

        cache[left][right] = minlr;
        return minlr;
    }


}
