package Practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromicSubStringTest {

    @Test
    void testLPS(){
        LongestPalindromicSubString lp = new LongestPalindromicSubString();
        System.out.println(lp.longestPalindrome("cbbd"));
    }


}