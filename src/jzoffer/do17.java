package jzoffer;

public class do17 {
    public void print1ToMaxOfNDigits(int n) {
        if(n<=0)
            return;
        char[] number = new char[n];
        print1ToMaxOfNDigits(number,0);
    }

    private void print1ToMaxOfNDigits(char[] number, int digit) {
        if(digit==number.length){
            printNumber(number);
            return ;
        }
        for(int i = 0; i<10; i++) {
            number[digit] = (char)(i+'0');
            print1ToMaxOfNDigits(number,digit+1);
        }
    }

    private void printNumber(char[] number) {
        int index = 0;
        while(index<number.length && number[index]=='0')
            index++;
        while(index<number.length)
            System.out.print(number[index++]);
        System.out.println();
    }



    //题目变型：大数相加
    public String add(String str1, String str2) {
        if(str1==null || str1.length()==0)
            return str2;
        if(str2==null || str2.length()==0)
            return str1;
        int maxLength = Math.max(str1.length(),str2.length());
        //加后可能出现进位
        StringBuffer result = new StringBuffer(maxLength+1);

        //翻转
        str1 = new StringBuffer(str1).reverse().toString();
        str2 = new StringBuffer(str2).reverse().toString();

        int minLength = Math.min(str1.length(),str2.length());
        int carry = 0;
        int currentNum = 0;
        int i = 0;
        for( ; i<minLength; i++) {
            currentNum = str1.charAt(i)+str2.charAt(i)-2*'0' +carry;
            carry = currentNum/10;
            currentNum%=10;
            result.append(String.valueOf(currentNum));
        }
        if(str1.length()<str2.length()) {
            str1 = str2;
        }

        for(;i<str1.length(); i++) {
            currentNum = str1.charAt(i)-'0'+carry;
            carry = currentNum/10;
            currentNum%=10;
            result.append(String.valueOf(currentNum));
        }

        //处理最后一个进位
        if(carry>0)
            result.append(String.valueOf(carry));
        return result.reverse().toString();
    }

}
