package sorts;

public class Insertion<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        for(int i = 1; i<N; i++){
            for(int j = i; j>0; j--){
                if(less(nums[j], nums[j-1]))
                    swap(nums, j, j-1);
            }
        }
    }
}