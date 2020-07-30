package ctci.chapter2;

import org.junit.Test;
import util.LinkedListUtils;

import javax.xml.crypto.Data;

public class Solution2_5 {
    /**
     * 递归实现
     * @param list1
     * @param list2
     * @param carry 进位
     * @return
     */
    public Node addLists(Node list1, Node list2, int carry){
        //这里是将进位通过参数往前传
        if(list1==null && list2==null && carry==0)
            return null;
        int value = carry;
        if(list1!=null) value+=list1.data;
        if(list2!=null) value+=list2.data;
        Node result = new Node(value%10);
        Node node = addLists(list1 == null ? null : list1.next,
                list2 == null ? null : list2.next,
                value >= 10 ? 1 : 0);
        result.next = node;
        return result;
    }


    /*
    进阶题：需要将进位往后传，不能通过方法参数了，只能通过返回值，但还需返回结果
     */
    public class PartialSum {
        public Node sum = null;
        public int carry = 0;
    }
    //可以使用一个包装类来解决返回多个值的情况
    public Node reverseAddLists(Node list1, Node list2){
        int len1 = length(list1);
        int len2 = length(list2);

        if(len1<len2) {
            list1 = padList(list1,len2-len1);
        } else {
            list2 = padList(list2,len1-len2);
        }

        //对两个链表求和
        PartialSum sum = addListHelper(list1,list2);

        if(sum.carry==0)
            return sum.sum;
        else {
            Node result = insertBefore(sum.sum,sum.carry);
            return result;
        }

    }

    private int length(Node list) {
        int cnt = 0;
        while(list!=null) {
            cnt++;
            list = list.next;
        }
        return cnt;
    }

    private Node padList(Node l, int padding) {
        Node head = l;
        for(int i = 0; i<padding; i++) {
            Node node = new Node(0);
            node.next = head;
            head = node;
        }
        return head;
    }

    private Node insertBefore(Node list, int num) {
        Node node = new Node(num);
        node.next = list;
        return node;
    }

    private PartialSum addListHelper(Node list1, Node list2) {
        if(list1==null && list2 ==null)
            return new PartialSum();
        //对较小数字递归求和
        PartialSum sum = addListHelper(list1.next, list2.next);
        //将进位和当前数据相加
        int val = sum.carry+list1.data+list2.data;
        //插入结果到当前数字的求和结果
        Node full_result = insertBefore(sum.sum,val%10);
        //返回求和结果和进位值
        sum.sum = full_result;
        sum.carry = val/10;
        return sum;
    }


    @Test
    public void test(){
        Node list1 = LinkedListUtils.buildLinkedList(new int[]{7, 1, 6});
        Node list2 = LinkedListUtils.buildLinkedList(new int[]{5,9,2});
        Node node = addLists(list1, list2, 0);
        LinkedListUtils.showLinkedList(node);
    }

    @Test
    public void test2(){
        Node list1 = LinkedListUtils.buildLinkedList(new int[]{6,1,7});
        Node list2 = LinkedListUtils.buildLinkedList(new int[]{2,9,5});
        Node node = reverseAddLists(list1, list2);
        LinkedListUtils.showLinkedList(node);

    }
}
