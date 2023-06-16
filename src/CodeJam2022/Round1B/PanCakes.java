package CodeJam2022.Round1B;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PanCakes {
    public static void main(String[] args) {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(reader);
        int nTestCases = sc.nextInt();

        for (int testCase = 0; testCase < nTestCases; testCase++) {
          //  cache.clear();
            int n = sc.nextInt();
            int[] deque = new int[n];
            int[][] cache =  new int[n][n];
            for(int i=0; i<n; i++){
                for(int j=0; j<n; j++){
                    cache[i][j] = -1;
                }
            }

            for(int i=0; i<n; i++){
                deque[i] = sc.nextInt();
            }

            int maxPay = getMaxPay(deque,0,n-1,0, cache);

            System.out.println("Case #" + (testCase + 1) + ": " + maxPay);

        }
    }

    private static int getMaxPay(int[] deque, int i, int j, int prevMax, int[][] cache) {
        if(i==j){
            if(deque[i] >= prevMax)
                return 1;
            else
                return 0;
        }

        if(cache[i][j] > -1){
            return cache[i][j];
        }

        int maxpay1 = 0;
        if(deque[i] >= prevMax){
            maxpay1 = 1 + getMaxPay(deque,i+1, j, deque[i], cache);
        } else {
            maxpay1 = getMaxPay(deque,i+1, j, prevMax,cache);
        }

        int maxpay2 = 0;
        if(deque[j] >= prevMax){
            maxpay2 = 1 +  getMaxPay(deque,i, j-1, deque[j], cache);
        } else {
            maxpay2 = getMaxPay(deque,i, j-1, prevMax, cache);

        }

        int maxpay = Math.max(maxpay1,maxpay2);
        cache[i][j] = maxpay;

        return maxpay;
    }


}
