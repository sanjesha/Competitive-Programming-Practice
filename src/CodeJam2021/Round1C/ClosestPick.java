package CodeJam2021.Round1C;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class ClosestPick {


    public static void main(String[] args) {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(reader);
        int nTestCases = sc.nextInt();


        for (int testCase = 0; testCase < nTestCases; testCase++) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[][] picks = new int[n + 1][2];
            int[] input = new int[n];
            for (int i = 0; i < n; i++) {
                int t = sc.nextInt();
                input[i] = t;

            }

            Arrays.sort(input);


            int prev = 1;
            picks[0][0] = input[0];
            picks[0][1] = input[0] - 1;
            for (int i = 1; i < n; i++) {
                picks[i][0] = input[i];
                int diff = (input[i] - prev) / 2;
                picks[i][1] = diff;
                prev = input[i];
            }
            if(n>1) {
                picks[n][1] = k - prev;
            } else {
                picks[n][1] = k - input[0];

            }
            double prob = getMaxProbability(picks, n, k);
            System.out.println("Case #" + (testCase + 1) + ": " + prob);

        }
    }


    private static double getMaxProbability ( int[][] picks, int n, int k){
        TreeMap<Integer, Integer> tmap = new TreeMap<>();
        TreeMap<Integer, Integer> tmap1 = new TreeMap<>();

        tmap.put(picks[0][1] - 1, 1);
        tmap1.put(picks[0][1] - 1 , 1);
        int prev = picks[0][0];
        for(int i=1; i <n; i++){
            if(tmap.containsKey(picks[i][1])){
                int count =  tmap.get(picks[i][1]);
                count++;
                tmap.put(picks[i][1], count);
            } else {
                tmap.put(picks[i][1], 1);
            }

            if(tmap1.containsKey(picks[i][0] - prev -1)){
                int count =  tmap1.get(picks[i][0] - prev -1);
                count++;
                tmap1.put(picks[i][0] - prev -1, count);
            } else{
                tmap1.put(picks[i][0] - prev - 1, 1);
            }
            prev = picks[i][0];

        }
        tmap.put(picks[n][1], prev + 1);

        int maxRange = 0;
        Map.Entry<Integer, Integer> e1 = tmap.lastEntry();
        Map.Entry<Integer,Integer> e2 = tmap.lowerEntry(e1.getKey());
        if(e1.getValue() > 1){
            maxRange = 2 * e1.getKey();
        } else {
            maxRange = e1.getKey() + e2.getKey();
        }

        Map.Entry<Integer, Integer> midRange = tmap1.lastEntry();
        if(maxRange < midRange.getKey())
            maxRange =  midRange.getKey();

        return  (double)maxRange/ (double)k;
    }
}
