package LeetCode;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class MaxMinTest {

    @Test
    void testMaxMin(){
       // int[] a = {5,6,7,8,9,1,2,3,4};
        int[] a = {1,2};
        MaxMin m = new MaxMin();
        System.out.println(m.maximizeSweetness(a,1));

    }

}