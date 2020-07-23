package jzoffer;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class do59 {
    //滑动窗口的最大值
    //用大顶堆来做
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> ret = new ArrayList<>();
        if(size>num.length || size<1)
            return ret;
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1,o2)->o2-o1);
        for(int i = 0; i<size; i++)
            heap.add(num[i]);
        ret.add(heap.peek());
        for(int i = 0, j = i+size; j<num.length; i++,j++) {
            //循环中维护这个size=size的大顶堆
            heap.remove(num[i]);
            heap.add(num[j]);
            ret.add(heap.peek());
        }
        return ret;
    }
}
