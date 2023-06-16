package DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfWaysToParenthesize {
    int maxWaysToParenthesize(int n){
        //n pairs if brackets
        int[][] cache = new int[n+1][n+1];
        return numberOfWaysToPlaceParenthesis(n,n, cache);
    }

    private int numberOfWaysToPlaceParenthesis(int nOpeningBraces, int nClosingBraces, int[][] cache) {
        if(nOpeningBraces > nClosingBraces)
            return 0;

        if(nOpeningBraces ==0)
            return 1;

        if(cache[nOpeningBraces][nClosingBraces] > 0)
            return cache[nOpeningBraces][nClosingBraces];

        //We can either pick an opening brace or a closing brace and find the ways the remaining braces can be placed.
        int sum = numberOfWaysToPlaceParenthesis(nOpeningBraces-1 , nClosingBraces, cache)
                +  numberOfWaysToPlaceParenthesis(nOpeningBraces  ,nClosingBraces-1, cache);

        cache[nOpeningBraces][nClosingBraces] = sum;

        return sum;

    }

}
