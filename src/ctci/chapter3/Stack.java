package ctci.chapter3;

import ctci.chapter2.Node;
import javafx.beans.binding.BooleanExpression;
import org.junit.Test;

/**
 * 实现一个栈
 */
public class Stack {
    private Node top;

    public int pop() {
        Node ret = top;
        if(ret==null) return -1;
        top = top.next;
        return ret.data;
    }

    public void push(int data) {
        Node node = new Node(data);
        node.next = top;
        top = node;
    }

    public Node peek(){
        return top;
    }

    public boolean isEmpty() {
        return top==null;
    }

    @Test
    public void test(){
        Stack mystack = new Stack();
        mystack.push(1);
        mystack.push(2);
        mystack.push(3);
        mystack.push(4);
        while(!mystack.isEmpty())
            System.out.println(mystack.pop());
    }
}
