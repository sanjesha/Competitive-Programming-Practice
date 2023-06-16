package LeetCode;

public class ReverseInt {
    public int reverse(int x) {
        int result =0;
        int pow = 1;
        long temp = 0;
        while(x != 0){
            int rem = x % 10;
            x = x / 10;
            temp = temp*10 + rem;
            if(temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE)
                result = 0;
            else
                result = result*10 + rem;
        }

        return result;
    }
}
