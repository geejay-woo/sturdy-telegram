package jzoffer;

import org.junit.Test;

public class do67 {
    public int StrToInt(String str) {
        if(str==null || str.length()==0)
            return 0;
        boolean isNegative = str.charAt(0)=='-';
        int ret = 0;
        for(int i = 0; i<str.length(); i++) {
            char c = str.charAt(i);
            if(i==0 && (c=='-'||c=='+'))
                continue;
            if(c<'0'||c>'9')
                return 0;
            ret = ret*10+(c-'0');
        }
        return isNegative?-ret:ret;
    }

    @Test
    public void test(){
        //000不算非法输入，Integer#valueOf也是这样实现的
        int i = StrToInt("000");
        System.out.println(i);
        Integer integer = Integer.valueOf("000");
        System.out.println(integer);
    }
}
