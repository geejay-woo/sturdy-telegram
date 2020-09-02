package leetcode.binarysearch;

import org.junit.Test;

public class Solution_744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int f = 0, l = letters.length-1;
        while(f<=l) {
            int m = f+(l-f)/2;
            if(letters[m]==target) {
                return letters[(m+1)%letters.length];
            } else if(letters[m]>target) {
                l = m-1;
            } else {
                f = m+1;
            }
        }
        return letters[f];
    }

    @Test
    public void test(){
        System.out.println(nextGreatestLetter(new char[]{'c','f','j'},'d'));
    }
}
