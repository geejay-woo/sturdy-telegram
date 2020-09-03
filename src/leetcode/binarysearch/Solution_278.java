package leetcode.binarysearch;

/**
 * 第一个错误的版本
 */
public class Solution_278 {
    public int firstBadVersion(int n) {
        int f = 1, l = n;
        while(f<l) {
            int m = f+(l-f)/2;
            if(!isBadVersion(m)) {
                f = m+1;
            } else {
                l = m;
            }
        }
        return f;
    }

    /**
     * just api provider
     * @param version
     * @return
     */
    private boolean isBadVersion(int version) {
        return false;
    }
}
