package LeetCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseIntTest {

    @Test
    void testReverse(){
        System.out.println(-32%10);
        ReverseInt ri = new ReverseInt();
        int result = ri.reverse(123);
        System.out.println(result);
        assertTrue(result == 321);
        result = ri.reverse(-123);
        System.out.println(result);
        assertTrue(result == -321);
        result = ri.reverse(Integer.MAX_VALUE);
        System.out.println(result);
        result = ri.reverse(Integer.MIN_VALUE);
        System.out.println(result);
        result = ri.reverse(101);
        System.out.println(result);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);

    }
}