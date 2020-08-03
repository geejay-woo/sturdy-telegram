package ctci.chapter3;

import org.junit.Test;

import java.util.Stack;

public class Solution3_5 {

    @Test
    public void test(){
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
        System.out.println(myQueue.pop());
    }

    /**
     * 两个栈实现一个队列
     */
    private class MyQueue {


        private Stack<Integer> input;
        private Stack<Integer> output;

        /** Initialize your data structure here. */
        public MyQueue() {
            this.input = new Stack<>();
            this.output = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            input.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            if(output.isEmpty()) {
                while(!input.isEmpty())
                    output.push(input.pop());
            }
            return output.isEmpty()?-1:output.pop();
        }

        /** Get the front element. */
        public int peek() {
            if(output.isEmpty()) {
                while(!input.isEmpty())
                    output.push(input.pop());
            }
            return output.isEmpty()?-1:output.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return input.isEmpty()&&output.isEmpty();
        }
    }
}
