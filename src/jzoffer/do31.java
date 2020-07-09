package jzoffer;

import java.util.LinkedList;

public class do31 {
    public boolean IsPopOrder(int[] pushSequence, int[] popSequence) {
        int n = pushSequence.length;
        LinkedList<Integer> stack = new LinkedList<>();
        for(int pushIndex=0, popIndex=0; pushIndex<n; pushIndex++) {
            stack.push(pushSequence[pushIndex]);
            while(popIndex<n && !stack.isEmpty() && stack.peek()==popSequence[popIndex]) {
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }
}
