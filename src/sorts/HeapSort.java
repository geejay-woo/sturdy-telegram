package sorts;

public class HeapSort<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        //index=0不存元素
        int N = nums.length-1;
        //从非叶子节点开始
        for(int k =N/2; k>=1; k--)
            sink(nums,k,N);

        while(N>1) {
            swap(nums, 1, N--);
            sink(nums,1,N);
        }
    }

    private void sink(T[] nums, int k, int N) {
        //有左子节点
        while(2*k<=N) {
            int j = k*2;
            //有右节点且比左节点大
            if(j<N && less(nums,j,j+1))
                j++;
            if(!less(nums,k,j))
                break;
            swap(nums,k,j);
            k = j;
        }
    }

    private boolean less(T[] nums, int i, int j ) {
        return nums[i].compareTo(nums[j])<0;
    }

    
    
}