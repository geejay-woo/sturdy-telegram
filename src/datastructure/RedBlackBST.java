package datastructure;

public class RedBlackBST<Key extends Comparable<Key>,Value> extends BTS<Key,Value> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private boolean isRed(Node x) {
        if(x==null)
            return false;
        return x.color==RED;
    }

    //左旋操作
    public Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        recalculatesSize(h);
        return x;
    }

    //右旋操作
    public Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        recalculatesSize(h);
        return x;
    }

    //颜色转换
    void flipColors(Node h) {
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) {
        Node node = new Node(key, value, 1);
        node.color = RED;
        return node;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0)
        x.val = value;
        else if (cmp < 0)
        x.left = put(x.left, key, value);
        else
        x.right = put(x.right, key, value);
        if (isRed(x.right) && !isRed(x.left))
        x = rotateLeft(x);
        if (isRed(x.left) && isRed(x.left.left))
        x = rotateRight(x);
        if (isRed(x.left) && isRed(x.right))
        flipColors(x);
        recalculatesSize(x);
        return x;
    }
    
}