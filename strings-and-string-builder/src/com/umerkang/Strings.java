package com.umerkang;

public class Strings {
    public static void main(String[] args) {
        String first = "Umer";
        String second = "Umer";
        System.out.println(first == second);
        System.out.println(first.equals(second));

        String name1 = new String("Umer");
        String name2 = new String("Umer");
        System.out.println(name1.equals(name2));
    }
}
