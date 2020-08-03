package ctci.chapter3;

import org.junit.Test;

import java.util.LinkedList;

public class Solution3_4 {
    //回顾Hanoi问题
    public static void move(int n, String from, String buffer, String to) {
        //第一步：递归结束的条件
        if(n==1) {
            System.out.println("from "+from+ " to "+to);
            return ;
        }
        //将n-1个圆盘从from->buffer
        move(n-1, from, to, buffer);
        //将1个圆盘从from->to
        move(1,from,buffer,to);
        //将n-1个圆盘从buffer->to
        move(n-1,buffer,from,to);
    }
    @Test
    public void test(){
        Solution3_4.move(3,"石柱1","石柱2","石柱3");
    }
}
