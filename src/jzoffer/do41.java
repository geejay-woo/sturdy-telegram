package jzoffer;

import java.util.*;

public class do41 {
    //最大堆，用于存储左边的数
    private PriorityQueue<Integer> left = new PriorityQueue<>((o1, o2) -> o2 - o1);
    //最小堆，用于存储右边的值
    private PriorityQueue<Integer> right = new PriorityQueue<>();
    //存储总数量
    private int N;

    //插入要保证平衡状态
    public void Insert(Integer val) {
        if(N%2==0) {
            left.add(val);
            right.add(left.poll());
        }else {
            right.add(val);
            left.add(right.poll());
        }
        N++;
    }

    public Double GetMedian(){
        if(N%2==0)
            return (left.peek()+right.peek())/2.0;
        else
            return (double)right.peek();
    }


    /**
     * 字符流中第一个不重复的字符
     * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符 "go" 时，第一
     * 个只出现一次的字符是 "g"。当从该字符流中读出前六个字符“google" 时，第一个只出现一次的字符是 "l"
     */
    private int[] cnts = new int[256];
    private Queue<Character> queue = new LinkedList<>();

    public void insert(Character c) {
        cnts[c]++;
        queue.add(c);
        while(!queue.isEmpty()&&cnts[queue.peek()]>1)
            queue.poll();
    }

    public char FirstAppearingOnce() {
        return queue.isEmpty() ? '#' : queue.peek();
    }











    public static void main(String[] args) {
        /**
         * LinkedList
         * 头操作：push poll remove pop peek
         * 尾操作：add removeLast
         *
         * ArrayList
         * 尾操作：add remove
         */
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list);
        System.out.println(list.pop());
        System.out.println(list.poll());
//        System.out.println(list.remove());
//        System.out.println(list.remove());
    }
}
