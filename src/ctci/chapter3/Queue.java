package ctci.chapter3;

import ctci.chapter2.Node;
import org.junit.Test;

public class Queue {
    //两个节点
    private Node first,last;

    public void enqueue(int data) {
        Node node = new Node(data);
        if(first==null)
            first = node;
        else
            last.next = node;
        last = node;
    }

    public int dequeue() {
        Node node = first;
        if(node==null) return -1;
        if(node==last) {
            first = null;
            last = null;
        } else {
            first = first.next;
        }
        return node.data;
    }

    public boolean isEmpty() {
        return first==null;
    }


    @Test
    public void test(){
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        while(!queue.isEmpty())
            System.out.println(queue.dequeue());
    }
}
