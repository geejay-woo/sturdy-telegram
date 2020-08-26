package leetcode.doublepointer;

import org.junit.Test;

public class Solution_680 {

    public boolean validPalindrome2(String s) {
        int i = 0, j = s.length()-1;
        while(i<j) {
            if(s.charAt(i)!=s.charAt(j)) {
                return isHuiWen(s,i,j-1)||isHuiWen(s,i+1,j);
            }
            i++; j--;
        }
        return true;
    }

    private boolean isHuiWen(String s, int i, int j) {

        while(i<j) {
            if(s.charAt(i++)!=s.charAt(j--)) return false;
        }
        return true;

    }

    //错解
    public boolean validPalindrome(String s) {
        int i = 0, j = s.length()-1;
        boolean canDel = true;
        while(i<j) {
            if(s.charAt(i)!=s.charAt(j)) {
                if(s.charAt(i)==s.charAt(j-1) && canDel) {
                    j-=2; i+=1;
                    canDel = false;
                    //这里选择了一种情况，如果被选择的这种情况不满足，而下一种情况满足呢？
                    continue;
                }
                if(s.charAt(i+1)==s.charAt(j) && canDel) {
                    j-=1; i+=2;
                    canDel = false;
                    continue;
                }
                return false;
            }
            i++; j--;
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(validPalindrome2("ebcbbececabbacecbbcbe"));
    }

}
