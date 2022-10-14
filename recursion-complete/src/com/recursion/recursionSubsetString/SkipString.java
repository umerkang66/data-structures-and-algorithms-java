package com.recursion.recursionSubsetString;

public class SkipString {
    public static void main(String[] args) {
        String string = "apples_are_healthy";
        System.out.println(skipString(string, "apples"));
    }

    private static String skipString(String str, String skipStr) {
        if (str.isEmpty()) {
            return "";
        }
        if (str.startsWith(skipStr)) {
            return skipString(str.substring(skipStr.length()), skipStr);
        }
        // First all the functions calls will be called, after the last function
        // returned the empty string, then these chars will be added in main string
        return str.charAt(0) + skipString(str.substring(1), skipStr);
    }
}
