package LeetCode;

import java.util.Arrays;

public class MinRectArea {
    public int minAreaRect(int[][] points) {
        Arrays.sort(points, (a, b) -> a[0] - b[0]);

        return 0;
    }
}
