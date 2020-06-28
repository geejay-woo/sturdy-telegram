package datastructure;

import java.util.Iterator;

public class ListQueue<Item> implements MyQueue<Item> {

    private Node first;
    private Node last;
    int N = 0;

    private class Node {
        Item item;
        Node next;
    }

    @Override
    public MyQueue<Item> add(Item item) {
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = null;

        if (isEmpty()) {
            last = newNode;
            first = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }

        N++;

        return this;
    }

    @Override
    public boolean isEmpty() {
        return N == 0;
    }

    @Override
    public Item remove() throws Exception {
        if (isEmpty()) {
            throw new Exception("queue is empty");
        }

        Node node = first;
        first = first.next;
        N--;

        // 如果只有一个元素时，first 和 last都是指向一个元素，需要处理一下
        if (isEmpty()) {
            last = null;
        }

        return node.item;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<Item>() {

            Node cur = first;

            @Override
            public boolean hasNext() {
                return cur != null;
            }

            @Override
            public Item next() {
                Item item = cur.item;
                cur = cur.next;
                return item;
            }
            
        };
    }
    

    
}