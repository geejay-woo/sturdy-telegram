package jzoffer;

import org.junit.Test;

public class do64 {
    public int Sum_Solution(int n) {
        /**
         * 条件与 && 具有短路原则，即在第一个条件语句为 false 的情况下不会去执行第二个条件语句。利用这一特性，将递
         * 归的返回条件取非然后作为 && 的第一个条件语句，递归的主体转换为第二个条件语句，那么当递归的返回条件为
         * true 的情况下就不会执行递归的主体部分，递归返回。
         */
        int sum = n;
        boolean b = (n > 0) && ((sum += Sum_Solution(n - 1)) > 0);
        return sum;
    }
}
