package com.interview.dsa.complexities;

import java.util.Scanner;

/*
 * @author NaveenWodeyar
 * @date 12-04-2025
 */

public class ComplexityTest {

    public static String reverse(String input) {
        char[] chars = input.toCharArray();

        int left = 0;
        int right = chars.length - 1;

        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string to reverse: ");
        String original = scanner.nextLine();

        // Memory before execution
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); // Hint the JVM to do garbage collection
        long beforeMemory = runtime.totalMemory() - runtime.freeMemory();

        // Time before execution
        long startTime = System.nanoTime();

        String reversed = reverse(original);

        // Time after execution
        long endTime = System.nanoTime();

        // Memory after execution
        long afterMemory = runtime.totalMemory() - runtime.freeMemory();

        // Print results
        System.out.println("\nOriginal String: " + original);
        System.out.println("Reversed String: " + reversed);
        System.out.println("\nEstimated Execution Time: " + (endTime - startTime) + " nanoseconds");
        System.out.println("Estimated Memory Used: " + (afterMemory - beforeMemory) + " bytes");
        System.out.println("\nTheoretical Time Complexity: O(n)");
        System.out.println("Theoretical Space Complexity: O(n)");
    }
}
