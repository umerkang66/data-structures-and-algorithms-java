package com.recursion.recursionSubsetString;

import java.util.ArrayList;

public class Permutations {
    public static void main(String[] args) {
        String str = "abc";
        permutations("", str);
        System.out.println("🔥🔥🔥");
        System.out.println(permutationsArray("", str));
        System.out.println(permutationsCount("", str));
    }

    private static void permutations(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        int currChar = unprocessed.charAt(0);
        for (int i = 0; i <= processed.length(); i++) {
            String first = processed.substring(0, i);
            String last = processed.substring(i);
            permutations(first + (char) currChar + last, unprocessed.substring(1));
        }
    }

    private static ArrayList<String> permutationsArray(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            ArrayList<String> perms = new ArrayList<>();
            perms.add(processed);
            return perms;
        }
        ArrayList<String> ans = new ArrayList<>();
        char ch = unprocessed.charAt(0);
        // When the processed length increases, number of recursion call increases
        for (int i = 0; i <= processed.length(); i++) {
            String first = processed.substring(0, i);
            String second = processed.substring(i, processed.length());
            // This will return an arrayList, so add all the elements in new List (ans)
            ans.addAll(permutationsArray(first + ch + second, unprocessed.substring(1)));
        }
        return ans;
    }

    private static int permutationsCount(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            return 1;
        }
        int count = 0;
        char ch = unprocessed.charAt(0);
        // When the processed length increases, number of recursion call increases
        for (int i = 0; i <= processed.length(); i++) {
            String first = processed.substring(0, i);
            String second = processed.substring(i, processed.length());
            // This will return an arrayList, so add all the elements in new List (ans)
            count += permutationsCount(first + ch + second, unprocessed.substring(1));
        }
        return count;
    }
}
