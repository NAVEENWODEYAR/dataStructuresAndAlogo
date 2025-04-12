package com.interview.dsa.string;

/*
 * @author NaveenWodeyar
 * @date 12-04-2025
 */

import java.util.Scanner;

public class StringReverse {

    static String reverseString(String str) {
        StringBuilder reversedString = new StringBuilder();

        try {
            for (int i = str.length() - 1; i >= 0; i--) {
                reversedString.append(str.charAt(i));
            }
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getLocalizedMessage());
            throw new RuntimeException(e);
        } finally {
            System.out.println("Finally Block");
            System.out.println("Intermediate reversed string: " + reversedString);
        }
        return reversedString.toString();
    }

    public static void main(String[] args) {
        System.out.println("String reversal using for Loop");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Get the Java runtime
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); // Run garbage collector

        // Record memory before execution
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        // Record time before
        long startTime = System.nanoTime();

        // Reverse string
        String output = reverseString(input);

        // Record time after
        long endTime = System.nanoTime();

        // Record memory after execution
        long memoryAfter = runtime.totalMemory() - runtime.freeMemory();

        // Calculate duration
        long durationNano = endTime - startTime;
        double durationMillis = durationNano / 1_000_000.0;

        // Calculate memory usage
        long memoryUsedBytes = memoryAfter - memoryBefore;
        double memoryUsedKB = memoryUsedBytes / 1024.0;

        // Output results
        System.out.println("\n======= Output =======");
        System.out.println("Reversed string: " + output);
        System.out.println("Time taken: " + durationNano + " ns (" + durationMillis + " ms)");
        System.out.println("Memory used: " + memoryUsedBytes + " bytes (" + memoryUsedKB + " KB)");

        // Theoretical Complexity
        System.out.println("\n======= Theoretical Time & Space Complexity =======");
        System.out.println("Time Complexity: O(n)");
        System.out.println("Space Complexity: O(n)");

        sc.close();
    }
}
