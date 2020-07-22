package jzoffer;

import entity.TreeNode;

public class do55_1 {
    //递归
    public int TreeDepth(TreeNode root) {
        return root==null?0:1+Math.max(TreeDepth(root.left),TreeDepth(root.right));
    }
}
