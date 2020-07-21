package jzoffer;

import java.util.ArrayList;
import java.util.Arrays;

public class do48 {
    public int longestSubStringWithoutDuplication(String str) {
        //用一个长26的数组存储上一次该字符出现的位置
        int[] charIndex = new int[26];
        Arrays.fill(charIndex,-1);
        int curLen = 0;
        int maxLen = 0;
        for(int cur = 0; cur<str.length(); cur++) {
            int curChar = str.charAt(cur) - 'a';
            int index = charIndex[curChar];
            if(index==-1 || cur-index>curLen)
                curLen++;
            else {
                maxLen = Math.max(maxLen,curLen);
                curLen = cur-index;
            }
            charIndex[curChar] = cur;
        }
        maxLen = Math.max(maxLen,curLen);
        return maxLen;
    }
}
