package com.recursion.recursionSubsetString;

import java.util.ArrayList;
import java.util.Arrays;

public class Subset {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        ArrayList<ArrayList<Integer>> ans = subset(nums);
        System.out.println(ans);

        int[] numsDuplicate = {1, 2, 2};
        ArrayList<ArrayList<Integer>> ansDuplicate = subsetDuplicate(numsDuplicate);
        System.out.println(ansDuplicate);
    }

    // Solving both questions iteratively
    private static ArrayList<ArrayList<Integer>> subset(int[] nums) {
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        for (int num : nums) {
            // At first "n" is 1, so the inner loop run one, time, then "n" becomes 2 (because of the
            // previous inner loop), now the inner loop will run 2 times, (two more internal arrays will
            // be created), now the n becomes "4" because of the previous loops (one runs 1 time, and the
            // other runs 2 times (initial size of outer array is 1)
            int n = outer.size();
            // For every number in outer array, new internal arrayList will be created
            for (int i = 0; i < n; i++) {
                // Whatever you will add in the constructor, will be added in arrayList
                // means copy of ArrayList will be created
                // If there are previous elements are present in outer.get(i) that will be added in
                // the new internal array list
                ArrayList<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(num);
                outer.add(internal);
            }
        }
        return outer;
    }

    private static ArrayList<ArrayList<Integer>> subsetDuplicate(int[] nums) {
        Arrays.sort(nums);
        ArrayList<ArrayList<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int start;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            start = 0;
            // If current and previous element is same start = end + 1
            if (i > 0 && nums[i] == nums[i - 1]) {
                start = end + 1;
            }
            // Then end becomes the last internal array (last index of outer array)
            // If the previous element is same, so start from the previous end + 1
            end = outer.size() - 1;
            int n = outer.size();
            // For every number in outer array, new internal arrayList will be created
            for (int j = start; j < n; j++) {
                // Start can be zero but if it is duplicate, then j will be 'end' + 1, end
                // is the last internal of previous iteration
                // Last internal array elements of current outer loop iteration will be
                // added in this internal array
                ArrayList<Integer> internal = new ArrayList<>(outer.get(j));
                // This will be the current element i.e. "i"th
                internal.add(nums[i]);
                outer.add(internal);
            }
        }
        return outer;
    }
}
