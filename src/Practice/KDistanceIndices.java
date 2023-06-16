package Practice;

import java.util.*;

public class KDistanceIndices {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {

        List<Integer> solution = new ArrayList<>();
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0; i < nums.length; i++){
            if(nums[i] == key)
                set.add(i);
        }

        int p = 0;
        for(int i=0; i < nums.length; i++){
            int keyIndex1 = -1;
            int keyIndex2 = -1;
            if(set.ceiling(i) != null) {
                 keyIndex1 = set.ceiling(i).intValue();
            }
            if (set.floor(i) != null) {
                 keyIndex2 = set.floor(i).intValue();
            }

            if (keyIndex1 != -1 && Math.abs(i - keyIndex1) <= k)
                solution.add(i);
            else if (keyIndex2 != -1 && Math.abs(i - keyIndex2) <= k)
                solution.add(i);

        }
        return solution;
    }
}
