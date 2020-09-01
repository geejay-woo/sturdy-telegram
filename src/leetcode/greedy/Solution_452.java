package leetcode.greedy;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_452 {
    public int findMinArrowShots(int[][] points) {
        if(points==null || points.length==0) return 0;
        Arrays.sort(points, Comparator.comparingInt(a->a[0]));
        int cnt = 1;
        int end = points[0][1];
        for(int i = 0; i<points.length; i++) {
            if(points[i][0]<=end){
                end = Math.min(end,points[i][1]);
                continue;
            }
            cnt++;
            end = points[i][1];
        }
        return cnt;
    }

    @Test
    public void test(){
        int minArrowShots = findMinArrowShots(new int[][]{
                new int[]{3,9}, new int[]{7, 12}, new int[]{3, 8}, new int[]{6, 8},
                new int[]{9,10}, new int[]{2, 9}, new int[]{0, 9}, new int[]{3, 9},
                new int[]{0,6},new int[]{2,8}
        }
        );
        System.out.println(minArrowShots);

    }
}
