package ctci;

import org.junit.Test;

import java.util.HashSet;

public class Solution1_1 {
    public boolean isUnique(String astr) {
        if(astr==null)
            return false;
        boolean isDiff = true;
        //hash表
        boolean[] hash = new boolean[128];
        char[] chars = astr.toCharArray();
        for(char ch:chars) {
            if(hash[ch]==true) {
                isDiff = false;
                break;
            }
            hash[ch]=true;
        }
        return isDiff;
    }

    @Test
    public void test(){
        System.out.println(isUnique("leetcode"));
    }
}
