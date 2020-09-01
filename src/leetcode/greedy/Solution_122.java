package leetcode.greedy;

public class Solution_122 {
    public int maxProfit(int[] prices) {
        if(prices==null||prices.length==0||prices.length==1) return 0;
        int res = 0;
        for(int i = 0; i<prices.length-1; i++)
            if(prices[i]<prices[i+1]) res+=prices[i+1]-prices[i];
        return res;
    }
}
