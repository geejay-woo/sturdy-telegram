package ctci.chapter3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Solution3_2 {
    private class MinStack {

        //单个栈也能做：将push是将value和最小值同时push进去，pop时pop两次
        Stack<Integer> origin = new Stack<>();
        Stack<Integer> min = new Stack<>();


        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int x) {
            origin.push(x);
            int curMin = getMin();
            if(x<=curMin) min.push(x);
        }

        public void pop() {
            int value = origin.peek();
            origin.pop();
            if(value==getMin())
                min.pop();
        }

        public int top() {
            return origin.peek();
        }

        public int getMin() {
            return min.isEmpty()?Integer.MAX_VALUE:min.peek();
        }
    }

    @Test
    public void test(){
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(0,1,0));
        MinStack minStack = new MinStack();
        input.stream().forEach(num->minStack.push(num));
        for(int i = 0; i<input.size(); i++) {
            System.out.println();
            System.out.println("top:"+minStack.top());
            System.out.println("min:"+minStack.getMin());
            minStack.pop();
        }
    }
}
