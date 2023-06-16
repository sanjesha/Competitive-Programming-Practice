package LeetCode;

import java.util.Arrays;

public class StringPermutation {
    public boolean checkInclusion(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        String ss1 = new String(c1);
        String ss2 = new String(c2);
        return ss1.contains(ss2);

    }
}
