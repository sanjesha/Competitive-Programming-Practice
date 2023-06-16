package DP;

public class NumberOfBinaryTrees {
    int maxBinaryTrees(int n){
        int[] cache = new int[n+1];
        return maxBinaryTrees(n, cache);

    }

    int maxBinaryTrees(int n, int[] cache){
        if(n==0 || n==1)
            return 1;

        if(cache[n] > 0)
            return cache[n];

        int sum=0;
        for(int i=0; i<n; i++){
            sum += (maxBinaryTrees(i) * maxBinaryTrees(n-1-i));
        }
        cache[n] = sum;
        return sum;
    }
}
