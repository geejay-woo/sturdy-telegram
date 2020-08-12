package ctci.chapter4;


import entity.ListNode;
import entity.TreeNode;
import org.junit.Test;
import util.TreeUtils;

import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution4_4 {

    @Test
    public void test(){
        TreeNode<Integer> node = TreeUtils.buildTree(new Integer[]{1, 2, 3, 4, 5, null, 7});
        ListNode<Integer>[] listNodes = new Solution().listOfDepth(node);
    }


    class Solution {
        public ListNode<Integer>[] listOfDepth(TreeNode<Integer> tree) {
            ArrayList<ListNode<Integer>> res = new ArrayList<>();
            LinkedList<TreeNode<Integer>> queue = new LinkedList<>();
            queue.offer(tree);
            TreeNode<Integer> cur = null;

            while(!queue.isEmpty()) {
                int cnt = queue.size();
                ListNode<Integer> head = null;
                ListNode<Integer> tail = null;
                for(int i = 0; i<cnt; i++) {
                    cur = queue.poll();
                    if(i==0) {
                        head = tail = new ListNode<Integer>(cur.val);
                    } else {
                        ListNode<Integer> temp = new ListNode<>(cur.val);
                        tail = tail.next = temp;
                    }

                    if(cur.left!=null) queue.offer(cur.left);
                    if(cur.right!=null) queue.offer(cur.right);
                }
                res.add(head);
            }
            return res.toArray(new ListNode[0]);
        }
    }
}
