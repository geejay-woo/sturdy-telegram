package jzoffer;

import java.util.LinkedList;
import java.util.Stack;

public class do30Stack {
    LinkedList<Integer> stack1 = new LinkedList<>();
    LinkedList<Integer> stack2 = new LinkedList<>();

    public void push(int val){
        stack1.push(val);
        stack2.push(stack2.isEmpty()?val:Math.min(stack2.peek(),val));
    }
    public int pop(){
        stack2.pop();
        return stack1.pop();
    }
    public int min(){
        return stack2.peek();
    }

    public static void main(String[] args) {
        do30Stack do30Stack = new do30Stack();
        do30Stack.push(3);
        do30Stack.push(4);
        do30Stack.push(1);
        System.out.println(do30Stack.min());
        System.out.println(do30Stack.pop());
        System.out.println(do30Stack.min());
        System.out.println(do30Stack.pop());
        System.out.println(do30Stack.min());
        System.out.println(do30Stack.pop());
    }
}
