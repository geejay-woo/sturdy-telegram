package datastructure;

import java.util.Iterator;

public class ArrayStack<Item> implements MyStack<Item> {

    private Item[] a = (Item[]) new Object[1];

    private int N = 0;

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Item pop() throws Exception {
        if (isEmpty()) {
            throw new Exception("stack is empty");
        }

        Item item = a[--N];

        check();

        a[N] = null;

        return item;
    }

    @Override
    public MyStack<Item> push(Item item) {
        check();
        a[N++] = item;
        return this;
    }

    @Override
    public int size() {
        return N;
    }

    @Override
    public Iterator<Item> iterator() {
        // 返回逆序遍历的迭代器
        return new Iterator<Item>() {

            private int i = N;

            @Override
            public boolean hasNext() {
                return i>0;
            }

            @Override
            public Item next() {
                return a[--i];
            }
                
        };
    }

    private void check(){
        if(N>=a.length) {
            resize(2*a.length);
        } else if(N>0 && N<=a.length/4) {
            resize(a.length/2);
        }
    }

    private void resize(int size) {
        Item[] temp = (Item[]) new Object[size];

        for(int i = 0; i<N; i++) { 
            temp[i] = a[i];
        }

        a=temp;

    }

}