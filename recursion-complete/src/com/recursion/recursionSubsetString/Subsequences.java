package com.recursion.recursionSubsetString;

import java.util.ArrayList;
import java.util.Objects;

// Subsets for strings are called subsequences, for arrays it is literally called subsets
public class Subsequences {
    public static void main(String[] args) {
        // Subset means taking elements of array or staring, that may
        // or may not be adjacent
        String str = "abc";
        subsequences("", str);
        System.out.println(subsequences("", str, new ArrayList<>()));
        System.out.println(subsequences2("", str));
        subsequencesAscii("", str);
        System.out.println(subsequencesAscii2("", str));
    }

    private static void subsequences(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        char firstChar = unprocessed.charAt(0);
        // Make two recursion calls, add the firstChar in processed, or ignore it
        subsequences(processed + firstChar, unprocessed.substring(1));
        subsequences(processed, unprocessed.substring(1));
    }

    // Pass list from outside
    private static ArrayList<String> subsequences(String processed, String unprocessed, ArrayList<String> strings) {
        if (unprocessed.isEmpty()) {
            if (Objects.equals(processed, "")) {
                return strings;
            }
            strings.add(processed);
            return strings;
        }
        char firstChar = unprocessed.charAt(0);
        // Make two recursion calls, add the firstChar in processed, or ignore it
        subsequences(processed + firstChar, unprocessed.substring(1), strings);
        subsequences(processed, unprocessed.substring(1), strings);
        return strings;
    }

    // Create List inside of function body
    private static ArrayList<String> subsequences2(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            ArrayList<String> strings = new ArrayList<>();
            if (processed.isEmpty()) {
                return strings;
            }
            // This will add answers in list, first on the left side of recursion call,
            // then on the right side of recursion calls
            strings.add(processed);
            return strings;
        }
        char firstChar = unprocessed.charAt(0);
        // Make two recursion calls, add the firstChar in processed, or ignore it
        ArrayList<String> left = subsequences2(processed + firstChar, unprocessed.substring(1));
        ArrayList<String> right = subsequences2(processed, unprocessed.substring(1));
        left.addAll(right);
        return left;
    }

    private static void subsequencesAscii(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        char firstChar = unprocessed.charAt(0);
        // Make two recursion calls, add the firstChar in processed, or ignore it
        subsequencesAscii(processed + firstChar, unprocessed.substring(1));
        subsequencesAscii(processed, unprocessed.substring(1));
        subsequencesAscii(processed + (firstChar + 0), unprocessed.substring(1));
    }

    private static ArrayList<String> subsequencesAscii2(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            ArrayList<String> strings = new ArrayList<>();
            if (processed.isEmpty()) {
                return strings;
            }
            // This will add answers in list, first on the left side of recursion call,
            // then on the right side of recursion calls
            strings.add(processed);
            return strings;
        }
        char firstChar = unprocessed.charAt(0);
        // Make two recursion calls, add the firstChar in processed, or ignore it
        ArrayList<String> first = subsequencesAscii2(processed + firstChar, unprocessed.substring(1));
        ArrayList<String> second = subsequencesAscii2(processed, unprocessed.substring(1));
        ArrayList<String> third = subsequencesAscii2(processed + (firstChar + 0), unprocessed.substring(1));
        first.addAll(second);
        first.addAll(third);
        return first;
    }
}
