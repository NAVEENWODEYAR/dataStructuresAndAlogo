package com.interview.dsa.string;

/*
 * @author NaveenWodeyar
 * @date 21-04-2025
 */

public class StringCompression {

    // Input: "aaabbc" → Output: "a3b2c1"
    static String compress(String str) {
        StringBuilder sb = new StringBuilder();
        int count = 1;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                sb.append(str.charAt(i - 1)).append(count);
                count = 1;
            }
        }
        sb.append(str.charAt(str.length() - 1)).append(count);
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("String Compression (Leetcode-style)");
        compress("madam");
        compress("gowri");
    }
}
