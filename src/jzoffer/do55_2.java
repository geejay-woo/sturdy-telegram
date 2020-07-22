package jzoffer;

import entity.TreeNode;

public class do55_2 {
    //用55_1的方式会重复遍历多次
    //这里考虑用后序遍历，每次记录深度即可
    private  boolean isBalanced = true;
    public boolean IsBalanced_Solution(TreeNode root) {
        height(root);
        return isBalanced;
    }

    private int height(TreeNode root) {
        if(root==null || !isBalanced)
            return 0;
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left-right)>1)
            isBalanced = false;
        return 1+Math.max(left,right);
    }

}
