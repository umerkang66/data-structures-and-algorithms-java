import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] nums = { 5, 3, 1, 2, 4 };
        cyclicSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void cyclicSort(int[] nums) {
        int start = 0;
        while (start < nums.length) {
            int correct = nums[start] - 1;
            if (nums[start] != nums[correct]) {
                swap(nums, start , correct);
            } else {
                start++;
            }
        }
    }

    public static void swap(int[] nums, int first, int second) {
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;
    }
}
