package leetcode.search.DFS;

import java.util.ArrayList;
import java.util.List;

/**
 * 能到达的太平洋和大西洋的区域
 */
public class Solution_417 {
    int n,m;
    int[][] matrix;
    int[][] direction = {{-1,0},{1,0},{0,-1},{0,1}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return res;
        n = matrix.length;
        m = matrix[0].length;
        this.matrix = matrix;
        boolean[][] canReachP = new boolean[n][m];
        boolean[][] canReachA = new boolean[n][m];
        //左边和上面是pacific太平洋，右边和下边是大西洋
        for(int i = 0; i<m; i++) {
            dfs(0,i,canReachP);
            dfs(n-1,i,canReachA);
        }
        for(int i = 0; i<n; i++) {
            dfs(i,0,canReachP);
            dfs(i,m-1,canReachA);
        }
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(canReachA[i][j]&&canReachP[i][j]) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    res.add(temp);
                }
            }
        }
        return res;
    }

    private void dfs(int r, int c, boolean[][] canReach) {
        if(canReach[r][c]==true) return;
        canReach[r][c] = true;
        for(int[] d:direction) {
            int nr = r+d[0];
            int nc = c+d[1];
            if(nr<0||nr>=n||nc<0||nc>=m||matrix[nr][nc]<matrix[r][c])
                continue;
            dfs(nr,nc,canReach);
        }
    }
}
