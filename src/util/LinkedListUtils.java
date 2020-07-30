package util;

import ctci.chapter2.Node;
import org.junit.Test;

public class LinkedListUtils {

    public static Node buildLinkedList(int[] nums) {
        Node head = new Node(nums[0]);
        Node cur = head;
        for(int i = 1; i<nums.length; i++) {
            Node node = new Node(nums[i]);
            cur.next = node;
            cur = cur.next;
        }
        return head;
    }

    public static void showLinkedList(Node head) {
        Node cur = head;
        while(cur!=null ) {
            System.out.print(cur.data+" ");
            cur = cur.next;
        }
    }
    @Test
    public void test(){
        Node node = buildLinkedList(new int[]{1, 2, 3, 4, 5});
        showLinkedList(node);
    }
}
