package ctci.chapter4;

import entity.TreeNode;
import org.junit.Test;

public class Solution4_3 {
    /**
     * 这道题的边界条件要注意，虽然没二分查找那么复杂，但也值得探究
     * 下面注释的部分是此题边界条件的另外一种写法
     * @param nums
     * @return
     */
    public TreeNode<Integer> sortedArrayToBST(int[] nums) {
        if(nums==null||nums.length==0) return null;
        int i = 0, j = nums.length;
        // generate(nums,i,j);
        return generate(nums,i,j-1);
    }

    private TreeNode<Integer> generate(int[] nums, int left, int right) {
        //if(left==right) return null;
        if(left>right) return null;
        int mid = left+(right-left)/2;
        TreeNode<Integer> node = new TreeNode<>(nums[mid]);
        //node.left = generate(nums,left,mid);
        node.left = generate(nums,left,mid-1);
        node.right = generate(nums,mid+1,right);
        return node;
    }
    
    @Test
    public void test(){
        TreeNode<Integer> node = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }
}
