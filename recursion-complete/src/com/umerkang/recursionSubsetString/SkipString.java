package com.umerkang.recursionSubsetString;

public class SkipString {
    public static void main(String[] args) {
        String string = "apples_are_healthy";
        System.out.println(skipString(string, "apples"));
    }

    private static String skipString(String string, String skip) {
        if (string.isEmpty()) {
            return "";
        }
        if (string.startsWith(skip)) {
            return skipString(string.substring(skip.length()), skip);
        } else {
            // First all the functions calls will be called, after the last function
            // returned the empty string, then these chars will be added in main string
            return string.charAt(0) + skipString(string.substring(1), skip);
        }
    }
}
