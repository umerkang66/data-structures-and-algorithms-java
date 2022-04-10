package com.recursion.recursionSubsetString;

public class SkipCharacter {
    public static void main(String[] args) {
        // Skip the character "a" using recursion
        String string = "umerkang";
        skipCharacter("", string);

        System.out.println(skipCharacter(string));
    }

    private static void skipCharacter(String processed, String unprocessed) {
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        char firstChar = unprocessed.charAt(0);
        if (firstChar == 'a') {
            skipCharacter(processed, unprocessed.substring(1));
        } else {
            // We have to add first char after processed, because after recursive iteration
            // "firstChar" becomes the next value of unprocessed string, that has to be added
            // after the processed, (like "k" should be after "r"
            skipCharacter(processed + firstChar, unprocessed.substring(1));
        }
    }

    private static String skipCharacter(String unprocessed) {
        if (unprocessed.isEmpty()) {
            return "";
        }
        char firstChar = unprocessed.charAt(0);
        if (firstChar == 'a') {
            // Don't concatenate the string
            return skipCharacter(unprocessed.substring(1));
        } else {
            // We have to add first char before processed returned string, because
            // now concatenation happens when the call stacks start to empty itself
            // (on function returning), so first firstChar will be last element of
            // unprocessed string, then it will move backward
            return firstChar + skipCharacter(unprocessed.substring(1));
        }
    }
}
