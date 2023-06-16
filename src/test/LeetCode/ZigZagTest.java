package LeetCode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ZigZagTest {

    @Test
    void test1(){
        ZigZag z = new ZigZag();
        String s= z.convert("PAYPALISHIRING",3);
        System.out.println(s);
    }

}