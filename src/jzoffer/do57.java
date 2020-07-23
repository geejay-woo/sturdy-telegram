package jzoffer;

import java.util.ArrayList;
import java.util.Arrays;

public class do57 {
    //双指针
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        int i = 0, j = array.length-1;
        while (i<j) {
            int cur = array[i]+array[j];
            if(cur==sum)
                return new ArrayList<>(Arrays.asList(array[i],array[j]));
            if(cur<sum)
                i++;
            else
                j--;
        }
        return new ArrayList<>();
    }

    //本题拓展:和为 S 的连续正数序列
    ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        int start = 1, end = 2;
        int curSum = 3;
        while(end<sum) {
            if(curSum<sum) {
                end++;
                curSum+=end;
            } else if(curSum>sum) {
                curSum-=start;
                start++;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for(int i =start;i<=end;i++)
                    list.add(i);
                ret.add(list);
                curSum-=start;
                start++;
                end++;
                curSum+=end;
            }
        }
        return ret;
    }
}
