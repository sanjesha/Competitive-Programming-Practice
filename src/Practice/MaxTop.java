package Practice;

import java.util.Arrays;

public class MaxTop {
    public int maximumTop(int[] nums, int k) {
        if(k==0)
            return nums[0];

        int n = nums.length;

        if( n==1 && k%2 == 1)
            return -1;


        int prevmax = -1;
        int max = -1;
        int i=0;
        for( i=0; i<k; i++){
            if(i>=n){
                prevmax = max;
                break;
            }

            prevmax = max;
            max = Math.max(nums[i], max);
        }

        if(i<n)
            prevmax = Math.max(nums[i],prevmax);
        return prevmax;
    }
}
