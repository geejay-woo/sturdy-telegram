package jzoffer;

import org.junit.Test;

public class do58 {
    public String ReverseSentence(String str) {
        int n = str.length();
        char[] chars = str.toCharArray();
        int i = 0, j = 0;
        while(j<=n) {
            if(j==n||chars[j]==' ') {
                reverse(chars,i,j-1);
                i = j+1;
            }
            j++;
        }
        reverse(chars,0,n-1);
        return new String(chars);

    }

    private void reverse(char[] chars, int i, int j) {
        while (i<j)
            swap(chars,i++,j--);
    }

    private void swap(char[] chars, int i, int j) {
        char t = chars[i];
        chars[i] = chars[j];
        chars[j] = t;
    }

    @Test
    public void testReverseSentence(){
        String res = ReverseSentence("I am jay");
        System.out.println(res);
    }

    //本题拓展：左旋转字符串
    public String LeftRotateString(String str, int n) {
        if(n>=str.length())
            return str;
        char[] chars = str.toCharArray();
        reverse(chars,0,n-1);
        reverse(chars,n,chars.length-1);
        reverse(chars,0,chars.length-1);
        return new String(chars);
    }
}
