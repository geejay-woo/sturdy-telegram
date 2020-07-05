package jzoffer;

import java.util.Arrays;

public class do21 {
    public static void reOrderArray(int[] nums) {

        //时间换空间，不是用辅助数组
        //使用冒泡思想，当前偶数上浮到最右边
        int N = nums.length;
        for(int i = N-1; i>0; i--)
            for(int j = 0; j<i; j++)
                if(nums[j]%2==0 && nums[j+1]%2!=0)
                    swap(nums,j,j+1);
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,8,7,10,3};
        reOrderArray(nums);
        System.out.println(Arrays.toString(nums));
    }
}
