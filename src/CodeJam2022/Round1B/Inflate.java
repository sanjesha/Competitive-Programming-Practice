package CodeJam2022.Round1B;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Inflate {
    public static void main(String[] args) {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(reader);
        int nTestCases = sc.nextInt();

        for (int testCase = 0; testCase < nTestCases; testCase++) {
            int n = sc.nextInt();
            int p = sc.nextInt();
            int[][] custProdPressure = new int[n][p];
            long[][] cache = new long[n][2];

            for(int i=0; i<n; i++){
                for (int j=0; j<p; j++){
                    custProdPressure[i][j] = sc.nextInt();
                }
                Arrays.sort(custProdPressure[i]);
            }

            long minOps = getMinOps(custProdPressure,n,p, 0, 0, cache);

            System.out.println("Case #" + (testCase + 1) + ": " + minOps);

        }
    }

    private static long getMinOps(int[][] custProdPressure, int n, int p, int startPos, int i, long[][] cache) {
        if(i==n)
            return 0;

        int index = startPos == 0 ? 0 : 1;
        if(cache[i][index] > 0)
            return cache[i][index];

        long total = getTotal(custProdPressure[i]) + custProdPressure[i][startPos];

        long min1 =  getMinOps(custProdPressure,n,p, 0, i+1, cache);
        long min2 =  getMinOps(custProdPressure,n,p, p-1, i+1, cache);

        long minops1 = 0;
        long minops2 = 0;
        if(i<n-1) {
            minops1 = Math.abs(custProdPressure[i][p - 1 - startPos] - custProdPressure[i + 1][0]) - custProdPressure[i + 1][0];
            minops2 = Math.abs(custProdPressure[i][p - 1 - startPos] - custProdPressure[i + 1][p - 1]) - custProdPressure[i + 1][p - 1];
        }

        long minops = Math.min(min1+minops1, min2+minops2) + total;
        cache[i][index] = minops;
        return minops;
    }

    private static long getTotal(int[] a) {
        long sum = 0;
        for(int i=1; i<a.length; i++){
            sum += a[i] - a[i-1];
        }
        return sum;
    }
}
