package jzoffer;

import java.util.ArrayList;
import java.util.Arrays;

public class do42 {
    public static void main(String[] args) {
        int res = do42.FindGreatestSumOfSubArray(new int[]{6,-3,-2,7,-15,1,2,2});
        System.out.println(res);
    }
    public static int FindGreatestSumOfSubArray(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i<nums.length; i++) {
            sum = sum+nums[i]<=0?0:sum+nums[i];
            max = Math.max(max,sum);
        }
        return max;
    }
}
