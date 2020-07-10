package jzoffer;

import entity.TreeNode;

import java.util.ArrayList;

public class do34 {

    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();

    private ArrayList<ArrayList<Integer>> findPath(TreeNode root, int target) {
        backtracking(root,target,new ArrayList<>());
        return ret;
    }

    private void backtracking(TreeNode<Integer> node, int target, ArrayList<Integer> path) {
        if(node==null)
            return ;
        path.add(node.val);
        target -= node.val;
        if(target==0 && node.left==null && node.right==null) {
            ret.add(new ArrayList<Integer>(path));
        } else {
            backtracking(node.left,target,path);
            backtracking(node.right,target,path);
        }
        path.remove(path.size()-1);
    }

}
