package Practice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquareRootTest {

    @Test
    void testSqrt(){
        SquareRoot sq = new SquareRoot();
        System.out.println(sq.sqrt(9990));
        System.out.println(Math.sqrt(9990.0));

    }

}