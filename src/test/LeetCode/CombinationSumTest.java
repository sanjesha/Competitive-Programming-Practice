package LeetCode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CombinationSumTest {

    @Test
    void testSum(){
        CombinationSum cs = new CombinationSum();
      //  int[] a = new int[]{10,1,2,7,6,1,5};
        int[] a = new int[]{1,7,6,1};

        System.out.println(cs.combinationSum2(a, 8));

    }

}