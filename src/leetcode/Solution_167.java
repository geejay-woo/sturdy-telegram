package leetcode;

import org.junit.Test;

import java.util.Arrays;

public class Solution_167 {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0, j = numbers.length-1;
        int sum = numbers[i] + numbers[j];
        while(i<j) {
            if(sum == target) return new int[]{i+1,j+1};
            else if(sum < target) i++;
            else j--;
            sum = numbers[i] + numbers[j];
        }
        return null;
    }

    @Test
    public void test(){
        System.out.println(Arrays.toString(twoSum(new int[]{2,7,11,15},9)));
    }
}
