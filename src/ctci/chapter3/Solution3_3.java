package ctci.chapter3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 这里假定不一定前面的盘子都是满的，也就是popAt执行后不进行处理。
 * 如果进行处理则需要对popAt进行修改
 */
public class Solution3_3 {
    @Test
    public void test(){
        StackOfPlates sop = new StackOfPlates(3);
        for(int i = 0; i<5; i++)
            sop.push(i);
        sop.popAt(0);
        sop.push(10);
    }

    class StackOfPlates {

        private ArrayList<Stack<Integer>> list;
        private int cap;

        public StackOfPlates(int cap) {
            this.cap = cap;
            this.list = new ArrayList<Stack<Integer>>();
        }

        public void push(int val) {
            if(cap==0) return ;
            if(list.size()==0) {
                Stack<Integer> stack = new Stack<>();
                stack.push(val);
                list.add(stack);
            } else {
                int size = list.size();
                Stack<Integer> oldStack = list.get(size-1);
                if(oldStack.size()==cap) {
                    Stack<Integer> stack = new Stack<>();
                    stack.push(val);
                    list.add(stack);
                } else {
                    oldStack.push(val);
                }
            }
        }

        public int pop() {
            int size = list.size();
            if(size==0) return -1;
            Stack<Integer> oldStack = list.get(size-1);
            int res = oldStack.pop();
            if(oldStack.isEmpty())
                list.remove(size-1);
            return res;
        }

        public int popAt(int index) {
            int size = list.size();
            if(index>=size) return -1;
            Stack<Integer> indexStack = list.get(index);
            Integer res = indexStack.pop();
            if(indexStack.isEmpty()) list.remove(index);
            return res;
        }
    }

}
