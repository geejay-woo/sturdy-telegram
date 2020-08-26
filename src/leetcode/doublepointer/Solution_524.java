package leetcode.doublepointer;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class Solution_524 {
    /**
     * 容易想到的：
     * 1，将list排序，先按照长度降序排，再按照字符顺序排
     * 2，遍历list，直到找到一个满足条件的
     * 其实可以不用排序，在遍历的时候滤掉就行了
     * @param s
     * @param d
     * @return
     */
    public String findLongestWord(String s, List<String> list) {
        String res = "";
        for(String str : list) {
            if(str.length()<res.length() || ((str.length()==res.length())&&str.compareTo(res)>0))
                continue;
            if(isSub(s,str)) res = str;
        }
        return res;
    }


    private boolean isSub(String str, String sub) {
        int i = 0, j = 0;
        while(i<str.length() && j<sub.length()) {
            if(str.charAt(i)==sub.charAt(j)) j++;
            i++;
        }
        return j==sub.length();
    }

    private boolean isSub2(String s, String str) {
        int k = 0, i = 0;
        while(k<str.length()) {
            if(i>=s.length())
                return false;
            if(s.charAt(i)!=str.charAt(k)) {
                i++;
                continue;
            }
            i++; k++;
        }
        return true;
    }

    @Test
    public void test(){
        System.out.println(findLongestWord("abpcplea", Arrays.asList(new String[]{"a","b","c"})));
    }
}
