package leetcode.doublepointer;

import org.junit.Test;

import java.util.Arrays;

public class Solution_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] aux = new int[m];
        for(int i = 0; i<m; i++) {
            aux[i] = nums1[i];
        }
        int k = 0, i = 0, j = 0;
        while(k<m+n) {
            if(i>=m) {
                nums1[k++] = nums2[j++];
            } else if(j>=n) {
                nums1[k++] = aux[i++];
            } else if(aux[i]<nums2[j]) {
                nums1[k++] = aux[i++];
            } else {
                nums1[k++] = nums2[j++];
            }
        }
    }
    @Test
    public void test(){
        int[] nums1 = new int[]{4,5,6,0,0,0};
        int[] nums2 = new int[]{1,2,3};
        merge(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }
}
