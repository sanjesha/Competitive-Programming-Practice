package LeetCode;

import java.util.Stack;

public class TrapRainWater {
    public int trap(int[] height) {
        int volume = 0;
        int p1 = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(height[p1]);
        for(int i=1; i<height.length; i++){
            if(height[i] < stack.peek()){
                stack.add(i);
            } else {
                while(height[i] > height[stack.peek()]){
                    volume += height[i] - stack.peek();
                    stack.pop();
                }
            }
        }

        return volume;
    }
}
