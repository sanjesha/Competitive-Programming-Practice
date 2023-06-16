package CodeJam2022.Round1A;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class PartitionIntegerSetTest {

    @Test
    void testArraySum(){
        int[] a = new int[0];
        int sum = Arrays.stream(a).sum();
        System.out.println(sum);
    }

    @Test
    void test2DArray(){
        int[][] A = new int[5][10];
        System.out.println(A.length);

        System.out.println(A[0].length);
        System.out.println(A[1].length);

        int[] B = A[0];
        System.out.println(B.length);

        int[] C = new int[1000000000];
        System.out.println(C.length);

    }

}