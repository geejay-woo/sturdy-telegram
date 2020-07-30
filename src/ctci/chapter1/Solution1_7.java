package ctci.chapter1;

import org.junit.Test;

import java.util.Arrays;

public class Solution1_7 {
    //ctci1.6
    public void rotate(int[][] matrix, int n) {
        for(int i = 0; i<n/2; i++) {
            int first = i;
            int last = n-1-i;
            for(int j = first; j<last; j++) {
                int offset = j-first;
                int top = matrix[first][j];
                matrix[first][j] = matrix[last-offset][first];
                matrix[last-offset][first] = matrix[last][last-offset];
                matrix[last][last-offset] = matrix[j][last];
                matrix[j][last] = top;
            }
        }
    }

    @Test
    public void test() {
        int[][] input = new int[][]{
                new int[]{1,2,3,4},
                new int[]{12,13,14,5},
                new int[]{11,16,15,6},
                new int[]{10,9,8,7}
        };
        rotate(input,4);
        for(int[] line : input)
            System.out.println(Arrays.toString(line));
    }
}
