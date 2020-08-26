package ctci.chapter5;

import org.junit.Test;

public class Solution5_3 {

    public int[] findClosedNumbers(int num) {
        return null;
    }

    @Test
    public void test(){
        System.out.println(Integer.toBinaryString(6));
        System.out.println(getBinaryString(6));
    }

    public String getBinaryString(int num) {
        StringBuffer sb = new StringBuffer();
        while(num!=0) {
            sb.append(num%2);
            num/=2;
        }
        return sb.reverse().toString();
    }
}
