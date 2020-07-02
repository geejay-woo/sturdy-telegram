package jzoffer;

public class do03 {
    public boolean duplicate(int[] nums, int length, int[] duplication) {
        if( nums == null || length <= 0)
            return false;
        
        for(int i = 0; i<length; i++) {
            //注意这里为什么是while而不是if
            //每个数字最多只要交换两次就能找到属于它的位置
            while(nums[i] != i) {
                if(nums[i] == nums[nums[i]]) {
                    duplication[0] = nums[i];
                    return true;
                }
                swap(nums,i,nums[i]);
            }
        }
        return false;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}