package LeetCode;

import java.util.Arrays;

public class MinMaxSubarraySum {
    public int splitArray(int[] a, int m) {
        int[][] cache = new int[a.length][m];
        for(int[] c : cache)
            Arrays.fill(c,-1);

        int low = Arrays.stream(a).max().getAsInt();
        int high = Arrays.stream(a).sum();
        int ans = Integer.MAX_VALUE;
        while(low<=high){
            int mid = low + (high-low)/2;
            int subarrays = getPartitionsWithSubArraySumLessThanK(a,m,mid);
            if(subarrays <= m){
                ans = Math.min(ans,mid);
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return ans;
    }

    private int getPartitionsWithSubArraySumLessThanK(int[] a, int m, int k) {

        int subarrays = 1;
        int sum = 0;
        for(int i=0; i<a.length; i++){
            if(sum + a[i] > k){
                subarrays++;
                sum = a[i];
            } else {
                sum += a[i];
            }
        }
        return subarrays;
    }


}
