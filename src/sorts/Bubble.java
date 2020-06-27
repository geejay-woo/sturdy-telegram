package sorts;

public class Bubble<T extends Comparable<T>> extends Sort<T> {

    @Override
    public void sort(T[] nums) {
        int N = nums.length;
        boolean sorted = false;
        for(int i = N-1; i>0&&!sorted; i--){
            sorted = true;
            for(int j = 0; j<i; j++){
                if(less(nums[j+1], nums[j])){
                    swap(nums, j+1, j);
                    sorted = false;
                }
            }
        }
    }
}