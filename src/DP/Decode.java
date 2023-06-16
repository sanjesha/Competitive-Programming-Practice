package DP;

import java.util.HashMap;
import java.util.Map;

public class Decode {

    public int numDecodings(String s) {
        Map<String,Integer> cache = new HashMap<>();
        return numDecodings(s, cache);

    }


    public int numDecodings(String s, Map<String,Integer> cache) {

        if(s == null || s.isEmpty())
            return 1;
        if(s.startsWith("0"))
            return 0;
        if(s.length() == 1)
            return 1;
        if(cache.containsKey(s))
            return cache.get(s);

        char[] mesg = s.toCharArray();
        int startInt = Integer.parseInt(s.substring(0,2));
        int result = 0;
        if (startInt < 27) {
            if(s.charAt(1) != '0'){
                result =   numDecodings(s.substring(1), cache) + numDecodings(s.substring(2),cache);
            } else {
                result = numDecodings(s.substring(2), cache);
            }
        } else {
            result =  numDecodings(s.substring(1), cache);
        }
        cache.put(s, result);
        return result;
    }
}
