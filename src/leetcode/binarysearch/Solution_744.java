package leetcode.binarysearch;

import org.junit.Test;

/**
 * 寻找比目标字母大的最小字母
 */
public class Solution_744 {
    public char nextGreatestLetter(char[] arr, char key) {
        int f = 0, l = arr.length-1;
        while(f<=l) {
            int m = f+(l-f)/2;
            if(arr[m]<=key) {
                f = m+1;
            } else {
                l = m-1;
            }
        }
        return f < arr.length ? arr[f] : arr[0];
    }

    @Test
    public void test(){
        System.out.println(nextGreatestLetter(new char[]{'c','f','j'},'d'));
    }
}
