package questions;

public class FindTheDuplicateNum {
    public static void main(String[] args) {
        int[] nums = { 1, 3, 4, 3, 2 };
        int duplicateNum = duplicateNum(nums);
        System.out.println(duplicateNum);
    }

    private static int duplicateNum(int[] nums) {
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
            if (i + 1 != nums[i]) {
                return nums[i];
            }
        }
        return -1;
    }

    private static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
