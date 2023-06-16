package LeetCode;

import java.util.Arrays;

public class MinMaxSubarraySumDP {

    public int splitArray(int[] a, int m) {
        int[][] cache = new int[a.length][m];
        for(int[] c : cache)
            Arrays.fill(c,-1);
        int ans = getMinSum(a,m,0, cache);
        return ans;
    }

    private int getMinSum(int[] a, int m, int i, int[][] cache) {
        if(i==a.length-1) {
            if(m>1){
                return Integer.MAX_VALUE;
            }
            return a[i];
        }

        if(cache[i][m-1] > -1)
            return cache[i][m-1];

        if(m==1){
            cache[i][m-1] = Arrays.stream(a,i,a.length).sum();
            return cache[i][m-1];
        }

        int min = Integer.MAX_VALUE;
        int sum1 = 0;
        for(int j = i; j<a.length-1 && m>1; j++){
            sum1 += a[j];
            int sum2 = getMinSum(a,m-1, j+1,cache );
            int max = Math.max(sum1,sum2);
            min = Math.min(min, max);
        }
        cache[i][m-1]  = min;
        return min;
    }
}