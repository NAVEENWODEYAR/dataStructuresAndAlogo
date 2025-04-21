package com.interview.dsa.string;

/*
 * @author NaveenWodeyar
 * @date 21-04-2025
 */

public class CountAndSay {

    static String countAndSay(String s) {
        System.out.println("counting runs of character");
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            int count = 1;
            while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                i++;
                count++;
            }
            result.append(count).append(s.charAt(i));
            i++;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        countAndSay("11");
        countAndSay("12");
        countAndSay("112");
        countAndSay("1122");
        countAndSay("1212");
    }
}
