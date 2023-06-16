package Practice;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SubstringWithConcatTest {

    @Test
    void testSubstring(){
        SubstringWithConcat sc = new  SubstringWithConcat();
        String[] words = {"foo", "bar"};
        List<Integer> list = sc.findSubstring("barfoothefoobarman", words);
        System.out.println(list);
    }

    @Test
    void testSubstring1(){
        SubstringWithConcat sc = new  SubstringWithConcat();
        String[] words = {"word","good","best","good"};
        String s= "wordgoodgoodgoodbestword";
        List<Integer> list = sc.findSubstring(s, words);
        System.out.println(list);
    }

}