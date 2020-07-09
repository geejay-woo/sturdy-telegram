package jzoffer;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class do32 {
    /**
     * 如果需要每层都分隔出来，那么每次遍历时候取一次cnt = size遍历cnt个即可
     * @param root
     * @return
     */
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        if(root==null)
            return res;
        queue.push(root);
        while(!queue.isEmpty()) {
            TreeNode<Integer> node = queue.remove();
            res.add(node.val);
            if(node.left!=null)
                queue.add(node.left);
            if(node.right!=null)
                queue.add(node.right);
        }

        return res;
    }

    /**
     * 之字形打印树
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode<Integer> pRoot) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(pRoot);
        boolean reverse = false;
        while (!queue.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int cnt = queue.size();
            while (cnt-- > 0) {
                TreeNode<Integer> node = queue.poll();
                if (node == null)
                    continue;
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
            if (reverse)
                Collections.reverse(list);
            reverse = !reverse;
            if (list.size() != 0)
                ret.add(list);
        }
        return ret;
    }

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
//        TreeNode n1 = new TreeNode<>(2);
//        root.left = n1;
//        n1.left = new TreeNode(5);
//        root.right = new TreeNode<>(3);
//        ArrayList<Integer> integers = PrintFromTopToBottom(root);
//        System.out.println(integers);
//        TreeNode<Integer> n1 = new TreeNode<>(2);
//        n1.left = new TreeNode<>(3);
//        root.left = n1;
        ArrayList<Integer> integers = PrintFromTopToBottom(root);
        System.out.println(integers);
    }
}
