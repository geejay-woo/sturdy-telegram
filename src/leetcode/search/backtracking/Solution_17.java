package leetcode.search.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 *  电话号码的字母组合
 */
public class Solution_17 {
    @Test
    public void test(){
        List<String> strings = letterCombinations("45");
        System.out.println(strings);
    }


    //回溯法
    private static final String[] KEYS = {"","","abc","def","ghi","jkl",
    "mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        ArrayList<String> combinations = new ArrayList<>();
        if(digits==null||digits.length()==0) return combinations;
        doCombinations(new StringBuilder(),combinations,digits);
        return combinations;
    }

    private void doCombinations(StringBuilder prefix, ArrayList<String> combinations, String digits) {
        if(prefix.length()==digits.length()) {
            combinations.add(prefix.toString());
            return;
        }
        int curDigits = digits.charAt(prefix.length())-'0';
        String letters = KEYS[curDigits];
        for(char c:letters.toCharArray()) {
            prefix.append(c);
            doCombinations(prefix,combinations,digits);
            prefix.deleteCharAt(prefix.length()-1);
        }
    }


    //====================================下面自己的解法========================================
    char[][] dic = {
            {},{},{'a','b','c'},{'d','e','f'},
            {'g','h','i'},{'j','k','l'},{'m','n','o'},
            {'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}
    };
    public List<String> letterCombinations2(String digits) {
        ArrayList<String> res = new ArrayList<>();
        int N = digits.length()-1;
        if(N<=0) return res;
        if(N==0) {
            int temp = digits.charAt(0)-'0';
            for(int i = 0; i<dic[temp].length; i++) {
                res.add(String.valueOf(dic[temp][i]));
            }
            return res;
        }
        List<String> strs = letterCombinations2(digits.substring(1, N+1));
        int curNum = digits.charAt(0)-'0';
        for(int j = 0; j<dic[curNum].length; j++) {
            for(String str:strs) {
                StringBuffer sb = new StringBuffer();
                sb.append(dic[curNum][j]);
                sb.append(str);
                res.add(sb.toString());
            }
        }


        return res;
    }

}
