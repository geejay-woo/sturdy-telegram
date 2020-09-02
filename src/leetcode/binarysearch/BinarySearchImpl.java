package leetcode.binarysearch;

import org.junit.Test;

public class BinarySearchImpl {
    /**
     * 最常规实现
     * @param arr
     * @param key
     * @returneqqex
     * tsdafsdfafsda
     */
    public int binarySearch(int[] arr, int key) {
        int f = 0, l = arr.length-1;
        while(f<=l) {
            int m = f+(l-f)/2;
            if(arr[m]==key) {
                return m;
            } else if(arr[m]>key) {
                l = m-1;
            } else {
                f = m+1;
            }
        }
        return f;
    }

    /**
     * 注意边界值的判断，可以衍生出各种不同的写法
     * @param arr
     * @param key
     * @return
     */
    public int binarySearch2(int[] arr, int key) {
        int f = 0, l = arr.length-1;
        while(f<l) {
            int m = f+(l-f)/2;
            if(arr[m]>=key) {
                l = m;
            } else {
                f = m+1;
            }
        }
        return f;
    }

    @Test
    public void test(){
        System.out.println(binarySearch2(new int[]{1,3,5,7,9},4));
    }
}
