package ctci.chapter4;

import entity.TreeNode;

public class Solution4_1 {

    public boolean isBalanced(TreeNode<Integer> root) {
        if(root==null) return true;
        int abs = Math.abs(getHeight(root.left) - getHeight(root.right));
        if(abs>1) return false;
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode<Integer> node) {
        if(node==null) return 0;
        return Math.max(getHeight(node.left),getHeight(node.right))+1;
    }



    //下面是算法的改进，上面的解法重复计算了很多节点的高度



    /**
     * 计算高度，但是检查到不平衡时直接返回-1
     * @param root
     * @return
     */
    private int checkHeight(TreeNode<Integer> root) {
        if(root==null) return 0;
        int leftRes = checkHeight(root.left);
        if(leftRes==-1) return -1;
        int rightRes = checkHeight(root.right);
        if(rightRes==-1) return -1;
        int abs = Math.abs(leftRes - rightRes);
        if(abs>1) return -1;
        return Math.max(leftRes,rightRes)+1;
    }

    public boolean isBalanced2(TreeNode<Integer> root) {
        return checkHeight(root)==-1?false:true;

    }
}
