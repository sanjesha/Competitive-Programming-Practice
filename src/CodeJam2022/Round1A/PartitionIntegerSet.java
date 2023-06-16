package CodeJam2022.Round1A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class PartitionIntegerSet {
    public static void main(String[] args) {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(reader);
        int nTestCases = sc.nextInt();

        for (int testCase = 0; testCase < nTestCases; testCase++) {
            int n = sc.nextInt();

            int logn = (int) (Math.log(1e9)/Math.log(2.0));
            logn = Math.min(logn,n-1);
            int[] pows = new int[32];
            for(int i=0;i<=logn;i++){
                pows[i] = 1;
                System.out.print((int)Math.pow(2.0,i));
                System.out.print(" ");
            }
            int remainingNos = n - (logn+1);
            int[] b = new int[remainingNos];
            int k = 2;
            for(int i=0; i< remainingNos; i++){
                k++;
                if(isPowerof2(k)){
                    k++;
                }
                b[i] = k;

                System.out.print(k);
                System.out.print(" ");
            }

            System.out.println();

            int[] a = new int[n];
            for (int i=0; i<n; i++){
                a[i] = sc.nextInt();
            }
         //   System.out.println("Case #" + (testCase + 1) + ": " );
            printFirstPartition(a,b,pows,n,logn);

        }
    }

    private static void printFirstPartition(int[] a, int[] b, int[] pows, int n, int logn) {
        Arrays.sort(a);

       // int logn = (int) (Math.log(1e9)/Math.log(2.0));

        long S1 = (long)Math.pow(2.0,logn+1) - 1;
        int lenb = b.length;
        long Sb = Arrays.stream(b).sum();

        long S2 = 0;
        long[] prefixSum = new long[n];
        TreeMap<Long,Integer> tmap = new TreeMap<>();
        for(int i=0; i< a.length; i++){
            S2 += a[i];
            prefixSum[i] = S2;
            tmap.put(S2,i);
        }

        long S = (S1 + Sb + S2)/2;
        long S3 = S - (S1+Sb);
        Map.Entry<Long,Integer> entry = tmap.ceilingEntry(S3);
        int diff = (int)(entry.getKey() - S3);
        String binaryStr = Integer.toBinaryString(diff);
        int[] exclude = new int[32];
        for(int i=binaryStr.length() - 1; i >= 0; i--){
            if(binaryStr.charAt(i) == '1'){
                exclude[binaryStr.length() -1-i] = 1;
            }
        }
        for(int i = 0; i<b.length; i++) {
            System.out.print(b[i]);
            System.out.print(" ");
        }


        for(int i = 0; i<=logn; i++){
             if(exclude[i] != 1) {
                 System.out.print((int)Math.pow(2.0,i));
                 System.out.print(" ");
             }
        }

        for(int i=0; i<=entry.getValue(); i++){
            System.out.print(a[i]);
            System.out.print(" ");
        }
        System.out.println();
    }

    public static boolean isPowerof2(int n){
        double a = Math.log(n) / Math.log(2.0);
        return (int) Math.ceil(a) == (int)Math.floor(a);
    }
}
