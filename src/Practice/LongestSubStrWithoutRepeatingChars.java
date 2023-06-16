package Practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubStrWithoutRepeatingChars {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<>();
        int startPosOfSubStr = 0;
        int subStrLen = 0;
        for(int i=0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                int indexOfRepeatedChar = map.get(s.charAt(i));
                subStrLen = i - startPosOfSubStr;
                maxLen = Math.max(maxLen, subStrLen);
                for(int j=startPosOfSubStr; j<= indexOfRepeatedChar; j++){
                    map.remove(s.charAt(j));
                }
                startPosOfSubStr = indexOfRepeatedChar + 1;
            }
            map.put(s.charAt(i),i);

        }
        subStrLen = s.length() - startPosOfSubStr;
        maxLen = Math.max(maxLen, subStrLen);
        return maxLen;
    }
}
