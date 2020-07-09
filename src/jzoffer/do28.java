package jzoffer;

import entity.TreeNode;

public class do28 {
    boolean isSymmetrical(TreeNode<Integer> pRoot) {
        if(pRoot == null)
            return true;
        return isSymmetrical(pRoot.left,pRoot.right);
    }

    private boolean isSymmetrical(TreeNode<Integer> left, TreeNode<Integer> right) {
        if(left==null && right==null)
            return true;
        if(left==null || right==null)
            return false;
        if(right.val!=left.val)
            return false;
        return isSymmetrical(left.left,right.right) &&
                isSymmetrical(left.right,right.left);
    }
}
