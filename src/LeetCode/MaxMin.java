package LeetCode;

import java.util.Arrays;
import java.util.Optional;
import java.util.OptionalInt;

public class MaxMin {
    public int maximizeSweetness(int[] sweetness, int k) {
        int low = Arrays.stream(sweetness).min().getAsInt();
        int high = Arrays.stream(sweetness).sum();
        int maxmin = Integer.MIN_VALUE;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(splitPossible(sweetness,k,mid)){
                maxmin = Math.max(maxmin, mid);
                low = mid+1;
            } else {
                high = mid -1;
            }
        }

        return maxmin;
    }

    private boolean splitPossible(int[] sweetness, int k, int min) {
        int sum = 0;
        int partitions = 0;
        for(int i=0; i<sweetness.length; i++){
            sum += sweetness[i];
            if(sum >= min){
                partitions++;
                if(partitions > k)
                    return true;
                sum = 0;
            }
        }
        return false;
    }

    private int getMin(int[] sweetness) {
        int min = Integer.MAX_VALUE;
        for (int i: sweetness) {
            min = Math.min(min,sweetness[i]);
        }
        return 0;
    }
}
