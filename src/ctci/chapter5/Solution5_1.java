package ctci.chapter5;

import org.junit.Test;

public class Solution5_1 {
    public int insertBits(int N, int M, int i, int j) {
        /**
         * 注意j==31的情况，如果左移j+1，即左移32结果会是循环左移，所以用~0<<j<<1
         */
        int mask = get0MaskbetweenIJ(i, j);
        return mask&N|(M<<i);
    }

    public int get0MaskbetweenIJ(int i, int j) {
        int mask = (~0<<j<<1);
        return mask|((1<<i)-1);
    }

    @Test
    public void test(){
        int num = insertBits(1024,19,2, 6);
//        System.out.println(Integer.toBinaryString(num));

        System.out.println(Integer.toBinaryString(1<<31<<1));
    }
}
