package CodeJam2020.Round1A;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PascalWalkTest {

    @Test
    void testNCR(){
        int t =  PascalWalk.getNCR(3,2);
        assertEquals(2, t);
    }

    @Test
    void testShiftLeft(){
        int i = 3;
        System.out.println(i&1);
        System.out.println(i >> 1);
        System.out.println(Math.ceil(Math.log(1000000000)/Math.log(2.0)));
        long l1 = 1000000000;
        System.out.println(Math.ceil(Math.log(499*1000000000000000l)/Math.log(2)));
        double  outerBound =  Math.ceil(Math.log(499*1000000000000000l) / Math.log(2l));

    }

}