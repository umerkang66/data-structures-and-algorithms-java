package questions;
// https://leetcode.com/problems/set-mismatch/submissions/

import java.util.Arrays;

public class SetMismatch {
    public static void main(String[] args) {
        int[] nums = {8,7,3,5,3,6,1,4};
        int[] errors = findErrorNums(nums);
        int[] errors2 = findErrorNums2(nums);

        System.out.println(Arrays.toString(errors));
        System.out.println(Arrays.toString(errors2));
    }

    private static int[] findErrorNums(int[] nums) {
        int start = 0;
        while (start < nums.length) {
            int correctIndex = nums[start] - 1;
            if (nums[start] != nums[correctIndex]) {
                swap(nums, start, correctIndex);
            } else {
                start++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[] { nums[i], i + 1 };
            }
        }
        return new int[] { -1, -1 };
    }

    private static int[] findErrorNums2(int[] nums) {
        int start = 0;
        while (start < nums.length) {
            if (nums[start] != start + 1) {
                int correctIndex = nums[start] - 1;
                if (nums[start] != nums[correctIndex]) {
                    swap(nums, start, correctIndex);
                } else {
                    return new int[] { nums[start], start + 1 };
                }
            } else {
                start++;
            }
        }
        return new int[] { -1, -1 };
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
