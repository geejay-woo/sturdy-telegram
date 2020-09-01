package leetcode.greedy;

import org.junit.Test;

import java.util.Arrays;

public class Solution_455 {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while(i<g.length && j<s.length) {
            if(g[i]<=s[j]) {
                i++;
            }
            j++;
        }
        return i;
    }

    @Test
    public void test(){
        System.out.println(findContentChildren(new int[]{1,2},new int[]{1,2,3}));
    }
}
