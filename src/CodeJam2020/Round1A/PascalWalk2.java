package CodeJam2020.Round1A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalWalk2 {
    public static void main(String[] args) {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(reader);
        int nTestCases = sc.nextInt();

        for (int i = 0; i < nTestCases; i++) {
            int n = sc.nextInt();
            List<Integer> x = new ArrayList<>();
            List<Integer> y = new ArrayList<>();
            findPascalWalk(n, x, y);
            System.out.println("Case #"+ (i+1) + ":");
            for(int k=0; k<x.size(); k++){
                System.out.println(x.get(k) + " " + y.get(k));
            }

        }
    }

    private static void findPascalWalk(int n, List<Integer> x, List<Integer> y) {
        int maxZeros = (int) Math.ceil(Math.log(n)/Math.log(2.0));
        int t = n - maxZeros;
        int r = 1;
        int k = 1;
        int nZero = 0;
        while(t != 0){
            if( (t & 1) == 1 ){
                for(int i=0; i<r; i++){
                    x.add(r);
                    if(k ==1){
                        y.add(i+1);
                    } else {
                        y.add(r-i);
                    }
                }
                k =  (k == 1) ? r : 1;
            } else {
                nZero++;
                x.add(r);
                if(k != 1)
                    k = r;
                y.add(k);
            }
            t = (t >> 1);
            r++;
        }
        int numberOfOnesToAdd = maxZeros - nZero;
        for(int i=0; i<numberOfOnesToAdd; i++){
            if(k != 1)
                k = r;
            x.add(r);
            y.add(k);
            r++;
        }
    }
}
