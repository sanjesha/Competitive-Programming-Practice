package Practice;

public class LongestPalindromicSubString {
    public String longestPalindrome(String s) {
        int n=s.length();
        int[][] L = new int[n][n];
        int[][] S = new int[n][n];
        int[][] E = new int[n][n];
        LPS(s,0,n-1,L,S,E);
        int b=S[0][n-1];
        int e=E[0][n-1];
        return s.substring(b,e+1);
    }

    private int LPS(String s, int i, int j, int[][] L, int[][] S, int[][] E) {
        if(i>j)
            return 0;

        if(i==j){
            L[i][j]=1;
            S[i][j]=i;
            E[i][j]=j;
            return 1;
        }

        if(j-i == 1 && s.charAt(i) == s.charAt(j)){
            L[i][j]=2;
            S[i][j]=i;
            E[i][j]=j;
            return 2;
        }



        if(L[i][j] > 0)
            return L[i][j];


       int l1 =  LPS(s,i,j-1,L,S,E);
       int l2 =  LPS(s,i+1, j, L, S, E);
       int l3 = LPS(s,i+1,j-1, L, S, E);
        if(S[i+1][j-1] == i+1 && E[i+1][j-1]==j-1 && s.charAt(i) == s.charAt(j)){
            S[i][j]=i;
            E[i][j]=j;
            L[i][j] = L[i+1][j-1]+2;
        } else {
            if(l1>l2){
                S[i][j]=S[i][j-1];
                E[i][j]=E[i][j-1];
                L[i][j] = L[i][j-1];
            } else {
                S[i][j]=S[i+1][j];
                E[i][j]=E[i+1][j];
                L[i][j] = L[i+1][j];
            }
        }
        return L[i][j];


    }
}
