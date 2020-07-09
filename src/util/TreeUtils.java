package util;

import entity.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class TreeUtils {

    public static void main(String[] args) {
        TreeNode<Integer> integerTreeNode = buildTree(new Integer[]{10,5,12,4,null,7});
        preOrderTraverse(integerTreeNode);
    }

    public static void preOrderTraverse(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.val + " ");
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

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
