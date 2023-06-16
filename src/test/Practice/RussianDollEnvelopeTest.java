package Practice;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;

class RussianDollEnvelopeTest {

    @Test
    void testSort(){
        int[][] a = {
                {5,4}, {6,7}, {6,4},{2,3}
        };

        Arrays.sort(a, Comparator.comparingInt(i -> i[0]));
        System.out.println(Arrays.deepToString(a));

    }

    @Test
    void testMaxEnv(){
        RussianDollEnvelope rd = new RussianDollEnvelope();
        int[][] a = {
                {5,4}, {5,5}, {6,5},{2,3}
        };
        System.out.println(rd.maxEnvelopes(a));
    }

    @Test
    void testMaxEnv1(){
        RussianDollEnvelope rd = new RussianDollEnvelope();
        int[][] a = {
                {2,100},{3,200},{4,300},{5,500},{5,400},{5,250},{6,370},{6,360},{7,380}
        };
        System.out.println(rd.maxEnvelopes(a));
    }

    @Test
    void testMaxEnv2(){
        RussianDollEnvelope rd = new RussianDollEnvelope();
        int[][] a = {
                {1,3},{3,5},{6,7},{6,8},{8,4},{9,5}
        };
        System.out.println(rd.maxEnvelopes(a));
    }
}