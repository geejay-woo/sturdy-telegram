package leetcode.divide;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

//不同的二叉搜索树 II
//给定一个数字 n，要求生成所有值为 1...n 的二叉搜索树。
public class Solution_95 {
    public List<TreeNode> generateTrees(int n) {
        if(n<1) return new LinkedList<TreeNode>();
        return generateSubtrees(1,n);
    }

    private List<TreeNode> generateSubtrees(int start, int end) {
        LinkedList<TreeNode> res = new LinkedList<>();
        if(start>end) {
            res.add(null);
            return res;
        }
        for(int i = start; i<=end; i++) {
            List<TreeNode> left = generateSubtrees(start, i - 1);
            List<TreeNode> right = generateSubtrees(i+1, end);
            for(TreeNode l:left) {
                for(TreeNode r:right) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;
                    res.add(root);
                }
            }
        }
        return res;
    }

    @Test
    public void test(){
        generateTrees(3);

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}