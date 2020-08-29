package leetcode.sort;

import org.junit.Test;

import java.util.Arrays;

public class Solution_75 {
    public void sortColors(int[] arr) {
        int lt = 0, i = 0, gt = arr.length-1;
        while(i<=gt) {
            if(arr[i]==0) {
                swap(arr,lt++,i++);
            } else if(arr[i]==1) {
                i++;
            } else {
                swap(arr,i,gt--);
            }
        }
    }
    private void swap(int[] arr, int i, int j ) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    @Test
    public void test(){
        int[] input = new int[]{2,0,2,1,1,0};
        sortColors(input);
        System.out.println(Arrays.toString(input));
    }
}
