package leetcode.greedy;

import org.junit.Test;

public class Solution_121 {
    public int maxProfit(int[] prices) {
        int N = prices.length;
        if(prices==null||prices.length==0||prices.length==1) return 0;
        int min = prices[0];
        int res = 0;
        for(int i = 1;i<N;i++) {
            if(min>prices[i]) min=prices[i];
            else res = Math.max(res,prices[i]-min);
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(maxProfit(new int[]{7,6,4,3,1}));
    }
}
