package leetcode.greedy;

import org.junit.Test;

import java.util.*;

/**
 * 划分字母区间
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，
 * 同一个字母只会出现在其中的一个片段。返回一个表示每个字符串片段的长度的列表。
 */
public class Solution_763 {
    /**
     * 官解：贪婪
     * @param S
     * @return
     */
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for(int i = 0; i< S.length(); i++) {
            last[S.charAt(i)-'a'] = i;
        }
        int start = 0, end = 0;
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i< S.length(); i++) {
            end = Math.max(end,last[S.charAt(i)-'a']);
            if(i==end) {
                res.add(end-start+1);
                start = i+1;
            }
        }
        return res;
    }

    /**
     * 合并区间
     * @param S
     * @return
     */
    public List<Integer> partitionLabels2(String S) {
        HashMap<Character, int[]> map = new HashMap<>();
        for(int i = 0; i< S.length(); i++) {
            Character ch = S.charAt(i);
            if(!map.containsKey(ch)) {
                map.put(ch,new int[]{i,i});
            } else {
                int[] ints = map.get(ch);
                ints[1] = i;
                map.put(ch,ints);
            }
        }
        ArrayList<int[]> list = new ArrayList<>();
        for(Map.Entry<Character, int[]> entry:map.entrySet() ) {
            list.add(entry.getValue());
        }
        Collections.sort(list, Comparator.comparingInt(o -> o[0]));
        ArrayList<Integer> res = new ArrayList<>();
        int begin = 0;
        int end = list.get(0)[1];
        for(int i = 1; i<list.size(); i++) {
            int[] arr = list.get(i);
            if(arr[0]<end && arr[1]>end) {
                //合并区间
                end = arr[1];
            } else if(arr[0]>end) {
                res.add(end-begin+1);
                begin = arr[0];
                end = arr[1];
            }
        }
        res.add(end-begin+1);
        return res;
    }

    @Test
    public void test(){
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }
}
