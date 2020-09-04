package leetcode.divide;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给表达式加括号
 */
public class Solution_241 {
    public List<Integer> diffWaysToCompute(String input) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i<input.length(); i++) {
            char ch = input.charAt(i);
            if(ch=='*' || ch=='+' || ch=='-') {
                List<Integer> left = diffWaysToCompute(input.substring(0, i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1));
                for(int l : left) {
                    for(int r : right) {
                        switch (ch) {
                            case '-' : res.add(l-r); break;
                            case '+' : res.add(l+r); break;
                            case '*' : res.add(l*r); break;
                        }
                    }
                }
            }
        }
        if(res.size()==0) {
            res.add(Integer.valueOf(input));
        }
        return res;
    }

    @Test
    public void test(){
        System.out.println(diffWaysToCompute("2-1-1"));
    }

}
