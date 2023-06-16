package DP;

public class MaxSubarray {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int maxPrev =  Integer.MIN_VALUE;
        for(int i=0; i< nums.length; i++){
            maxPrev = Math.max(nums[i] + maxPrev, nums[i]);
            maxSum = Math.max(maxSum,maxPrev);
        }
        return maxSum;
    }
}
