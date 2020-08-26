package ctci.chapter4;

import entity.TreeNode;

public class Solution4_7 {
    public TreeNode lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> q, TreeNode<Integer> p) {
        if(root==null) return null;
        if(!covers(root,p)||!covers(root,q)) return null;
        return lowestCommonAncestorHelper(root,q,p);
    }

    private TreeNode lowestCommonAncestorHelper(TreeNode<Integer> root, TreeNode<Integer> q, TreeNode<Integer> p) {

        if(root==null) return null;
        if(root==q||root==p) return root;

        boolean pInLeft = covers(root.left,p);
        boolean qInLeft = covers(root.left,q);

        if(pInLeft!=qInLeft) return root;
        TreeNode<Integer> node = qInLeft==true?root.left:root.right;

        return lowestCommonAncestorHelper(node,p,q);
    }

    public boolean covers(TreeNode<Integer> root, TreeNode<Integer> p) {
        if(root == null) return false;
        if(root.val == p.val) return true;
        return covers(root.left,p) || covers(root.right,p);
    }

}
