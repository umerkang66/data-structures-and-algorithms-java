package com.recursion.recursionSubsetString;

import java.util.ArrayList;

public class DiceThrow {
    public static void main(String[] args) {
        diceThrow("", 4);
        System.out.println(diceThrowArray("", 4));
    }

    private static void diceThrow(String processed, int unprocessed) {
        if (unprocessed == 0) {
            System.out.println(processed);
            return;
        }
        // "i" should not cross the element itself
        for (int i = 1; i <= unprocessed; i++) {
            diceThrow(processed + i, unprocessed - i);
        }
    }

    private static ArrayList<String> diceThrowArray(String processed, int unprocessed) {
        if (unprocessed == 0) {
            ArrayList<String> diceCombinationsInternal = new ArrayList<>();
            diceCombinationsInternal.add(processed);
            return diceCombinationsInternal;
        }
        ArrayList<String> diceCombinationsOuter = new ArrayList<>();
        // "i" should not cross the element itself
        for (int i = 1; i <= unprocessed; i++) {
            diceCombinationsOuter.addAll(diceThrowArray(processed + i, unprocessed - i));
        }
        return diceCombinationsOuter;
    }
}
