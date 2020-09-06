package leetcode.search.DFS;

import javafx.util.Pair;
import org.junit.Test;

import java.util.LinkedList;

/**
 * 查找最大的连通面积
 */
public class Solution_695 {
    final int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
    int m,n;
    /**
     * 递归
     * @param grid
     * @return
     */
    public int maxAreaOfIsland2(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int res = 0;
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                res = Math.max(res,dfs(grid,i,j));
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int r, int c) {
        if(r<0||r>=n||c<0||c>=m||grid[r][c]==0) return 0;
        grid[r][c] = 0;
        int area = 1;
        for(int[] d:direction) {
            area+=dfs(grid,r+d[0],c+d[1]);
        }
        return area;
    }

    /**
     * 非递归
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] marked = new boolean[n][m];
        int count = 0;
        int max = 0;
        LinkedList<Pair<Integer, Integer>> stack = new LinkedList<>();
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(marked[i][j]==true||grid[i][j]==0) continue;
                stack.push(new Pair<>(i,j));
                marked[i][j] = true;
                count = 0;
                while(!stack.isEmpty()) {
                    Pair<Integer, Integer> pop = stack.pop();
                    count++;
                    int cr = pop.getKey(), cc = pop.getValue();
                    for(int [] d:direction) {
                        int nr = cr+d[0], nc = cc+d[1];
                        if(nr<0||nr>=n||nc<0||nc>=m) continue;
                        if(marked[nr][nc]==true) continue;
                        if(grid[nr][nc]==1){
                            stack.push(new Pair<>(nr,nc));
                            marked[nr][nc] = true;
                        }
                    }
                }
                max = Math.max(count,max);
            }
        }
        return max;
    }

    @Test
    public void test(){
        int[][] input = {
                {0,1}
        };
        System.out.println(maxAreaOfIsland2(input));
    }
}
