package ctci.chapter1;

import org.junit.Test;

import java.util.Arrays;

public class Solution1_8 {
    public void setZeros(int[][] matrix) {
        boolean[] rows = new boolean[matrix.length];
        boolean[] cols = new boolean[matrix[0].length];
        for(int i = 0; i<matrix.length; i++)
            for(int j = 0; j<matrix[0].length; j++)
                if(matrix[i][j]==0) {
                    rows[i] = true;
                    cols[j] = true;
                }
        for(int i = 0; i<matrix.length; i++)
            for(int j = 0; j<matrix[0].length; j++)
                if(rows[i]||cols[j])
                    matrix[i][j] = 0;
    }

    @Test
    public void test() {
        int[][] input = new int[][]{
                new int[]{1,2,3,4},
                new int[]{12,13,14,5},
                new int[]{11,16,0,6},
                new int[]{10,9,8,7}
        };
        setZeros(input);
        for(int[] line : input)
            System.out.println(Arrays.toString(line));
    }
}
