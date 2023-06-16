package CodeJam2021.Round1A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Scanner;


public class PrimeTime2 {


    private static final long MAX_PRIME =   499;

    public static void main(String[] args) {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(reader);
        int nTestCases = sc.nextInt();

        for (int testCase = 0; testCase < nTestCases; testCase++) {
            int m = sc.nextInt();
            long[][] card = new long[m][3];
            long n = 0;
            long sum = 0;

            for (int i = 0; i < m; i++) {
                card[i][0] = sc.nextLong();
                card[i][1] = sc.nextLong();
                n += card[i][1];
                sum += card[i][0] * card[i][1];


            }
            long indexSumLimit =  (long) Math.ceil(Math.log(sum) / Math.log(2.0));
            long maxProdSum = MAX_PRIME * indexSumLimit;

            long product = 1;
            long max = findMax(card, sum, product,0,0, m, indexSumLimit, maxProdSum, sum);


            System.out.println("Case #" + (testCase + 1) + ": " + max);


        }
    }

    private static long findMax(long[][] card, long sum,long product, int index, long sumOfProdGroup, int m, long indexSumLimit, long maxProdSum, long maxSum) {
        if (sum == product)
            return sum;

        if (index == m) {
            return 0;
        }

        int indexSum = 0;
        for(int i=0; i<index; i++){
            indexSum += card[i][2];
        }

        long pn = card[index][0];
        long max = 0;
        long primeProd = 1;
        long outerBound = (long) Math.ceil(Math.log(sum/product) / Math.log(pn));
        outerBound = Math.min(outerBound, card[index][1]);

        for(long i=0; i<=outerBound; i++) {
            if(indexSum + i > indexSumLimit)
                return max;

            card[index][2] = i;

            BigInteger bi= BigInteger.valueOf(product).multiply(BigInteger.valueOf(primeProd));
            if(bi.compareTo(BigInteger.valueOf(Long.MAX_VALUE)) > 0 )
                return 0;
            long newProd = product * primeProd;
            long newSum = sum - (pn*i);
            if(newProd >  newSum){
                return max;
            }

            if(newProd == newSum){
                return Math.max(newSum,max);
            }

            if((sumOfProdGroup + (pn *i)) > 3500) {
                return max;
            }


//
//            long max1 = findMax(card, newSum,  newProd,index+1, sumOfProdGroup + (pn *i), m, indexSumLimit, maxSum);
//            if(max1 > max) {
//                max = max1;
//            }
//            primeProd *= pn;

        }

        return max;

    }
}
