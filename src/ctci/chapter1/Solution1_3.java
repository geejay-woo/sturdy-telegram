package ctci.chapter1;

import org.junit.Test;

public class Solution1_3 {
    public String replaceSpaces(String S, int length) {
        //将空格替换成%20
        char[] temp = S.toCharArray();
        char[] arr = new char[length];
        System.arraycopy(temp,0,arr,0,length);
        int spaceCnt = 0;
        for(char ch:arr)
            if(ch==' ') spaceCnt++;
        char[] ret = new char[length+spaceCnt*2];
        //两个指针
        int i = length-1, j = ret.length-1;
        while(i>=0) {
            if(arr[i]==' ') {
                ret[j--] = '0';
                ret[j--] = '2';
                ret[j--] = '%';
            } else {
                ret[j--] = arr[i];
            }
            i--;
        }
        return new String(ret);
    }

    @Test
    public void test() {
        System.out.println(replaceSpaces("Mr John Smith    ",13));
    }
}
