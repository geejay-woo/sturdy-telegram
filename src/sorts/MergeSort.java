package sorts;

public abstract class MergeSort<T extends Comparable<T>> extends Sort<T> {

    protected T[] aux;

    protected void merge(T[] nums, int l, int m, int h){
        //i和j 分别表示两个数组的第一个下标
        int i = l;  int j = m+1;

        //复制数据到辅助数组
        for(int k = l; k<=h; k++){
            aux[k] = nums[k];
        }

        for(int k = l; k<=h; k++){
            if(i>m){
                nums[k] = aux[j++];
            }else if(j>h){
                nums[k] = aux[i++];
            }else if(aux[i].compareTo(aux[j])<=0){
                nums[k] = aux[i++];
            }else {
                nums[k] = aux[j++];
            }
        }
    }
    
}