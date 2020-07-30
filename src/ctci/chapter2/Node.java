package ctci.chapter2;

public class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }

    public void appendToTail(int d) {
        Node node = new Node(d);
        Node n = this;
        while(n.next!=null) {
            n = n.next;
        }
        n.next = node;
    }

    /**
     * 删除指定节点，并返回新的头节点
     * @param head
     * @param d
     * @return
     */
    public Node deleteNode(Node head, int d) {
        if(head.data == d) {
            return head.next;
        }
        Node cur = head;
        while(cur.next!=null) {
            if(cur.next.data==d) {
                cur.next = cur.next.next;
                return head;
            }
            cur = cur.next;
        }
        return head;
    }
}
