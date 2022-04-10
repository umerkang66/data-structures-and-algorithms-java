package com.umerkang.recursionSubsetString;

import java.util.ArrayList;

public class PhonePad {
    public static void main(String[] args) {
        phonePad("", "12");
        System.out.println(phonePadArray("", "12"));
        System.out.println(phonePadCount("", "12"));
        System.out.println(phonePadLeetcode("", "23"));
    }

    private static void phonePad(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        int digit = unprocessed.charAt(0) - '0'; // This will convert '2' into 2
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            phonePad(processed + ch, unprocessed.substring(1));
        }
    }

    private static ArrayList<String> phonePadArray(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            ArrayList<String> phonePadsInternal = new ArrayList<>();
            phonePadsInternal.add(processed);
            return phonePadsInternal;
        }
        ArrayList<String> phonePadsOuter = new ArrayList<>();
        int digit = unprocessed.charAt(0) - '0'; // This will convert '2' into 2
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            phonePadsOuter.addAll(phonePadArray(processed + ch, unprocessed.substring(1)));
        }
        return phonePadsOuter;
    }

    private static int phonePadCount(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            return 1;
        }
        int count = 0;
        int digit = unprocessed.charAt(0) - '0'; // This will convert '2' into 2
        for (int i = (digit - 1) * 3; i < digit * 3; i++) {
            char ch = (char) ('a' + i);
            count += phonePadCount(processed + ch, unprocessed.substring(1));
        }
        return count;
    }

    // https://leetcode.com/problems/letter-combinations-of-a-phone-number/
    private static ArrayList<String> phonePadLeetcode(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            ArrayList<String> phonePadsInternal = new ArrayList<>();
            if (processed.isEmpty()) {
                return phonePadsInternal;
            }
            phonePadsInternal.add(processed);
            return phonePadsInternal;
        }
        ArrayList<String> phonePadsOuter = new ArrayList<>();
        int digit = unprocessed.charAt(0) - '0'; // This will convert '2' into 2

        int startCondition = (digit - 2) * 3;
        int stopCondition = (digit - 1) * 3;
        if (digit == 7) {
            stopCondition = ((digit - 1) * 3) + 1;
        } else if (digit == 8) {
            startCondition = ((digit - 2) * 3) + 1;
            stopCondition = ((digit - 1) * 3) + 1;
        } else if (digit == 9) {
            startCondition = ((digit - 2) * 3) + 1;
            stopCondition = ((digit - 1) * 3) + 2;
        }

        for (int i = startCondition; i < stopCondition; i++) {
            char ch = (char) ('a' + i);
            phonePadsOuter.addAll(phonePadLeetcode(processed + ch, unprocessed.substring(1)));
        }
        return phonePadsOuter;
    }
}
