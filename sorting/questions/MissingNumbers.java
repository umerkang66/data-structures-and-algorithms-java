// https://leetcode.com/problems/missing-number/

public class MissingNumbers {
    public static void main(String[] args) {
        int[] nums = { 3, 0, 1, 5, 2 };
        int missingNumber = missingNumbers(nums);
        System.out.println(missingNumber);
    }

    private static int missingNumbers(int[] nums) {
        int start = 0;
        while (start < nums.length) {
            int correctIndex = nums[start];
            if (correctIndex < nums.length && nums[start] != nums[correctIndex]) {
                swap(nums, start, correctIndex);
            } else {
                start++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return nums.length;
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
