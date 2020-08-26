package ctci.chapter4;

import entity.TreeNode;


public class Solution4_8 {
    //ctci4.8
    boolean containsTree(TreeNode<Integer> t1, TreeNode<Integer> t2) {
        if(t2==null) return true;
        return subTree(t1,t2);
    }

    private boolean subTree(TreeNode<Integer> t1, TreeNode<Integer> t2) {
        if(t1 == null) return false;
        if(t1.val == t2.val) {
            if(matchTree(t1,t2)) return true;
        }
        return (subTree(t1.left,t2)||subTree(t1.right,t2));
    }

    private boolean matchTree(TreeNode<Integer> t1, TreeNode<Integer> t2) {
        if(t1==null && t2==null) return true;
        if(t1==null || t2==null) return false;
        if(t1.val==t2.val) return matchTree(t1.left,t2.left) && matchTree(t1.right,t2.right);
        return false;
    }
}
