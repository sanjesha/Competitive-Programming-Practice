package CodeJam2022.Qualifier;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PunchedCardTest {

    @Test
    void testPC(){
        PunchedCard pc = new PunchedCard();
        pc.printAsciiArt(3,4);

    }

    @Test
    void testPrint(){
        for(int i=0; i<10; i++){
            System.out.print(i);
            System.out.print(" ");
        }
        System.out.println();
        System.out.println(10e9);
        System.out.println(Math.log(10e9));
        System.out.println(Math.log10(10e9));


        int logn = (int) (Math.log(1000000000.0)/Math.log(2.0));
        System.out.println(logn);
        System.out.println(Math.pow(2.0,logn));
    }

}