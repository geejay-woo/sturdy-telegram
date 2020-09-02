package leetcode.greedy;

import org.junit.Test;

public class Solution_605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int N = flowerbed.length;
        for(int i = 0; i<N; i++) {
            if(flowerbed[i]==1) continue;
            if((i-1)>=0&&flowerbed[i-1]==1 || (i+1)<N&&flowerbed[i+1]==1) continue;
            flowerbed[i ] = 1;
            n--;
        }
        return n<=0?true:false;
    }

    @Test
    public void test(){
        System.out.println(canPlaceFlowers(new int[]{0,0,1,0,0},1));
    }
}
