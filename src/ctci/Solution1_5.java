package ctci;

import org.junit.Test;

public class Solution1_5 {
    /**
     * 本题为leetcode1.4
     * 给定一个字符串，编写一个函数判定其是否为某个回文串的排列之一。
     * @param s
     * @return
     */
    public boolean canPermutePalindrome(String s) {
        if(s==null) return false;
        if(s.length()==0) return true;
        int[] ints = new int[128];
        for(int i = 0; i<s.length(); i++) {
            int index = s.charAt(i)-'0'+48;
            ints[index] = ints[index]==0?1:0;
        }
        int cnt = 0;
        for(int i = 0; i<128; i++)
            if(ints[i]==1) cnt++;
        return cnt==1 || cnt==0;
    }

    @Test
    public void test(){
//        System.out.println(canPermutePalindrome("aa"));
        System.out.println((int)'0');
    }
}
