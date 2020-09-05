package leetcode.search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 完全平方数
 * 输入: n = 12
 * 输出: 3
 * 解释: 12 = 4 + 4 + 4.
 */
public class Solution_279 {
    public int numSquares(int n) {
        List<Integer> squares = generateSquares(n);
        HashSet<Integer> queue = new HashSet<>();
        queue.add(n);
        int level = 0;
        while(!queue.isEmpty()) {
            level++;
            HashSet<Integer> next_queue = new HashSet<>();
            for(Integer cur : queue){
                for(Integer square:squares) {
                    if(cur.equals(square)) return level;
                    else if(cur<square) break;
                    else next_queue.add(cur-square);
                }
            }
            queue = next_queue;
        }
        return level;
    }

    private List<Integer> generateSquares(int n ) {
        ArrayList<Integer> squares = new ArrayList<>();
        for(int i = 1; i<=n; i++) {
            squares.add(i*i);
        }
        return squares;
    }
}
