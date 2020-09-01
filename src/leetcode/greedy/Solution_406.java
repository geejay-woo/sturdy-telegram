package leetcode.greedy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Solution_406 {
    /**
     * 1，按k降序排，先排高的人
     * 2，高的人对低的人不可见，所以低的人插入到之前高的人排序完后的队列中即可
     * @param people
     * @return
     */
    public int[][] reconstructQueue(int[][] people) {
        if(people==null||people.length==0||people[0].length==0) return new int[0][0];
        //注意这个排序，相同身高必须将k升序排，不然正确插入到队列中的会被挤到错误的位置
        Arrays.sort(people,(a,b)-> a[0]==b[0]?a[1]-b[1]:b[0]-a[0]);
        ArrayList<int[]> res = new ArrayList<>();
        for(int[] one:people) {
            res.add(one[1],one);
        }
        return res.toArray(new int[res.size()][]);
    }

    @Test
    public void test(){
        int[][] ints = {new int[]{1, 2}, new int[]{2, 1}};
        reconstructQueue(ints);
        for(int[] one:ints) {

            System.out.println(Arrays.toString(one));
        }
    }
    @Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<5; i++) {
            list.add(i);
        }
        list.add(10,5);
        System.out.println(list);
    }
}
