package Practice;

import java.util.*;

public class SubstringWithConcat {
    public List<Integer> findSubstring(String s, String[] words) {
        int nw = words.length;
        List<Integer> iList = new ArrayList<>();
        List<Integer> sIndex = new ArrayList<>();
//        for (int i = 0; i < s.length(); i++) {
//            for(int j=0; j<words.length; j++){
//                if(s.charAt(i) == words[j].charAt(0)){
//                    sIndex.add(i);
//                    break;
//                }
//            }
//        }

        int strlen = words[0].length();


        Map<String, Integer> origMap = new HashMap<>();

        for (String w : words) {
            origMap.put(w, origMap.getOrDefault(w, 0) + 1);
        }

 //       for (Integer i: sIndex) {
        for(int i=0; i<s.length(); i++){
            int k = i;
            int wc = 0;
            Map<String, Integer> map = new HashMap<>(origMap);


         //   for (int j = i+maxStrLen; j <= s.length() && j-k <= maxStrLen; j++) {
            while(k+strlen <= s.length() ){
                String t = s.substring(k, k+strlen);
                if (map.containsKey(t) && map.get(t) > 0) {
                    wc++;
                    k = k+strlen;
                    map.put(t, map.get(t) - 1);
                    if (wc == nw) {
                        int count = 0;
                        for (String w : words) {
                            count += map.get(w);
                        }
                        if (count == 0)
                            iList.add(i);
                        break;
                    }
                } else {
                    break;
                }

            }
        }

        return iList;


    }
}
