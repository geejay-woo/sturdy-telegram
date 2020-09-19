package leetcode.search.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 二叉树的所有路径
 */
public class Solution_257 {

    @Test
    public void test(){
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        node2.left = node1;
        node2.right = node3;
        List<String> strings = binaryTreePaths(node2);
        System.out.println(strings);
    }
    public List<String> binaryTreePaths2(TreeNode root) {
        ArrayList<String> res = new ArrayList<>();
        if(root==null)
            return res;
        ArrayList<Integer> values = new ArrayList<>();
        backtracking2(root,values,res);
        return res;
    }

    private void backtracking2(TreeNode node, ArrayList<Integer> values, ArrayList<String> res) {
        if(node==null) return;
        values.add(node.val);
        if(node.left==null && node.right==null) {
            res.add(buildPath(values));
        } else {
            backtracking2(node.left,values,res);
            backtracking2(node.right,values,res);
        }
        values.remove(values.size()-1);
    }

    private String buildPath(List<Integer> values) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<values.size(); i++ ) {
            sb.append(values.get(i));
            if(i!=values.size()-1) {
                sb.append("->");
            }
        }
        return sb.toString();
    }


    //============================自己的解法==============================
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root==null)
            return res;
        StringBuilder sb = new StringBuilder();
        backtracking(sb,root,res);
        return res;
    }

    private void backtracking(StringBuilder sb, TreeNode root, List<String> res) {
        if(root==null) return;
        sb.append(root.val);
        sb.append("->");
        if(root.left==null && root.right==null) {
            sb.delete(sb.length()-2,sb.length());
            res.add(sb.toString());
            sb.delete(sb.length()-(root.val+"").length(),sb.length());
            return;
        }
        backtracking(sb,root.left,res);
        backtracking(sb,root.right,res);
        sb.delete(sb.length()-(root.val+"").length()-2,sb.length());
    }
}
