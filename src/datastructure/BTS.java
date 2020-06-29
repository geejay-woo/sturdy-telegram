package datastructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BTS<Key extends Comparable<Key>, Value> implements OrderedST<Key, Value> {

    protected Node root;
    
    protected class Node {
        Key key;
        Value val;
        Node left;
        Node right;
        //子树节点总数
        int N;
        //红黑树中使用
        boolean color;

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            N = n;
        }
        
    }

    @Override
    public Value get(Key key) {
        return get(root,key);
    }
    
    private Value get(Node x, Key key) {
        if(x==null)
            return null;
        int cmp = key.compareTo(x.key);
        if(cmp==0)
            return x.val;
        else if(cmp<0)
            return get(x.left,key);
        else
            return get(x.right, key);
    }

    @Override
    public List<Key> keys(Key l, Key h) {
        //中序遍历
        return keys(root, l, h);
    }

    private List<Key> keys(Node x, Key l, Key h) {
        List<Key> list = new ArrayList<>();
        if(x==null)
            return list;
        int cmpL = l.compareTo(x.key);
        int cmpH = h.compareTo(x.key);
        if(cmpL<0)
            list.addAll(keys(x.left,l,h));
        if(cmpL<=0 && cmpH>=0)
            list.add(x.key);
        if(cmpH>0)
            list.addAll(keys(x.right,l,h));
        return list;
    }

    @Override
    public Key max() {
        if(root == null)
            return null;
        Node x = root;
        while(x.left!=null)
            x = x.left;
        return x.key;
    }

    /**
     * 令指向最小节点的链接指向最小节点的右子树。
     */
    @Override
    public Key min() {
        return min(root).key;
    }

    public void deleteMin() {
        root = deleteMin(root);
    }
    

    private Node deleteMin(Node x) {
        if(x.left == null)
            return x.right;
        x.left = deleteMin(x.left);
        recalculatesSize(x);
        return x;
    }

    public void delete(Key key) {
        root = delete(root,key);
    }

    private Node delete(Node x, Key key) {
        if(x==null) 
            return null;
        int cmp = key.compareTo(x.key);
        if(cmp<0) 
            x.left = delete(x.left,key);
        else if(cmp>0)
            x.right = delete(x.right,key);
        else {
            if(x.right == null)
                return x.left;
            if(x.left == null)
                return x.right;
            Node t = x;
            x = min(t.right);
            x.right = delete(x, key);
        }
        recalculatesSize(x);
        return x;
    }

    private Node min(Node x) {
        if(x==null)
            return null;
        if(x.left==null)
            return x;
        return min(x.left);
    }

    @Override
    public void put(Key key, Value value) {
        root = put(root,key,value);
    }

    private Node put(Node x, Key key, Value value) {
        if(x == null)
            return new Node(key,value,1);
        int cmp = key.compareTo(x.key);
        if(cmp==0)
            x.val = value;
        else if (cmp<0)
            x.left = put(x.left,key,value);
        else
            x.right = put(x.right,key,value);
        recalculatesSize(x);
        return x;
    }

    @Override
    public int rank(Key key) {
        return rank(key,root);
    }

    private int rank(Key key, Node x) {
        if(x == null)
            return 0;
        int cmp = key.compareTo(x.key);
        if(cmp == 0)
            return size(x.left);
        else if(cmp<0)
            return rank(key,x.left);
        else 
            return 1 + size(x.left) + rank(key,x.right);
    }

    @Override
    public int size() {
        return size(root);
    }

    public int size(Node node) {
        if(node == null) 
            return 0;
        return node.N;
    }

    protected void recalculatesSize(Node x) {
        x.N = size(x.left) + size(x.right) + 1;
    }

    public Key floor(Key key) {
        Node x = floor(root,key);
        if(x == null)
            return null;
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if(x == null )
            return null;
        int cmp = key.compareTo(x.key);
        if(cmp == 0)
            return x;
        if(cmp < 0)
            return floor(x.left,key);
        Node t = floor(x.right,key);
        return t!=null?t:x;
    }
    
    
}