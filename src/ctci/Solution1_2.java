package ctci;

import org.junit.Test;

import java.util.HashMap;
import java.util.HashSet;

public class Solution1_2 {
    //用数组来解代码更简洁，上一题用了，这题就换下
    public boolean CheckPermutation(String s1, String s2) {
        int s1len = s1.length(), s2len = s2.length();
        if(s1==null || s2==null ||s1len!=s2len)
            return false;
        if(s1len==s2len && s2len==0)
            return true;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<s1len; i++) {
            char temp = s1.charAt(i);
            Integer cur = map.get(temp);
            map.put(temp,cur==null?1:cur+1);
        }
        for(int i = 0; i<s2len; i++) {
            char temp = s2.charAt(i);
            Integer cur = map.get(temp);
            if(cur==null)
                return false;
            else if(cur==1)
                map.remove(temp);
            else
                map.put(temp,cur-1);
        }
        return map.isEmpty();
    }

    @Test
    public void test2(){
        System.out.println(CheckPermutation("str","rst"));
    }


    //小例题
    public String reverse(String str) {
        if(str==null || str.length()==0)
            return str;
        StringBuffer sb = new StringBuffer(str);
        int i = 0;
        int j = str.length()-1;
        while(i<j) {
            char temp = sb.charAt(i);
            sb.setCharAt(i,sb.charAt(j));
            sb.setCharAt(j,temp);
            i++; j--;
        }
        return sb.toString();
    }

    @Test
    public void test1(){
        System.out.println(reverse("zhan"));
    }

}
