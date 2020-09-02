package leetcode.greedy;

import org.junit.Test;

/**
 * 最大序列和：
 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 */
public class Solution_53 {
    public int maxSubArray(int[] nums) {
        int cur = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++) {
            cur+=nums[i];
            max = Math.max(cur,max);
            if(cur<0) cur = 0;
        }
        return max;
    }

    /**
     * 用动态规划
     * @param nums
     * @return
     */
    public int maxSubArray2(int[] nums) {
        if(nums==null||nums.length==0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i<dp.length; i++) {
            if(dp[i-1]<0) {
                dp[i] = nums[i];
            } else {
                dp[i] = dp[i-1]+nums[i];
            }
        }
        int res = dp[0];
        for(int i = 0; i<dp.length; i++) {
            res = Math.max(res,dp[i]);
        }
        return res;
    }


    @Test
    public void test(){
        System.out.println(maxSubArray2(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
