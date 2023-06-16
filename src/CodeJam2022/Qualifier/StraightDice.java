package CodeJam2022.Qualifier;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class StraightDice {
    public static void main(String[] args) {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(reader);
        int nTestCases = sc.nextInt();

        for (int testCase = 0; testCase < nTestCases; testCase++) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i=0; i<n; i++){
                a[i] =  sc.nextInt();
            }

            int len = getStraightLen(a);

            System.out.println("Case #" + (testCase + 1) + ": " + len);

        }
    }

    private static int getStraightLen(int[] a) {
        Arrays.sort(a);
        int count = 0;
        for(int i=0; i< a.length; i++){
            if(a[i] > count)
                count++;
        }
        return count;
    }
}
