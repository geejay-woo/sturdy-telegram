package leetcode.sort;

import org.junit.Test;

import java.util.PriorityQueue;

public class Solution_215 {
    /**
     * 用partition函数来解决
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest2(int[] nums, int k) {
        int N = nums.length;
        int target = N-k;
        int i = 0, j = N-1;
        while(i<j) {
            int p = partition(nums, i,j);
            if(p==target) return nums[p];
            else if(p<target) {
                i=p+1;
            } else {
                j=p-1;
            }
        }
        return nums[target];

    }

    private int partition(int[] arr, int f, int l) {
        int i = f, j = l+1;
        int val = arr[f];
        while(true) {
            while(arr[++i]<val && i!=l);
            while(arr[--j]>val && j!=f);
            if(i>=j) break;
            swap(arr,i,j);
        }
        swap(arr,j,f);
        return j;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    /**
     * 用大顶堆来做
     * @param nums
     * @param k
     * @return
     */
    public int findKthLargest(int[] nums, int k) {
        int N = nums.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->Integer.compare(b,a));
        for(int i = 0; i<N; i++) {
            queue.add(nums[i]);
        }
        int res = 0;
        for(int i = 0; i<k; i++) res = queue.poll();
        return res;
    }

    @Test
    public void test(){
        System.out.println(findKthLargest2(new int[]{3,2,1,5,6,4},2));
    }
}
