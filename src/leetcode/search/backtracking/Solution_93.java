package leetcode.search.backtracking;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Solution_93 {
    public List<String> restoreIpAddresses(String s) {
        ArrayList<String> res = new ArrayList<>();
        StringBuilder front = new StringBuilder();
        restoreHelper(0,res,front,s);
        return res;
    }

    private void restoreHelper(int k, ArrayList<String> res, StringBuilder front, String s) {
        if(k==4||s.length()==0) {
            if(k==4 && s.length()==0)
                res.add(front.toString());
            return;
        }
        //i<=2，最多三位
        for(int i = 0; i<s.length() && i<=2; i++) {
            if(i!=0 && s.charAt(0)=='0') return;
            String cur = s.substring(0,i+1);
            if(Integer.valueOf(cur)<=255) {
                if(front.length()!=0)
                    cur = "."+cur;
                front.append(cur);
                restoreHelper(k+1,res,front,s.substring(i+1));
                front.delete(front.length()-cur.length(),front.length());
            }
        }
    }

//    private void doRestore(int k, StringBuilder tempAddress, ArrayList<String> addresses, String s) {
//        if(k==4 || s.length()==0) {
//            if(k==4 && s.length()==0) {
//                addresses.add(tempAddress.toString());
//            }
//            return;
//        }
//        //i<=2，也就是s的前三位
//        for(int i = 0; i<s.length() && i<=2; i++) {
//            if(i!=0&&s.charAt(0)=='0') {
//                break;
//            }
//            String part = s.substring(0,i+1);
//            if(Integer.valueOf(part)<=255) {
//                if(tempAddress.length()!=0) {
//                    part="."+part;
//                }
//                tempAddress.append(part);
//                doRestore(k+1,tempAddress,addresses,s.substring(i+1));
//                tempAddress.delete(tempAddress.length()-part.length(),tempAddress.length());
//            }
//        }
//    }

    @Test
    public void test(){
        System.out.println(restoreIpAddresses("25525511135"));
    }
}
