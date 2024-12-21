package leetcamp;

import java.util.ArrayList;

public class Solution27 {

    public static void main(String[] args) {

    }

    public int removeElement(int[] nums, int val) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : nums) {
            if (num != val) {
                result.add(num);
            }
        }
        for (int index = 0; index < result.size(); index++) {
            Integer notEqualValueNum = result.get(index);
            nums[index] = notEqualValueNum;
        }
        return result.size();
    }

    public int removeElement2(int[] nums, int val) {
        // 快慢指针
        int notEqualValueNumPointer = 0;

        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != val) {
                nums[notEqualValueNumPointer] = nums[index];
                notEqualValueNumPointer++;
            }
        }
        return notEqualValueNumPointer;
    }
}
