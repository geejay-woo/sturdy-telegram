package jzoffer;

public class do51 {

    private long cnt = 0;
    private int[] tmp; //辅助数组

    /**
     * 用归并排序的思想
     * 就是归并排序+merge时计算逆序数
     * @param nums
     * @return
     */
    public int InversePairs(int[] nums) {
        tmp = new int[nums.length];
        mergeSort(nums,0,nums.length-1);
        return (int) (cnt % 1000000007);
    }

    private void mergeSort(int[] nums, int l, int h) {
        if(h<=l)
            return;
        int m = l+(h-l)/2;
        mergeSort(nums,1,m);
        mergeSort(nums,m+1,h);
        merge(nums,1,m,h);
    }

    private void merge(int[] nums, int l, int m, int h) {
        //i,j分别指向两个数组的第一个
        int i = l, j = m+1, k = l;
        while(i<=m || j<=h) {
            if(i>m)
                tmp[k] = nums[j++];
            else if(j>h)
                tmp[k] = nums[i++];
            else if(nums[i]<=nums[j])
                tmp[k] = nums[i++];
            else {
                tmp[k] = nums[j++];
                //存在逆序
                //nums[i] > nums[j]，说明 nums[i...mid] 都大于 nums[j]
                this.cnt+=m-i+1;
            }
            k++;
        }
        for (k = l; k <= h; k++)
            nums[k] = tmp[k];
    }

}
