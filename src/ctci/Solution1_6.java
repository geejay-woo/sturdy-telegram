package ctci;

import org.junit.Test;

public class Solution1_6 {
    /**
     * 本题为leetcode1.5
     * @param first
     * @param second
     * @return
     */
    public boolean oneEditAway(String first, String second) {
        if(first==null || second==null)
            return false;
        int firstLen = first.length();
        int secondLen = second.length();
        int i = 0;
        while(i<firstLen && i<secondLen) {
            if(first.charAt(i)!=second.charAt(i)) break;
            i++;
        }
        boolean ret = false;
        //这里情况应该有点多
        if(i==firstLen || i==secondLen)
            return Math.abs(firstLen-secondLen)<=1;
        //这里要考虑i为最后一个字符，用substring会有问题
        String sub1 = i==firstLen-1?"":first.substring(i+1,firstLen);
        String sub2 = first.substring(i,firstLen);
        String sub3 = i==secondLen-1?"":second.substring(i+1,secondLen);
        String sub4 = second.substring(i,secondLen);
        ret|=sub1.equals(sub3)|sub1.equals(sub4)|sub2.equals(sub3);
        return ret;
    }

    @Test
    public void test() {
        System.out.println(oneEditAway("mart","karma"));
    }
}
