package jzoffer;

import org.junit.Test;

public class do65 {
    public int Add(int a, int b) {
        return b == 0 ? a : Add(a ^ b, (a & b) << 1);
    }

    @Test
    public void test(){
        Add(3,1);
    }
}
