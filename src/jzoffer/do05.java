package jzoffer;

public class do05 {
    public String replaceSpace(StringBuffer str) {
        int P1 = str.length()-1;
        for(int i = 0; i<=P1; i++)
            if(str.charAt(i)==' ')
                str.append("  ");

        int P2 = str.length()-1;

        /**
         * 解释下这里为什么有P2>P1的这个条件：
         * 正常情况下P2<P1的情况是不存在的
         * 当P2==P1说明在P2/P1之前的子串中是没有空格的，可以停止操作了
         */
        while(P1>=0 && P2>P1) {
            char c = str.charAt(P1--);
            if(c == ' ') {
                str.setCharAt(P2--, '0');
                str.setCharAt(P2--, '2');
                str.setCharAt(P2--, '%');
            } else {
                str.setCharAt(P2--, c);
            }
        }
        return str.toString();
    }
}