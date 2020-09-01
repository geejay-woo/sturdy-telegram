package leetcode.greedy;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class Solution_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        if(intervals==null || intervals.length==0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(a->a[1]));
        int cnt = 1;
        int end = intervals[0][1];
        for(int i = 1; i<intervals.length; i++) {
            if(intervals[i][0]<end) continue;
            end = intervals[i][1];
            cnt++;
        }
        return intervals.length-cnt;
    }


    @Test
    public void test(){
        int i = eraseOverlapIntervals(new int[][]{new int[]{1, 2}, new int[]{1, 2}, new int[]{1, 2}});

        System.out.println(i);
    }
}
