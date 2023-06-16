package LeetCode;

import java.util.*;

public class DeleteAndEarn {
    public int deleteAndEarn(int[] nums) {
     //   Map<Integer,Integer> cache = new HashMap<>();

        Map<Integer,Integer> points = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i:nums) {
            list.add(i);
            points.put(i,points.getOrDefault(i,0)+i);
        }
        Collections.sort(list);
        Set<Integer> set = points.keySet();
        int[] a = set.stream().mapToInt(num -> num).toArray();
       // return getMaxPoints(list, cache, points);
        Arrays.sort(a);
        int[] cache = new int[a.length];
        return getMax(a,0,cache, points);
    }

    private int getMax(int[] a, int i, int[] cache, Map<Integer, Integer> points) {
        if(i>= a.length)
            return 0;

        if(cache[i] > 0)
            return cache[i];

        int max1 = points.get(a[i]) + getMax(a,i+2, cache,points);
        int max2 = getMax(a,i+1, cache, points);
        cache[i] = Math.max(max1,max2);
        return cache[i];
    }

    private int getMaxPoints(List<Integer> list, Map<List<Integer>, Integer> cache,   Map<Integer,Integer> points) {
        if(list.isEmpty())
            return 0;

        if(cache.containsKey(list)) {
           // System.out.println("cache-hit");
            return cache.get(list);
        }

        int max = 0;
        for(int i = 0; i<list.size(); i++){
            int val = list.get(i);
            int maxp = val;
            while( (i+1) < list.size() && list.get(i+1) == val){
                maxp +=val;
                i++;
            }
            List<Integer> list1 = new ArrayList<>();
            for(int j = 0; j<list.size(); j++){
                int t = list.get(j);
                if(t != val && t!= val-1 && t!= val+1){
                    list1.add(t);
                }
            }
         //   Collections.sort(list1);
            maxp +=  getMaxPoints(list1,cache,points);
            max =  Math.max(max, maxp);
        }

        cache.put(list, max);
        return max;
    }
}
