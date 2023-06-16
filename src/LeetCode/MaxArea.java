package LeetCode;

public class MaxArea {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int pStart = 0;
        int pEnd = height.length -1;
        while(pStart < pEnd){
            int len = Math.min(height[pStart], height[pEnd]);
            int area = len * (pEnd - pStart);
            maxArea = Math.max(maxArea, area);
            if(height[pStart] < height[pEnd])
                pStart++;
            else
                pEnd--;
        }

        return maxArea;
    }
}
