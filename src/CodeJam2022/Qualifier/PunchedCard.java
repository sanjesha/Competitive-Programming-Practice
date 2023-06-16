package CodeJam2022.Qualifier;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class PunchedCard {
    public static void main(String[] args) {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(reader);
        int nTestCases = sc.nextInt();

        for (int testCase = 0; testCase < nTestCases; testCase++) {
            int R = sc.nextInt();
            int C = sc.nextInt();

            System.out.println("Case #" + (testCase + 1) + ": ");
            printAsciiArt(R, C);

        }
    }



    public static void printAsciiArt(int r, int c) {
        char[] border = new char[2*c + 1];
        char[] row = new char[2*c + 1];
        for(int i=0; i<2*c; i+=2) {
            border[i] = '+';
            border[i+1] = '-';
            row[i] = '|';
            row[i+1] = '.';
        }
        border[2*c] = '+';
        row[2*c] = '|';

        char[] topBorder = Arrays.copyOf(border, 2*c+1);
        char[] topRow = Arrays.copyOf(row, 2*c+1);
        topBorder[0] = '.';
        topBorder[1] = '.';
        topRow[0] ='.';
        topRow[1] = '.';

        String strBorder = new String(border);
        String strRow = new String(row);
        String strTopBorder = new String(topBorder);
        String strTopRow = new String(topRow);


        System.out.println(strTopBorder);
        System.out.println(strTopRow);
        for(int i=2; i<2*r; i += 2){
            System.out.println(strBorder);
            System.out.println(strRow);
        }
        System.out.println(strBorder);

    }
}

