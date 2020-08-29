package leetcode.sort;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_451 {
    public String frequencySort(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0; i<s.length(); i++) map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        List<Character>[] buckets = new ArrayList[s.length()+1];
        for(Character ch:map.keySet()) {
            int frequent = map.get(ch);
            if(buckets[frequent]==null) buckets[frequent] = new ArrayList<>();
            buckets[frequent].add(ch);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = buckets.length-1; i>0; i--) {
            if(buckets[i]==null) continue;
            for(Character ch:buckets[i]) {
                for(int j=0; j<i; j++) {
                    sb.append(ch);
                }
            }
        }
        return sb.toString();
    }
    @Test
    public void test(){
        System.out.println(frequencySort("tree"));
    }
}
