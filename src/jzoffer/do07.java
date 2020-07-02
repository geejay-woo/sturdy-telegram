package jzoffer;

import java.util.HashMap;
import java.util.Map;

import entity.TreeNode;

public class do07 {
    //缓存中序遍历数组每个值对应的索引
    private Map<Integer,Integer> indexFOrInOrders = new HashMap<>();

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        for ( int i = 0; i<in.length; i++){
            indexFOrInOrders.put(in[i], i);
        }

        return reConstructBinaryTree(pre, 0, pre.length-1, 0);
    }

    public TreeNode reConstructBinaryTree(int[] pre, int preL, int preR, int inL) {
        if(preL>preR)
            return null;
        TreeNode<Integer> root = new TreeNode<Integer>(pre[preL]);
        int inIndex = indexFOrInOrders.get(root.val);
        int leftTreeSize = inIndex-inL;

        root.left = reConstructBinaryTree(pre, preL+1, preL+leftTreeSize, inL);
        root.right = reConstructBinaryTree(pre, preL+leftTreeSize+1, preR, inL+leftTreeSize+1);

        return root;
    }
}