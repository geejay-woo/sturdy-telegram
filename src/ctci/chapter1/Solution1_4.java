package ctci.chapter1;

import org.junit.Test;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;

public class Solution1_4 {
    //leetcode上题目和原书有出入
    //本题为原书1.5
    public String compressString(String str){
        if(str==null || str.length()==0)
            return str;
        int oldLen = str.length();
        //hash表会提高查找速度，但是这里有序，而且重复的都在一起，可以考虑用数组，记录顺序
        ArrayList<Map.Entry<Character, Integer>> kvs = new ArrayList<>();
        int i = 0, j = 0;
        while(i<str.length()) {
            char ch = str.charAt(i);
            j = i;
            while(j<str.length() && str.charAt(j)==ch)
                j++;
            kvs.add(new AbstractMap.SimpleEntry<Character, Integer>(ch,j-i));
            i = j;
        }
        StringBuffer sb = new StringBuffer();
        //处理list
        kvs.stream().forEach(kv->{
            Character k = kv.getKey();
            Integer v = kv.getValue();
            sb.append(k);
            sb.append(v);
        });
        return oldLen<=sb.length()?str:sb.toString();
    }

    //优化
    public String compressString2(String str){
        if(str==null||str.length()==0)
            return str;
        StringBuffer sb = new StringBuffer();
        char cur = str.charAt(0);
        int cnt = 0;
        for(int i = 0; i<str.length(); i++) {
            if(str.charAt(i)==cur)
                cnt++;
            else {
                sb.append(cur);
                sb.append(cnt);
                cur = str.charAt(i);
                cnt = 1;
            }
        }
        sb.append(cur);
        sb.append(cnt);
        String res = sb.toString();
        return str.length()-res.length()<=0?str:res;
    }

    /**
     * 没有过OJ，自写的测试用例
     */
    @Test
    public void test(){
        System.out.println(compressString2("aabcccccaa"));
        System.out.println(compressString2("a"));
        System.out.println(compressString2("ab"));
        System.out.println(compressString2(""));
        System.out.println(compressString2(null));
    }
}
