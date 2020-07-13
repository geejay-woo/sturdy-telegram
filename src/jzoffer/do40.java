package jzoffer;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class do40 {
    /**
     * 时间复杂度为On，但是会改变原数组
     * @param nums
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] nums, int k) {
        ArrayList<Integer> ret = new ArrayList<>(k);
        if(k>=nums.length || k<=0)
            return ret;
        findKthSmallest(nums,k-1);
        for(int i = 0; i<k; i++)
            ret.add(nums[i]);
        return ret;
    }

    private void findKthSmallest(int[] nums, int k) {
        int i = 0, j=nums.length-1;
        while(i<j) {
            int m = partition(nums,i,j);
            if(m<k)
                i=m+1;
            else
                j=m-1;
        }

    }

    private int partition(int[] nums, int l, int h) {
        //切分元素
        int p = nums[l];
        int i = l, j = h+1;
        while(true) {
            while(i!=h && nums[++i]<p);
            while(j!=l && nums[--j]>p);
            if(i>=j)
                break;
            swap(nums,i,j);
        }
        swap(nums,l,j);
        return j;
    }

    private void swap(int[] nums,int i,int j ) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] nums, int k){
        if(k>nums.length || k<=0)
            return new ArrayList<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for(int num:nums) {
            maxHeap.add(num);
            if(maxHeap.size()>k)
                maxHeap.poll();
        }
        return new ArrayList<>(maxHeap);
    }
}
