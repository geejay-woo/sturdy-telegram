package leetcode.search;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 单词接龙
 * 给定两个单词（beginWord 和 endWord）和一个字典，
 * 找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 */
public class Solution_127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        wordList.add(beginWord);
        if(!wordList.contains(endWord)) return 0;
        int end = 0;
        for(int i = 0; i<wordList.size(); i++)
            if(wordList.get(i).equals(endWord)){
                end = i;
                break;
            }

        List<Integer>[] graphic = buildGraphic(wordList);
        return getShortestPath(graphic,wordList.size()-1,end);
    }

    private int getShortestPath(List<Integer>[] graphic, int start, int end) {
        int N = graphic.length;
        LinkedList<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[N];
        queue.offer(start);
        marked[start] = true;
        int path = 1;
        while(!queue.isEmpty()) {
            int size = queue.size();
            path++;
            while(size-->0) {
                Integer cur = queue.poll();
                for(int next:graphic[cur]) {
                    if(next==end) return path;
                    if(marked[next]) continue;
                    marked[next] = true;
                    queue.add(next);
                }
            }
        }
        return 0;
    }

    private List<Integer>[] buildGraphic(List<String> wordList) {
        int N = wordList.size();
        List<Integer>[] graphic = new List[N];
        for(int i = 0; i<N; i++) {
            graphic[i] = new ArrayList<>();
            for(int j = 0; j<N; j++)
                if(isConnect(wordList.get(i),wordList.get(j))) graphic[i].add(j);
        }
        return graphic;
    }

    private boolean isConnect(String s1, String s2) {
        int diffCount = 0;
        for(int i = 0; i<s1.length() && diffCount<=1; i++) {
            if(s1.charAt(i)!=s2.charAt(i)) diffCount++;
        }
        return diffCount==1;
    }

    @Test
    public void test(){
        ArrayList<String> strs = new ArrayList<>();
        strs.add("hig");
        System.out.println(ladderLength("hit","hig",strs));
    }
}
