package jzoffer;

public class do11 {
    /**
     * 旋转数组的最小数字，遍历取最小值没有利用到旋转数组的特性
     * 给出的数组在一定程度上是排序的，可以试着二分查找的思路来寻找最小元素
     */
    public  int minNumberInRotateArray(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int l = 0, h = nums.length-1;
        while(l<h) {
            int m = l+(h-l)/2;
            if(nums[m]<=nums[h])
                h=m;
            else
                l=m+1;
        }
        return nums[l];
    }
}
