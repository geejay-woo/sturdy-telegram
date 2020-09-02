package leetcode.binarysearch;

import org.junit.Test;

public class Solution_69 {
    public int mySqrt(int x) {
        if(x<=1) return x;
        int f = 1, l = x;
        while(f<=l) {
            int m = f+(l-f)/2;
            if((long)m*m==x) {
                return m;
            } else if((long)m*m<x) {
                f = m+1;
            } else {
                l = m-1;
            }
        }
        return l;
    }

    @Test
    public void test(){
        System.out.println(mySqrt(8));
    }
}
