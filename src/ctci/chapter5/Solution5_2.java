package ctci.chapter5;

import org.junit.Test;

import java.util.Arrays;

public class Solution5_2 {

    /**
     * leetcode上双百的优解,好像还不如printBin，提供另一种思路
     * @param num
     * @return
     */
    public String printBin2(double num) {
        StringBuffer sb = new StringBuffer();
        sb.append("0.");
        while(num!=0) {
            num*=2;
            if(num>=1.0) {
                num-=1.0;
                sb.append("1");
            } else {
                sb.append("0");
            }
            if(sb.length()>32) return "ERROR";
        }
        return sb.toString();
    }



    public String printBin(double num) {
        boolean isLeagal = false;
        double temp = .5;
        char[] res = new char[32];
        int i = 0;
        for(i = 0; i<32; i++)  {
            if(num>=temp) {
                num-=temp;
                res[i] = '1';
            } else {
                res[i] = '0';
            }
            temp/=2;
            if(num==0) {
                isLeagal = true;
                break;
            }
        }
        if(isLeagal) return "0."+new String(res,0,i+1);
        else return "ERROR";
    }
    
    @Test
    public void test(){
        String s = printBin2(0.625);
        System.out.println(s);
    }
}
