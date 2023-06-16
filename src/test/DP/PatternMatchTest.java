package DP;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PatternMatchTest {

    @Test
    void testPatternMatch(){
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        String p = "c*aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa*b.*";
        PatternMatch pm = new PatternMatch();
        System.out.println(pm.isMatch(s,p));

    }

    @Test
    void testToArray(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        Integer[] a = new Integer[2];
        a = list.toArray(a);
    }

}