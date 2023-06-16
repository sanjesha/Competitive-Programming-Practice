package Practice;
import java.io.*;
import java.util.*;
// Add any extra import statements you may need here


class TrappingRainWater {

    // Add any helper functions you may need here


    int getTrappedRainWater(int[] arr) {
        // Write your code here
        Stack<Pair> stack = new Stack<>();
        int ans = 0;
        for(int i=0; i< arr.length; i++){
            Pair p = new Pair(arr[i],i);
            if(stack.isEmpty() || stack.peek().val >= arr[i] ){
                stack.push(p);
            } else {
                Pair lastVal = new Pair(-1,-1);
                int sum = 0;
                int lastIndex = i;
                while(!stack.isEmpty() && stack.peek().val < arr[i]){
                    lastVal = stack.pop();
                    sum += lastVal.val*(lastIndex - lastVal.index);
                    lastIndex = lastVal.index;
                }

                if(stack.isEmpty()){
                    ans += lastVal.val*(i - lastVal.index-1) - (sum - lastVal.val);
                } else {
                    ans += arr[i]*(i - lastVal.index) - sum;
                }
            }
        }



        return ans;
    }

    private class Pair {
        int val;
        int index;

        public Pair(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }






    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom.

    int test_case_number = 1;

    void check(int expected, int output) {
        boolean result = (expected == output);
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.format(wrongTick + " Test #" + test_case_number + ": Expected %d", expected);
            System.out.format(" Your output: %d", output);
            System.out.println();
        }
        test_case_number++;
    }

    public void run() {
        int[] inputOne = {7, 4, 0, 9};
        int outputOne = getTrappedRainWater(inputOne);
        check(10, outputOne);

        int[] inputTwo = {6, 9, 9};
        int outputTwo = getTrappedRainWater(inputTwo);
        check(0, outputTwo);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new TrappingRainWater().run();
    }
}