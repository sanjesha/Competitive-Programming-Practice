package DP;

public class PatternMatch {
    //T[i][j] =  if S(0..i-1) matches P(0..j-1)
    //T[i][0] = F
    //T[0][j] = F

    public boolean isMatch(String s, String p) {

        boolean[][]  T = new boolean[s.length()+1][p.length()+1];
        boolean[][]  found = new boolean[s.length()+1][p.length()+1];

        return isMatch(s, s.length(), p, p.length(), T, found);
    }

    private boolean isMatch(String s, int n, String p, int m, boolean[][] T, boolean[][] found) {

        if(n==0 && m==0)
            return true;

        if(found[n][m]) {
            System.out.println("Cache Hit");
            return T[n][m];
        }

        if(m==0)
            return false;

        if(p.charAt(m-1) == '*'){
            if(matches(s,n-1,p,m-2)) {
                T[n][m] = isMatch(s, n, p, m - 2, T, found) || isMatch(s, n - 1, p, m, T, found);
            } else {
                T[n][m] = isMatch(s, n, p, m - 2, T, found);
            }
            found[n][m] = true;
            return T[n][m];
        }else if(matches(s,n-1,p,m-1)) {
            T[n][m] = isMatch(s, n - 1, p, m - 1, T, found);
            found[n][m] = true;
            return  T[n][m];
        }


        return false;
    }

    private boolean matches(String s, int i, String p, int j) {
        if(i== -1 && j==-1)
            return true;

        if(i < 0 || j<0)
            return false;

        return p.charAt(j) == '.' || s.charAt(i) == p.charAt(j);
    }
}
