package leetcode.binarysearch;

import org.junit.Test;

public class BinarySearchImpl {
    /**
     * 最常规实现
     * @param arr
     * @param key
     * @return
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
     * 注意边界值的判断，可以衍生出各种不同的写法，每种写法有不同的用法
     *
     * 这种写法：一定会找到左边第一个
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

    /**
     * 不能和第二种搞混淆，第二种当arr[m]>=key，l=m，不能就以为第三种arr[m]<=key，f=m，会死循环，因为除法取商的原因
     * @param arr
     * @param key
     * @return
     */
    public int binarySearch3(int[] arr, int key) {
        int f = 0, l = arr.length;
        while(f<l) {
            int m = f+(l-f)/2;
            if(arr[m]<=key) {
                f = m+1;
            } else {
                l = m-1;
            }
        }
        return f;
    }

    /**
     * 常见的错误的写法:死循环，f会一直因为m一直小于l
     * @param arr
     * @param key
     * @return
     */
    public int binarySearchWrong(int[] arr, int key) {
        int f = 0, l = arr.length-1;
        while(f<l) {
            //这里可以int m = f+(l-f+1)/2;但是返回值会有问题，不能返回插入的位置
            int m = f+(l-f)/2;
            if(arr[m]<=key) {
                f = m;
            } else {
                l = m-1;
            }
        }
        return f;
    }



    @Test
    public void test(){
        System.out.println(binarySearch2(new int[]{1,3,5,7,9},10));
    }
}
