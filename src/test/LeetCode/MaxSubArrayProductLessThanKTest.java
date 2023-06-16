package LeetCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaxSubArrayProductLessThanKTest {

    @Test
    void testgetcount(){
        MaxSubArrayProductLessThanK o = new MaxSubArrayProductLessThanK();
        //int[] a = {10,5,2,6};
        int[] a = {57,44,92,28,66,60,37,33,52,38,29,76,8,75,22};
        System.out.println(o.numSubarrayProductLessThanK(a, 18));
    }

}