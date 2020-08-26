package leetcode.doublepointer;

import org.junit.Test;

public class Solution_633 {
    /**
     * 双指针一定要找到一个上限值和下限值，不要轻易尝试两个上限和两个下限
     * @param c
     * @return
     */
    public boolean judgeSquareSum(int c) {
        int i = 0, j = (int) Math.sqrt(c);
        while(i<=j) {
            int sum = i*i+j*j;
            if(sum==c) return true;
            else if(sum<c) i++;
            else j--;
        }
        return false;
    }

    @Test
    public void test(){
        System.out.println(judgeSquareSum(5));
    }
}
