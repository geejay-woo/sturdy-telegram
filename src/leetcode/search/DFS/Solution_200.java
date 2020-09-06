package leetcode.search.DFS;

import jdk.nashorn.internal.ir.ContinueNode;
import org.junit.Test;

/**
 * 矩阵中的连通分量数目
 */
public class Solution_200 {
    int n,m;
    int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
    public int numIslands(char[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0) return 0;
        n = grid.length; m = grid[0].length;
        int count = 0;
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(grid[i][j]=='1') count++;
                dfs(grid,i,j);
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int r, int c) {
        if(r<0||r>=n||c<0||c>=m||grid[r][c]=='0') return;
        grid[r][c] = '0';
        for(int[] d:direction) {
            dfs(grid,r+d[0],c+d[1]);
        }
    }

    @Test
    public void test(){
        char[][] input = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'},
        };
        System.out.println(numIslands(input));
    }
}
