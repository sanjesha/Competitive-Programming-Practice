package LeetCode;

public class MyAtoI {
    public int atoi(String s) {

        int index = 0;
        while(s.charAt(index) == ' ' || s.charAt(index) == '\t')
            index++;

        long result = 0;
        int sign = 1;
        if(s.charAt(index) == '-')
            sign = -1;
        else if(s.charAt(index) != '+'){
            result = s.charAt(index) - '0';
        }

        for(int i=index+1; i<s.length(); i++){
            if(s.charAt(i) >=0 && s.charAt(i) <=9) {
                result = result * 10 + (s.charAt(i) - '0');
                if (result * sign > Integer.MAX_VALUE)
                    result = Integer.MAX_VALUE;
                if (result * sign < Integer.MIN_VALUE)
                    result = Integer.MIN_VALUE;
            }
        }

        return (int)result*sign;
    }
}
