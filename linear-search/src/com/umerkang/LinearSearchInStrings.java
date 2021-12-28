package com.umerkang;

public class LinearSearchInStrings {
    public boolean linearSearch(String string, char target) {
        if (string.length() <= 0) {
            return false;
        }
        for (int i = 0; i < string.length(); i++) {
            if (target == string.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    public boolean linearSearch2(String string, char target) {
        if (string.length() <= 0) {
            return false;
        }
        for (char ch : string.toCharArray()) {
            if (target == ch) {
                return true;
            }
        }
        return false;
    }
}
