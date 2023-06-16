package CodeJam2021.Round1A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;
import java.util.stream.IntStream;

public class PrimeTime1 {
    public static final int MAX_PRIME_COUNT = 95;
    public static int[] prime = new int[MAX_PRIME_COUNT];
    public static int[][] primeFactors = new int[3500][MAX_PRIME_COUNT];

    public static void main(String[] args) {

        findPrimes();
        findPrimeFactors();



        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(reader);
        int nTestCases = sc.nextInt();


        for (int testCase = 0; testCase < nTestCases; testCase++) {
            int m = sc.nextInt();
            long[][] card = new long[m][3];
            long n = 0;
            long sum = 0;
            HashMap<Long,Long> input = new HashMap<>();
            for (int i = 0; i < m; i++) {
                card[i][0] = sc.nextLong();
                card[i][1] = sc.nextLong();
                n += card[i][1];
                sum += card[i][0] * card[i][1];
                input.put(card[i][0], card[i][1]);
            }
            int indexSumLimit = (int) Math.ceil(Math.log(sum) / Math.log(card[0][0]));
            int maxProdSum = (int) (Math.ceil(Math.log(sum) / Math.log(card[m-1][0]))  * card[m-1][0]);

            long max = 0;
            boolean possible;
            for(int i=maxProdSum; i>0; i--){
                if(primeFactors[i][0] == -1)
                    continue;
                possible = true;
                long product = 1;
                for(int j = 0; j< MAX_PRIME_COUNT; j++){
                    if(primeFactors[i][j] > 0 ){
                        if(input.containsKey(prime[j])){
                            if(input.get(prime[j]) < primeFactors[i][j] ){
                                possible = false;
                                break;
                            } else {
                                product *= (long) Math.pow(prime[j], primeFactors[i][j]);
                            }

                        } else {
                            possible = false;
                            break;
                        }
                    }
                }
                if(possible){
                    if((sum - i) == product){
                        max = product;
                        break;
                    }
                }
            }

            System.out.println("Case #" + (testCase + 1) + ": " + max);


        }
    }

    private static void findPrimes() {
        prime[0] = 2;
        int num = 2;
        for(int i = 1; i< MAX_PRIME_COUNT; i++ ){
            boolean isPrime = false;

            while(!isPrime ) {
                num++;
                isPrime = true;
                for (int j = 0; j < i; j++) {
                    if (num % prime[j] == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }

            if (isPrime){
                    prime[i] = num;
            }
        }
    }



    private static void findPrimeFactors() {
        for(int i=1; i<3500; i++){
            int t = i;

            for(int j=0; j<MAX_PRIME_COUNT && t>1; j++){

                if(t % prime[j] == 0){
                    int k = 0;
                    while(t>1 && t % prime[j] == 0 ){
                        t = t/prime[j];
                        k++;
                    }
                    primeFactors[i][j] = k;
                }
            }
            if(t!=1){
                primeFactors[i][0] = -1;
            }
        }

    }
}
