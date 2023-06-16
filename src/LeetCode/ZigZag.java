package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class ZigZag {
    public String convert(String s, int numRows) {
        StringBuilder[] stringBuilders = new StringBuilder[numRows];

        for(int i=0; i<numRows; i++){
            stringBuilders[i] = new StringBuilder();
        }

        int index = 0;
        int direction = 0;
        for(int i=0; i<s.length(); i++){
            stringBuilders[index].append(s.charAt(i));
            if(direction == 0){
                if(index+1 == numRows){
                    direction = 1;
                    index--;
                } else {
                    index++;
                }
            } else {
                if(index == 0){
                    direction = 0;
                    index++;
                } else {
                    index--;
                }
            }

        }

        String result = "";
        for(int i=0; i< numRows; i++){
            result += stringBuilders[i].toString();
        }

        return result;

    }
}
