package util;

import entity.TreeNode;

import java.util.*;

public class TreeUtils {

    public static void main(String[] args) {
        TreeNode<Integer> integerTreeNode = buildTree(new Integer[]{10,6,14,4,8,12,16});
        test(integerTreeNode);
    }

    public static String str = null;
    public static void test(TreeNode node) {
        if (node == null)
            return;
//        str = "0";
//        System.out.println(str+":"+node.val);
        test(node.left);
        str = "1";
        System.out.println(str+":"+node.val);
        test(node.right);
//        str = "2";
//        System.out.println(str+":"+node.val);
    }


    /**
     * 树的层次遍历
     * @param root
     */
    public static void bfs(TreeNode<Integer> root) {
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur = root;
        while(cur!=null || !queue.isEmpty()) {
            if(cur!=null) {
                System.out.print(cur.val);
                queue.add(cur.left);
                queue.add(cur.right);
            }
            cur = queue.poll();
        }
    }

    /**
     * 非递归实现后序遍历
     * 两个栈，先序+中->右->左，再倒序即可
     * @param root
     */
    public static void postOrderTraverseNonRecursive(TreeNode<Integer> root) {
        Stack<TreeNode> src = new Stack<>();
        Stack<TreeNode> res = new Stack<>();
        src.push(root);
        while(!src.isEmpty()) {
            TreeNode<Integer> p = src.pop();
            res.push(p);
            if(p.left!=null)
                src.push(p.left);
            if(p.right!=null)
                src.push(p.right);
        }
        while(!res.isEmpty()) {
            System.out.print(res.pop().val+" ");
        }
    }

    /**
     * 递归实现后序遍历
     */
    public static void postOrderTraverse(TreeNode root) {
        if(root==null) return;
        postOrderTraverse(root.left);
        postOrderTraverse(root.right);
        System.out.print(root.val+" ");
    }

    /**
     * 非递归实现中序遍历
     * @param node
     */
    public static void inOrderTraverseNonRecursive(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(current!=null || !stack.isEmpty()) {
            if(current!=null) {
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                System.out.print(current.val+" ");
                current = current.right;
            }
        }
    }

    /**
     * 递归实现中序遍历
     * @param node
     */
    public static void inOrderTraverse(TreeNode node) {
        if(node==null)
            return;
        inOrderTraverse(node.left);
        System.out.print(node.val+" ");
        inOrderTraverse(node.right);
    }

    /**
     * 非递归实现前序遍历
     * @param node
     */
    public static void preOrderTraverseNonRecursive(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while(current!=null || !stack.isEmpty()) {
            if(current!=null) {
                System.out.print(current.val+" ");
                stack.push(current);
                current = current.left;
            } else {
                current = stack.pop();
                current = current.right;
            }
        }
    }

    /**
     * 递归实现前序遍历
     * @param node
     */
    public static void preOrderTraverse(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.val + " ");
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    /**
     * 二叉树的构建；二叉查找树的构建见ctci.chapter4.Solution4_3
     * @param arr
     * @return
     */
    public static TreeNode<Integer> buildTree(Integer[] arr) {
        if(arr==null || arr.length==0)
            return null;
        List<TreeNode> nodes = new ArrayList<>(arr.length);
        for(int i = 0; i<arr.length; i++) {
            TreeNode treeNode = new TreeNode(arr[i]);
            nodes.add(treeNode);
        }

        for(int i = 0; i<arr.length/2-1; i++) {
            TreeNode node = nodes.get(i);
            node.left = nodes.get(i*2 + 1).val==null?null:nodes.get(i*2 + 1);
            node.right = nodes.get(i*2 + 2).val==null?null:nodes.get(i*2 + 2);
        }

        // 只有当总节点数是奇数时，最后一个父节点才有右子节点
        int lastPNodeIndex = arr.length/2 - 1;
        TreeNode lastPNode = nodes.get(lastPNodeIndex);
        lastPNode.left = nodes.get(lastPNodeIndex*2 + 1);
        if (arr.length%2 != 0) {
            lastPNode.right = nodes.get(lastPNodeIndex*2 + 2);
        }

        return nodes.get(0);
    }


}
