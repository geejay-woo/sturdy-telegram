package jzoffer;

public class do39 {
    public int MoreThanHalfNum_Solution(int[] nums) {
        int majority = nums[0];
        for(int i = 1, cnt = 1;i<nums.length; i++) {
            cnt = nums[i]==majority?cnt+1:cnt-1;
            if(cnt==0) {
                majority = nums[i];
                cnt = 1;
            }
        }
        //有可能最多数存在，但是没有超过一半
        int cnt = 0;
        for(int val : nums)
            if(val == majority)
                cnt++;
        return cnt>nums.length/2?majority:0;
    }
}
