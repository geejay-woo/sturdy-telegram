package leetcode.search;

import javafx.util.Pair;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 *  计算在网格中从原点到特定点的最短路径长度
 *  1 表示可以经过某个位置，求解从 (0, 0) 位置到 (tr, tc) 位置的最短路径长度。
 */
public class BFSImpl {
    public int minPathLength(int[][] grids, int tr, int tc) {
        final int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
        final int n = grids.length, m = grids[0].length;
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0,0));
        int maxLength = 0;
        while(!queue.isEmpty()) {
            maxLength++;
            int size = queue.size();
            while(size-->0){
                Pair<Integer, Integer> poll = queue.poll();
                int cr = poll.getKey(), cc = poll.getValue();
                grids[cr][cc] = 0;
                for(int[] d:direction) {
                    int nr = cr+d[0], nc = cc+d[1];
                    if(nr<0||nr>=n||nc<0||nc>=m||grids[nr][nc]==0) continue;
                    if(nr==tr&&nc==tc) return maxLength;
                    queue.add(new Pair<>(nr,nc));
                }
            }
        }
        return -1;
    }

    @Test
    public void test(){
        int[][] input = {
                {1,1,0,1},
                {1,0,1,0},
                {1,1,1,1},
                {1,0,1,1}
        };
        System.out.println(minPathLength(input,2,2));
    }
}
