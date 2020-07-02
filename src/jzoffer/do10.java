package jzoffer;

import java.sql.ResultSet;
import java.util.Arrays;

public class do10 {

    //将子问题缓存起来
//    public int Fibonacci(int n ) {
//        if(n<=1)
//            return n;
//        int[] fib = new int[n+1];
//        fib[1] = 1;
//        for(int i = 2; i<=n; i++)
//            fib[i] = fib[i-1]+fib[i-2];
//        return fib[n];
//        //这里的空间复杂度是O(n)
//    }


    public int Fibonacci(int n ) {
        if(n<=1)
            return n;
        int pre2 = 0, pre1 = 1;
        int fib = 0;
        for(int i = 2; i<=n; i++) {
            fib = pre1+pre2;
            pre2 = pre1;
            pre1 = fib;
        }
        return fib;
        //这里的空间复杂度是O(1)
    }

    public int JumpFloor(int n) {
        if(n<=2)
            return n;
        int pre2 = 1, pre1 = 2;
        int result = 1;
        for(int i = 3; i<=n; i++){
            result = pre2+pre1;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }

    public int JumpFloorII(int target) {
        int[] dp = new int[target];
        Arrays.fill(dp,1);
        for(int i = 1; i<target; i++)
            for(int j = 0; j<i; j++)
                dp[i]+=dp[j];
        return dp[target-1];

    }

    public int RectCover(int n) {
        if (n<=2)
            return n;
        int pre2 = 1, pre1 = 2;
        int result = 0;
        for(int i = 3; i<=n; i++) {
            result = pre2+pre1;
            pre2 = pre1;
            pre1 = result;
        }
        return result;
    }

}
