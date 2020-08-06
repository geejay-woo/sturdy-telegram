package ctci.chapter3;

import org.junit.Test;

import java.util.Stack;

public class Solution3_6 {
    @Test
    public void test(){
        SortedStack sortedStack = new SortedStack();
//        sortedStack.push(3);
//        sortedStack.push(1);
//        sortedStack.push(5);
//        sortedStack.push(0);
//        sortedStack.push(7);
//        System.out.println(sortedStack.peek());
//        sortedStack.pop();
//        System.out.println(sortedStack.peek());
//        sortedStack.pop();
//        System.out.println(sortedStack.peek());
//        sortedStack.pop();
//        System.out.println(sortedStack.peek());
//        sortedStack.pop();
//        System.out.println(sortedStack.peek());
        sortedStack.peek();
        sortedStack.peek();
        sortedStack.pop();
        sortedStack.isEmpty();
        sortedStack.peek();

    }
    /**
     * 对栈进行排序
     */
    private class SortedStack {


        private Stack<Integer> buffer;
        private Stack<Integer> sorted;

        public SortedStack() {
            buffer = new Stack<>();
            sorted = new Stack<>();
        }

        public void push(int val) {
            buffer.push(val);
        }

        public void pop() {
            sort();
            if(sorted.isEmpty()) return;
            sorted.pop();
        }

        public int peek() {
            sort();
            if(sorted.isEmpty()) return -1;
            return sorted.peek();
        }

        public boolean isEmpty() {
            return buffer.isEmpty()&&sorted.isEmpty();
        }

        private void sort(){
            if(buffer.isEmpty()&&sorted.isEmpty()) return;
            while(!buffer.isEmpty()) {
                int cur = buffer.peek();
                if(sorted.isEmpty()) {
                    sorted.push(buffer.pop());
                    continue;
                }
                int temp = sorted.peek();
                while(!sorted.isEmpty()&&temp<cur) {
                    sorted.pop();
                    buffer.push(temp);
                    if(!sorted.isEmpty())
                        temp = sorted.peek();
                }
                sorted.push(cur);
                while(buffer.peek()!=cur) {
                    Integer pop = buffer.pop();
                    sorted.push(pop);
                }
                buffer.pop();
            }
        }
    }
}
