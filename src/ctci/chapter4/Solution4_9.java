package ctci.chapter4;

import entity.TreeNode;
import org.junit.Test;
import util.TreeUtils;

import java.util.ArrayList;

public class Solution4_9 {

    int res = 0;

    public int pathSum(TreeNode<Integer> root, int sum) {
        int depth = depth(root);
        int[] paths = new int[depth];
        pathSum(root,sum,0,paths);
        return res;
    }

    private void pathSum(TreeNode<Integer> node, int sum, int layer, int[] paths) {
        if(node==null) return;
        paths[layer] = node.val;
        int cur = 0;
        for(int i=layer; i>=0; i--) {
            cur+=paths[i];
            if(cur==sum) res++;
        }
        pathSum(node.left,sum,layer+1,paths);
        pathSum(node.right,sum,layer+1,paths);
    }

    private int depth(TreeNode<Integer> node) {
        if(node==null) return 0;
        return Math.max(depth(node.left),depth(node.right))+1;
    }


//    不一定到叶子节点结束，注释解法是：不一定从根开始，但到叶子节点结束
//    int res = 0;
//
//    public int pathSum(TreeNode<Integer> root, int sum) {
//        if(root == null) return 0;
//        pathSumHelper(root, sum);
//        return res;
//    }
//
//    private ArrayList<Integer> pathSumHelper(TreeNode<Integer> node, int sum) {
//        if(node==null) return null;
//
//        ArrayList<Integer> ints = new ArrayList<>();
//        if(node.left==null || node.right==null){
//            ints.add(node.val);
//            if(node.val==sum) res++;
//        }
//        if(node.left!=null){
//            ArrayList<Integer> leftInts = pathSumHelper(node.left, sum);
//            leftInts.forEach(num->{
//                int cur = num+node.val;
//                if(cur==sum) res++;
//                else ints.add(cur);
//            });
//        }
//        if(node.right!=null) {
//            ArrayList<Integer> rightInts = pathSumHelper(node.right, sum);
//            rightInts.forEach(num->{
//                int cur = num+node.val;
//                if(cur==sum) res++;
//                else ints.add(cur);
//            });
//        }
//
//
//        return ints;
//
//    }

    @Test
    public void test(){
        TreeNode<Integer> root = TreeUtils.buildTree(new Integer[]{1,-2,3});
        int i = pathSum(root, 1);
        System.out.println(i);
    }
}
