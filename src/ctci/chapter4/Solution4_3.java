package ctci.chapter4;

import entity.TreeNode;

public class Solution4_3 {
    public TreeNode<Integer> sortedArrayToBST(int[] nums) {
        if(nums==null||nums.length==0) return null;
        int i = 0, j = nums.length;
        return generate(nums,i,j);
    }

    private TreeNode<Integer> generate(int[] nums, int left, int right) {
        if(left==right) return null;
        int mid = left+(right-left)/2;
        TreeNode<Integer> node = new TreeNode<>(nums[mid]);
        node.left = generate(nums,left,mid);
        node.right = generate(nums,mid+1,right);
        return node;
    }
}
