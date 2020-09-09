package leetcode.search.DFS;

import org.junit.Test;

import java.util.Arrays;

/**
 * 被围绕的区域
 */
public class Solution_130 {
    int n,m;
    int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    public void solve(char[][] board) {
        if(board==null||board.length==0||board[0].length==0) return;
        //与边界'O'相连通的区域设为'T‘,再遍历一次，'O'->'X','T'->'O'
        n = board.length; m = board[0].length;
        for(int i = 0; i<n; i++) {
            dfs(board,i,0);
            dfs(board,i,m-1);
        }
        for(int i = 0; i<m; i++) {
            dfs(board,0,i);
            dfs(board,n-1,i);
        }
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(board[i][j]=='X') continue;
                if(board[i][j]=='O') board[i][j] = 'X';
                else if(board[i][j]=='T') board[i][j] = 'O';
            }
        }
    }
    
    private void dfs(char[][] board, int r, int c) {
        if(r<0||r>=n||c<0||c>=m||board[r][c]!='O') return;
        board[r][c] = 'T';
        for(int[] d:directions) {
            dfs(board,r+d[0],c+d[1]);
        }
    }
    
    @Test
    public void test(){
        char[][] input = {
                {'X','O','X','X'},
                {'O','X','O','X'},
                {'X','O','X','O'},
                {'O','X','O','X'},
                {'X','O','X','O'},
                {'O','X','O','X'},
        };
        solve(input);
        for(char[] i:input) {
            System.out.println(Arrays.toString(i));
        }
    }
}
