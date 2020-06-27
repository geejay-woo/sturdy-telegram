package sorts;

/**
 * 用数组存储堆，从index=1开始存储元素
 */
public class Heap <T extends Comparable<T>> {
    private T[] heap; 
    private int N = 0;

    public Heap(int maxN){
        this.heap = (T[]) new Comparable[maxN+1];
    }

    public boolean isEmpty(){
        return N==0;
    }

    public int size() {
        return N;
    }

    private boolean less(int i, int j){
        return heap[i].compareTo(heap[j])<0;
    }

    private void swap (int i, int j) {
        T t = heap[i];
        heap[i] = heap[j];
        heap[j] = t;
    }

    //key opration
    private void swim(int k ) {
        while(k>1 && less(k/2, k)) {
            swap(k/2,k);
            k = k/2;
        }
    }

    private void sink(int k ) {
        while(2*k <= N) {
            int j = 2*k;
            //j<N保证了2*k+1<=N，也就是有右子节点
            if(j<N && less(j,j+1))
                j++;
            if(!less(k,j))
                break;
            swap(k, j);
            k = j;
        }
    }

    public void insert(T v){
        //将新元素放到数组末尾，然后上浮到合适的位置。
        heap[++N] = v;
        swim(N);
    }

    public T delMax() {
        //从数组顶端删除最大的元素，并将数组的最后一个元素放到顶端，并让这个元素下沉到合适的位置。
        T max = heap[1];
        swap(1,N--);
        heap[N+1] = null;
        sink(1);
        return max;
    }

}