package leetcode.sort;

import org.junit.Test;

import java.util.*;

public class Solution_347 {
    /**
     * 桶数组：第i个数组存储出现频率为i的数字
     * @param nums
     * @param k
     * @return
     */
    public int[] topKFrequent2(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num:nums) map.put(num,map.getOrDefault(num,0)+1);
        List<Integer>[] buckets = new ArrayList[nums.length+1];
        for(Integer key:map.keySet()) {
            int frequent = map.get(key);
            if(buckets[frequent]==null) buckets[frequent] = new ArrayList<>();
            buckets[frequent].add(key);
        }
        int[] res = new int[k];
        int cur = 0;
        for(int i = buckets.length-1; cur!=k; i--) {
            if(buckets[i]==null) continue;
            for(Integer num : buckets[i]) {
                if(cur==k) break;
                res[cur++] = num;
            }
        }
        return res;

    }

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num:nums ) {
            int val = 1;
            if(map.containsKey(num)){
                val = map.get(num)+1;
            }
            map.put(num,val);
        }
        Set<Map.Entry<Integer, Integer>> entries = map.entrySet();
        ArrayList<Integer> list = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry:entries) {
            list.add(entry.getKey());
        }
        Collections.sort(list,(a,b)->map.get(b)-map.get(a));
        int[] res = new int[k];
        for(int i = 0; i<k; i++) {
            res[i] = list.get(i);
        }
        return res;
    }


    @Test
    public void test(){
        int[] ints = topKFrequent2(new int[]{1,1,1,2,2,3}, 2);
        System.out.println(Arrays.toString(ints));
    }

}
