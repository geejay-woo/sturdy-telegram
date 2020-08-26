package leetcode.doublepointer;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Solution_345 {

    List<Character> list = Arrays.asList('a','e','i','o','u','A','E','I','O','U');

    public String reverseVowels(String s) {
        int i = 0, j = s.length()-1;
        char[] chars = s.toCharArray();
        while(i<j) {
            while(i<=j && !list.contains(chars[i])) i++;
            while(j>=i && !list.contains(chars[j])) j--;
            if(i<j) {
                char t = chars[i];
                chars[i] = chars[j];
                chars[j] = t;
            }
            i++; j--;
        }
        return new String(chars);
    }
    @Test
    public void test(){
        System.out.println(reverseVowels("hello"));
    }
}
