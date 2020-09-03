package leetcode.binarysearch;

/**
 * 寻找旋转排序数组中的最小值
 */
public class Solution_153 {
    public int findMin(int[] nums) {
        int f = 0, l = nums.length-1;
        while(f<l) {
            int m = f+(l-f)/2;
            if(nums[m]>nums[l]) {
                f = m+1;
            } else {
                l = m;
            }
        }
        return nums[f];
    }
}
