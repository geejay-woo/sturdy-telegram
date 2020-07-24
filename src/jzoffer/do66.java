package jzoffer;

import org.junit.Test;

import java.util.Arrays;

public class do66 {
    public int[] multiply(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        for (int i = 0, product = 1; i < n; product *= A[i], i++) /* 从左往右累乘 */
            B[i] = product;
        for (int i = n - 1, product = 1; i >= 0; product *= A[i], i--) /* 从右往左累乘 */
            B[i] *= product;
        return B;
    }

    @Test
    public void test(){
        int[] multiply = multiply(new int[]{1, 2, 3});
        System.out.println(Arrays.toString(multiply));
    }
}


