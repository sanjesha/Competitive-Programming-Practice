package Practice;

import java.util.Stack;

public class MaxValidParenthSeq {
    public int longestValidParentheses(String s) {
        int maxlen=0;
        char[] c =  s.toCharArray();
        int slen = s.length();
        for(int i=0; i<slen; i++){
            if(c[i]==')')
                continue;
            int len  = 0;
            int pCount=0;
            if(maxlen >= slen-i)
                return maxlen;
            for(int j=i; j<slen; j++){
                if(c[j]=='('){
                    pCount++;
                }else if (c[j] == ')') {
                    pCount--;
                }
                if(pCount>=0){
                    len++;
                    if(pCount==0){
                        maxlen = Math.max(maxlen,len);
                    }
                } else {
                    pCount=0;
                    len = 0;
                }
            }

        }


        return maxlen;
    }
    public int longestValidParentheses1(String s) {
        Stack<Character> stack = new Stack<>();
        int maxlen=0;
        int len  = 0;
        for (char c: s.toCharArray()) {
            if(c == ')' ) {
                if(!stack.empty() && stack.peek() == '('){
                    stack.pop();
                    len++;
                    maxlen = Math.max(maxlen,len);
                } else {
                    stack.push(c);
                    len = 0;
                }
            } else if(c == '('){
                len = 0;
                stack.push(c);
            }
        }
        return 2*maxlen;
    }
}
