package Practice;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class MaxSumRectangle {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        TreeSet<Integer> tset = new TreeSet<>();
        Map<String,Integer> cache = new HashMap<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                for(int i1=i; i1<m; i1++ ){
                    for(int j1=j; j1<n; j1++){
                        int sum = rectSum(matrix, i,j,i1,j1,cache);
                        tset.add(sum);

                    }
                }

            }
        }

        return tset.floor(k);
    }

    private int rectSum(int[][] matrix, int i, int j, int i1, int j1,  Map<String,Integer> cache){

        if(i1 < i || j1 < j )
            return 0;

        String key = Integer.toString(i) + ","+ Integer.toString(j) +"," + Integer.toString(i1) + ","+ Integer.toString(j1);
        if(cache.get(key) != null)
            return cache.get(key);

        int sum = matrix[i][j] + rectSum(matrix,i,j+1,i,j1,cache) + rectSum(matrix,i+1,j,i1,j,cache)
                + rectSum(matrix,i+1,j+1,i1,j1,cache);

        cache.put(key, sum);

        return sum;
    }
}
