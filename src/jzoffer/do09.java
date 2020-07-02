package jzoffer;

import java.util.Stack;

public class do09 {
    Stack<Integer> in = new Stack<>();
    Stack<Integer> out = new Stack<>();

    public void push(int node) {
        in.push(node);
    }

    public int pop() throws Exception {
        if(out.isEmpty())
            while(!in.isEmpty())
                out.push(in.pop());
        if(out.isEmpty())
            throw new Exception("queue is empty");
        return out.pop();
    }
}
