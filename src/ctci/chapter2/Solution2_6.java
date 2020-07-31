package ctci.chapter2;

public class Solution2_6 {
    public Node findBegining(Node head) {
        //要先判断有无环
        if(head==null || head.next==null) return null;
        Node fast = head, low = head;
        while(fast!=null && fast.next!=null ) {
            low = low.next;
            fast = fast.next.next;
            if(low==fast) break;
        }
        if(fast==null||fast.next==null) return null;
        low = head;
        while(fast!=low) {
            fast = fast.next;
            low = low.next;
        }
        return low;
    }
}
