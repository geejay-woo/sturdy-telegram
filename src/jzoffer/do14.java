package jzoffer;

public class do14 {
    //贪心解法
    public int integerBreak(int n ) {
        if(n<2)
            return 0;
        if(n==2)
            return 1;
        if(n==3)
            return 2;
        //尽可能地去减去长度为3的绳子段
        int timesof3 = n/3;
        //当绳子最后剩下的长度为4，不能再去剪长度为3的绳子段
        //更好的方法是剪成长度为2的两段
        if(n-timesof3*3==1)
            timesof3--;
        int timesof2 = (n-timesof3)/2;
        return (int )(Math.pow(3,timesof3))*(int )Math.pow(2,timesof2);
    }

    //动态规划解
    public int integerBreak2(int n ) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        for(int i = 2; i<=n; i++)
            for(int j = 1; j<i; j++)
                dp[i] = Math.max(dp[i],Math.max(j*(i-j),dp[j]*(i-j)));
         return dp[n];
    }
}
