package CodeJam2022.Qualifier;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Print3D {
    public static void main(String[] args) {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(reader);
        int nTestCases = sc.nextInt();

        int[][] printerInk = new int[3][4];
        for (int testCase = 0; testCase < nTestCases; testCase++) {

            for(int i=0; i<3; i++){
                for(int j=0; j<4; j++){
                    printerInk[i][j] = sc.nextInt();
                }
            }

            System.out.print("Case #" + (testCase + 1) + ": ");
            printCMYK(printerInk);
            System.out.println();
        }
    }

    public static void printCMYK(int[][] printerInk) {
        int minC = getMin(printerInk[0][0], printerInk[1][0], printerInk[2][0]);
        int minM = getMin(printerInk[0][1], printerInk[1][1], printerInk[2][1]);
        int minY = getMin(printerInk[0][2], printerInk[1][2], printerInk[2][2]);
        int minK = getMin(printerInk[0][3], printerInk[1][3], printerInk[2][3]);
        String solution;
        int max = 1000000;
        if(minC >= max){
            minC = max;
            System.out.print(minC + " "  + 0  + " "  + 0  + " "  + 0 );
            return;
        } else {
            max = max - minC;
        }

        if(minM >= max){
            minM = max;
            System.out.print(minC + " " + minM  + " " + 0  + " " + 0 );
            return;

        } else {
            max = max - minM;
        }

        if(minY >= max){
            minY = max;
            System.out.print(minC + " " + minM  + " " + minY  + " " + 0 );
            return;

        } else {
            max = max - minY;
        }

        if(minK >= max){
            minK = max;
            System.out.print(minC +" " + minM  + " " + minY  +" " + minK );
            return;

        } else {
            max = max - minK;
        }

        System.out.println("IMPOSSIBLE");


    }

    private static int getMin(int i, int j, int k) {
        int min = i < j ? i : j;
        min = k < min ? k : min;

        return min;
    }
}
