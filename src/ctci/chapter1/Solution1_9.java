package ctci.chapter1;

import org.junit.Test;

public class Solution1_9 {
    //ctci1.8
    public boolean isRotation(String s1, String s2) {
        int len = s1.length();
        if(len==s2.length()) {
            String s1s1 = s1+s1;
            return s1s1.contains(s2);
        }
        return false;
    }

    @Test
    public void test(){
        System.out.println(isRotation("waterboetle","erbottlewat"));
        System.out.println(isRotation("",""));
    }
}
