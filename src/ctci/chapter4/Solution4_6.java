package ctci.chapter4;

import entity.TreeNode;
import org.junit.Test;

import java.util.LinkedList;

/**
 * 后继者，指定节点中序遍历后一个，这里每个节点没有指向父节点的指针
 */
public class Solution4_6 {
    public TreeNode inorderSuccessor(TreeNode<Integer> root, TreeNode p) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode<Integer> node = root;
        while(node!=null||!stack.isEmpty()) {
            if(node!=null) {
                if(node==p) {
                    if(stack.isEmpty()) return null;
                    if(node.val>=root.val) return getMin(node.right);
                    return stack.pop();
                } else {
                    stack.push(node);
                    node = node.left;
                }
            } else {
                node = stack.pop();
                node = node.right;
            }
        }
        return null;
    }

    private TreeNode<Integer> getMin(TreeNode<Integer> node) {
        if(node==null) return null;
        while (node.left!=null) node = node.left;
        return node;
    }

    /**
     * leetcode上双百的题解
     * @param root
     * @param p
     * @return
     */
    public TreeNode inorderSuccessor2(TreeNode<Integer> root, TreeNode<Integer> p) {
       TreeNode<Integer> res = root;
       TreeNode<Integer> temp = root;
       while(temp!=null) {
           if(temp.val<=p.val) {
               temp = temp.right;
           } else {
               res = temp;
               temp = temp.left;
           }
       }
       return res;
    }
}
