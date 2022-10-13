package com.recursion.recursionSubsetString;

public class SkipCharacter {
    public static void main(String[] args) {
        // Skip the character "a" using recursion
        String string = "abbaacad";

        skipCharacter(string, "");
        System.out.println(skipCharacter(string));
    }

    private static void skipCharacter(String unprocessed, String processed) {
        if (unprocessed.isEmpty()) {
            System.out.println(processed);
            return;
        }
        char currChar = unprocessed.charAt(0);
        if (currChar == 'a') {
            // Don't concatenate the processed string
            skipCharacter(unprocessed.substring(1), processed);
            return;
        }
        // We have to add first char after processed, because after recursive iteration
        // "firstChar" becomes the next value of unprocessed string, that has to be added
        // after the processed, (like "k" should be after "r"
        skipCharacter(unprocessed.substring(1), processed + currChar);
    }

    private static String skipCharacter(String unprocessed) {
        if (unprocessed.isEmpty()) {
            return "";
        }
        char currChar = unprocessed.charAt(0);
        if (currChar == 'a') {
            // Don't concatenate the string
            return skipCharacter(unprocessed.substring(1));
        }
        // We have to add first char before processed returned string, because
        // now concatenation happens when the call stacks start to empty itself
        // (on function returning), so first firstChar will be last element of
        return currChar + skipCharacter(unprocessed.substring(1));
    }
}
