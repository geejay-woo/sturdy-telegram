package leetcode.search.backtracking;

import org.junit.Test;

/**
 * 单词搜索：给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 */
public class Solution_79 {
    int n,m;
    int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    boolean[][] marked;
    public boolean exist(char[][] board, String word) {
        if(board==null||board.length==0||board[0].length==0)
            return false;
        if(word==null || word.length()==0)
            return true;
        n = board.length; m = board[0].length;
        this.marked = new boolean[n][m];
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                if(backtracking(board,word,0,i,j)) return true;
            }
        }
        return false;
    }

    private boolean backtracking(char[][] board, String word, int th, int i, int j) {
        if(marked[i][j]) return false;
        if(word.charAt(th)!=board[i][j]) return false;
        marked[i][j] = true;
        if(th==word.length()-1) return true;
        for(int[] d:directions ) {
            int nr = i+d[0];
            int nc = j+d[1];
            if(nr<0||nr>=n||nc<0||nc>=m) continue;
            if(backtracking(board,word,th+1,nr,nc)) return true;
        }
        marked[i][j] = false;
        return false;
    }

    @Test
    public void test(){
        char[][] input = {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(exist(input,"ABCCED"));
    }
}
