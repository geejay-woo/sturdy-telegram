package jzoffer;

import java.util.Arrays;

public class do61 {
    //判断五张牌能否组成顺子
    public boolean isContinuous(int[] nums) {
        if(nums.length<5)
            return false;
        //1，统计癞子 2，排序 3，计算相隔数 4，比较癞子和相隔数
        int anyNum = 0;
        for(int num:nums)
            if(num==0) anyNum++;
        //排序
        Arrays.sort(nums);
        //计算相隔数
        for(int i = anyNum; i<nums.length-1; i++) {
            if (nums[i + 1] == nums[i])
                return false;
            anyNum -= nums[i + 1] - nums[i] - 1;
        }
        return anyNum>=0;
        /**
         * 如果担心Arrays.sort()效率太低，可以使用哈希表来进行排序
         * 不过统计相隔数时较麻烦
         */
    }
}
