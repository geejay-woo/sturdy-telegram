package leetcode.binarysearch;

import org.junit.Test;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 */
public class Solution_34 {
    public int[] searchRange(int[] arr, int target) {
        //先找到一个
        int N = arr.length;
        int m = binarySearchReturn_1IfNotIn(arr, 0, N - 1, target);
        if(m==-1) return new int[]{-1,-1};
        //找左边
        int left = m, right = m;
        while(binarySearchReturn_1IfNotIn(arr,0,left-1,target)!=-1) {
            left = binarySearch(arr,0,left-1,target);
        }
        //找右边
        while(binarySearchReturn_1IfNotIn(arr,right+1,N-1,target)!=-1) {
            right = binarySearch(arr, right+1, N-1, target);
        }
        return new int[]{left,right};
    }
    
    private int binarySearch(int[] arr, int f, int l, int target) {
        while(f<=l) {
            int m = f+(l-f)/2;
            if(arr[m]==target) return m;
            else if(arr[m]<target) f = m+1;
            else  l = m-1;
        }
        return f;
    }

    private int binarySearchReturn_1IfNotIn(int[] arr, int f, int l, int target) {
        while(f<=l) {
            int m = f+(l-f)/2;
            if(arr[m]==target) return m;
            else if(arr[m]<target) f = m+1;
            else  l = m-1;
        }
        return -1;
    }
    
    @Test
    public void test(){
        int[] ints = searchRange(new int[]{5,7,7,8,8,8,10}, 8);
        System.out.println(ints[0]+" "+ints[1]);
    }
    
    @Test
    public void test1(){
        System.out.println(binarySearch(new int[]{5,7,7,8,8,10},0,3,4));
    }
}
