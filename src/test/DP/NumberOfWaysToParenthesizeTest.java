package DP;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfWaysToParenthesizeTest {

    @Test
    void testNumWaysToParenthisize(){
        NumberOfWaysToParenthesize nw = new NumberOfWaysToParenthesize();
        for(int i=0; i<10; i++){
            System.out.println(nw.maxWaysToParenthesize(i));
        }
    }

}