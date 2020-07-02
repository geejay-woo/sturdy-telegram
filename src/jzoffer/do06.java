package jzoffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

import org.w3c.dom.NodeList;

import entity.ListNode;

public class do06 {
    //递归实现逆序打印
    public ArrayList<Integer> recursivePrintListFromTailToHead(ListNode<Integer> listNode) {
        ArrayList<Integer> ret = new ArrayList<>();
        if(listNode != null) {
            ret.addAll(recursivePrintListFromTailToHead(listNode.next));
            ret.add(listNode.val);
        }
        return ret;
    }

    //头插法
    public ArrayList<Integer> headInsertPrintListFromTailToHead(ListNode<Integer> listNode) {
        //-1表示这个是个头节点
        ListNode<Integer> pHead = new ListNode(-1);
        while(listNode != null) {
            //需要临时记录下当前节点的下一节点，不然节点会丢失
            ListNode memo = listNode.next;
            listNode.next = pHead.next;
            pHead.next = listNode;
            listNode = memo;
        }
        
        //构件ArrayList
        ArrayList<Integer> ret = new ArrayList<>();
        pHead = pHead.next;
        while(pHead != null) {
            ret.add(pHead.val);
            pHead = pHead.next;
        }
        return ret;
    }

    //使用栈
    public ArrayList<Integer> stackPrintListFromTailToHead(ListNode<Integer> listNode) {
        Stack<Integer> stack = new Stack<>();
        while(listNode!=null) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }

        ArrayList<Integer> ret = new ArrayList<>();
        while(!stack.isEmpty())
            ret.add(stack.pop());
        return ret;        
    }

}