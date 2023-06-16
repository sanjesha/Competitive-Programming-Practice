package CodeJam2022.Round1A;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class HighlightedLetter {
    public static void main(String[] args) {

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        Scanner sc = new Scanner(reader);
        int nTestCases = sc.nextInt();

        for (int testCase = 0; testCase < nTestCases; testCase++) {
            String str = sc.next();

            String firstStr = getFirstString(str);

            System.out.println("Case #" + (testCase + 1) + ": " + firstStr);

        }
    }

    private static String getFirstString(String str) {
        StringBuilder sb = new StringBuilder();
        char[] cStr = str.toCharArray();
        boolean equalFlag = false;
        int equalCount = 0;
        for(int i=1; i<cStr.length; i++){
            sb.append(cStr[i-1]);
            if(cStr[i-1] == cStr[i]){
                equalFlag = true;
                equalCount++;
            } else if(cStr[i-1] < cStr[i]){
                sb.append(cStr[i-1]);
                if(equalFlag == true){
                    for(int j=0; j<equalCount; j++){
                        sb.append(cStr[i-1]);
                    }
                    equalFlag = false;
                    equalCount = 0;
                }

            } else {
                equalFlag = false;
                equalCount = 0;
            }
        }
        sb.append(cStr[cStr.length-1]);
        return sb.toString();
    }

}
