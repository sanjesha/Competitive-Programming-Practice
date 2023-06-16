package DivideAndConquer;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ClosestPointsTest {

    @Test
    void testClosestPoint(){
        ClosestPoints cp = new ClosestPoints();
        int[][] points = { {4,5}, {8,9}, {5,3}, {1,1}};
        int[][] sol = cp.closestPoints(points);
    }

    @Test
    void testSet(){
        int[] a ={ 1,2};
        int[] b = {3,4};
        System.out.println(Arrays.toString(a));
        Set<int[]> set = new HashSet<>();
        set.add(a);
        set.add(b);
        set.forEach(x -> System.out.println(Arrays.toString(x)));
    }

}