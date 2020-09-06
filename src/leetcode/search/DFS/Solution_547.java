package leetcode.search.DFS;

import org.junit.Test;

/**
 * 朋友圈
 */
public class Solution_547 {

    boolean[] hasVisited = null;
    int N = 0;
    public int findCircleNum(int[][] M) {
        N = M.length;
        hasVisited = new boolean[N];
        int count = 0;
        for(int i = 0; i<hasVisited.length; i++) {
            if(hasVisited[i]==false){
                dfs(M,i);
                count++;
            }
        }
        return count;
    }

    private void dfs(int[][] grid, int m) {
        for(int i = 0; i<N; i++) {
            if(i==m) continue;
            if(hasVisited[i]==true) continue;
            if(grid[m][i]==1) {
                hasVisited[i] = true;
                dfs(grid,i);
            }
        }
    }

    @Test
    public void test(){
        int[][] input = {
                {1,1,0},
                {1,1,1},
                {0,1,1}
        };
        System.out.println(findCircleNum(input));
    }
}
