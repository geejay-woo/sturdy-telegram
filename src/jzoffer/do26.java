package jzoffer;

import entity.TreeNode;

public class do26 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        //多问自己，某个指针有没有可能是null，对应哪种情况，需要怎么处理
        if(root1 == null || root2 == null)
            return false;
        return isSubtreeWithRoot(root1,root2) || HasSubtree(root1.left,root2) ||
                HasSubtree(root1.right,root2);
    }

    private boolean isSubtreeWithRoot(TreeNode root1, TreeNode root2) {
        if(root2 == null)
            return true;
        if(root1 == null)
            return false;
        if(root1.val != root2.val)
            return false;
        return isSubtreeWithRoot(root1.left,root2.left) && isSubtreeWithRoot(root1.right,root2.right);
    }
}
