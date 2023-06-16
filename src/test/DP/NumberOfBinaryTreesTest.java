package DP;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfBinaryTreesTest {

    @Test
    void testMaxBinTree(){
        NumberOfBinaryTrees nb = new NumberOfBinaryTrees();
        for (int i=0; i<10; i++){
            System.out.println(nb.maxBinaryTrees(i));
        }
    }

}