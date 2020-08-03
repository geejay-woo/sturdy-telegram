package ctci.chapter3;

import org.junit.Test;

public class Solution3_1 {
    private class TripleInOne {

        //把数组均匀分给三个栈
        int[] arr;
        //三个栈的指针
        int[] p;
        //记录大小
        int stackSize;

        public TripleInOne(int stackSize) {
            arr = new int[stackSize*3];
            this.stackSize = stackSize;
            p = new int[3];
            p[0] = 0;
            p[1] = stackSize;
            p[2] = stackSize*2;
        }

        public void push(int stackNum, int value) {
            //栈满的情况
            if(p[stackNum]>=(stackNum+1)*stackSize) return;

            arr[p[stackNum]] = value;
            p[stackNum]+=1;
        }

        public int pop(int stackNum) {
            if(isEmpty(stackNum)) return -1;

            p[stackNum]-=1;
            return arr[p[stackNum]];
        }

        public int peek(int stackNum) {
            if(isEmpty(stackNum)) return -1;
            return arr[p[stackNum]-1];
        }

        public boolean isEmpty(int stackNum) {
            return p[stackNum]==stackSize*stackNum;
        }
    }

    @Test
    public void test(){
        TripleInOne tripleInOne = new TripleInOne(1);
        tripleInOne.push(0,1);
        tripleInOne.push(0,1);
        tripleInOne.push(0,1);
        while(!tripleInOne.isEmpty(0))
            System.out.println(tripleInOne.pop(0));
    }

}
