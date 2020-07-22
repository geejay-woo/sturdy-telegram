package jzoffer;

public class do53 {
    /**
     * 用二分查找的思想，但是找到k后不能线性地去找前后的k，而是继续用二分查找的思想
     * 寻找第一个k和第二个k，然后他们的距离就是这个数字在数组中出现的次数
     */

    public int GetNumberOfK(int[] nums, int K) {
        int first = binarySearch(nums, K);
        //K+1的位置即最后一个K的后一个位置，不管该数组存不存在K+1
        int last = binarySearch(nums, K + 1);
        //如果数组中没有K（分两种情况：K比所有值都大；K在数组范围内，但不存在K）返回0，否则返回长度
        return (first == nums.length || nums[first] != K) ? 0 : last - first;
    }


    /**
     * 注意：二分查找如果当前数组没有这个K，则返回的数字是有序插入的位置
     * @param nums
     * @param K
     * @return
     */
    private int binarySearch(int[] nums, int K) {
        int l = 0, h = nums.length;
        while(l<h) {
            int m = l+(h-l)/2;
            if(nums[m]>=K)
                h = m;
            else
                l = m+1;
        }
        return l;
    }
}
