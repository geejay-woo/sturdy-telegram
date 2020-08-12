package ctci.chapter4;

import entity.TreeNode;

public class Solution4_5 {
    class Solution {
        public boolean isValidBST(TreeNode<Integer> root) {
            if(root == null) return true;
            boolean res = isValidBST(root.left)&&isValidBST(root.right);
            if(res == false ) return false;
            if(root.left!=null) {
                int max = getMax(root.left);
                res &= max<root.val;
            }
            if(root.right!=null) {
                int min = getMin(root.right);
                res &= min>root.val;
            }
            return res;
        }

        private int getMin(TreeNode<Integer> root) {
            Integer res = root.val;
            while(root.left!=null) root = root.left;
            res = root.val;
            return res;
        }

        private int getMax(TreeNode<Integer> root ) {
            Integer res = root.val;
            while(root.right!=null) root = root.right;
            res = root.val;
            return res;
        }


    }
}
