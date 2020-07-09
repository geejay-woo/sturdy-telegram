package jzoffer;

import entity.TreeNode;

public class do27 {
    public void Mirror(TreeNode root) {
        if(root==null)
            return ;
        swapLeftAndRight(root);
        Mirror(root.left);
        Mirror(root.right);
    }

    private void swapLeftAndRight(TreeNode root) {
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
