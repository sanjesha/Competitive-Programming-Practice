package Practice;

public class PatternMatch {

    public boolean isMatch(String s, String p) {
        if(s==null){
            if(p==null ||  p.equals("*"))
                return true;
            else
                return false;
        }



        char[] sCharArr = s.toCharArray();
        char[] pCharArr = p.toCharArray();
        char prev = ' ';
        for(int i=0, j=0; i<p.length(); i++, j++) {
            if(p.charAt(i)=='*'){
                if(prev=='.'){

                }
                while(j<s.length() && s.charAt(j++)==prev);


            }
            if (s.charAt(0) == p.charAt(0)){

            }
        }
        return false;
    }
}
