package leetcode.binarysearch;

public class Solution_540 {
    public int singleNonDuplicate(int[] nums) {
        int N = nums.length;
        int f = 0, l = N-1;
        while(f<l) {
            int m = f+(l-f)/2;
            if(m%2==1)
                m--;
            if(m<N-1&&nums[m]==nums[m+1]) {
                f = m+2;
            } else {
                l = m;
            }
        }
        return nums[f];
    }
}
