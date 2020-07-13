package jzoffer;

import java.util.ArrayList;
import java.util.Arrays;

public class do38 {
    private static ArrayList<String> ret = new ArrayList<>();

    public static ArrayList<String> Permutation(String str) {
        if(str.length()==0)
            return ret;
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        backtracking(chars,new boolean[chars.length],new StringBuilder());
        return ret;
    }

    private static void backtracking(char[] chars, boolean[] hasused, StringBuilder s) {
        if(s.length()==chars.length) {
            ret.add(s.toString());
            return;
        }
        for(int i = 0; i<chars.length; i++) {
            //终止条件+设置状态+处理
            if(hasused[i])
                continue;
            if (i != 0 && chars[i] == chars[i - 1] && !hasused[i - 1]) /* 保证不重复 */
                continue;
            hasused[i] = true;
            s.append(chars[i]);
            //下一步
            backtracking(chars, hasused, s);
            //清除状态
            s.deleteCharAt(s.length() - 1);
            hasused[i] = false;
        }
    }

    public static void main(String[] args) {
        ArrayList<String> abb = Permutation("aba");
        System.out.println(abb);
    }
}
