package ctci.chapter2;

public class Solution2_3 {
    public boolean deleteNode(Node n ) {
        //因为找不到前一个节点，无解
        if(n==null || n.next==null) return false;
        n.data = n.next.data;
        n.next = n.next.next;
        return true;
    }
}
