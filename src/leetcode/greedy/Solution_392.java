package leetcode.greedy;

import org.junit.Test;

public class Solution_392 {
    /**
     * 双指针常规解法
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence(String s, String t) {
        if(s==null||s.length()==0) return false;
        int k = 0 ;
        for(int i = 0; i<t.length(); i++) {
            if(s.charAt(k)==t.charAt(i)) k++;
            if(k==s.length()) return true;
        }
        return false;
    }

    /**
     * 动态规划做
     * @param s
     * @param t
     * @return
     */
    public boolean isSubsequence2(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] f = new int[m+1][26];
        for(int i = 0; i<26; i++) {
            f[m][i] = m;
        }

        for(int i = m-1; i>=0; i--) {
            for(int j = 0; j<26; j++) {
                if(t.charAt(i)==j+'a')
                    f[i][j] = i;
                else
                    f[i][j] = f[i+1][j];
            }
        }

        int add = 0;

        for(int i = 0; i<n; i++) {
            if(f[add][s.charAt(i)-'a']==m) {
                return false;
            }
            add = f[add][s.charAt(i)-'a']+1;
        }
        return true;
    }



    @Test
    public void test(){
        System.out.println(isSubsequence2("axc","ahbgdc"));
    }
}
