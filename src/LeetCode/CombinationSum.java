package LeetCode;

import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationSum2(candidates, target, 0);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target, int pos) {
        if(target == 0){
            List<Integer> list = new ArrayList<>();
            List<List<Integer>> ll = new ArrayList<>();
            ll.add(list);
            return ll;
        }

        if(pos >= candidates.length)
            return null;

        if(target < 0)
            return null;

       /* if(candidates[pos] == target){
            List<Integer> list = new ArrayList<>();
            list.add(candidates[pos]);
            List<List<Integer>> ll = new ArrayList<>();
            ll.add(list);
            return ll;
        }*/



        List<List<Integer>> result = new ArrayList<>();
        List<List<Integer>> l1 = combinationSum2(candidates, target-candidates[pos], pos+1);
        if(l1 != null){
            for(List<Integer> list : l1){
                list.add(candidates[pos]);
            }
            result.addAll(l1);
        }

        while(pos+1 < candidates.length && candidates[pos+1] == candidates[pos])
            pos++;
        List<List<Integer>> l2 = combinationSum2(candidates, target, pos+1);
        if(l2 != null){
            result.addAll(l2);
        }

        if(l1 == null && l2 == null)
            return null;

        return result;

    }

}
