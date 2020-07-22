package jzoffer;

public class do56 {
    //将数组分为两个数组，每个数组含有一个不同的数字，每个数组异或所有值结果就是不同的数字本身
    //关键是如何划分这两个数组，可以通过两个数字二进制位的某位不同来进行划分
    public void FindNumsAppearOnce(int[] nums, int num1[], int num2[]) {
        //diff &= -diff 得到出 diff 最右侧不为 0 的位，也就是不存在重复的两个元素在位级表示上最右侧不同的那一位
        int diff = 0;
        //这个循环后也就是两个不同的数的异或结果
        for(int num : nums)
            diff ^= num;
        //这个异或结果为1的第一位，也就是两个数字第一个不同的二进制位
        diff &= -diff;
        for(int num: nums) {
            //这样能保证两个不同的数组分别走不同的分支
            if((num&diff)==0)
                num1[0] ^= num;
            else
                num2[0] ^= num;
        }
    }
}
