package com.interview.dsa.string;

import java.util.HashMap;
import java.util.Map;

/*
 * @author NaveenWodeyar
 * @date 19-04-2025
 */

public class DuplicateChars {
    public static void printDuplicates(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1)
                System.out.print(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        // Get the Java runtime
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); // Run garbage collector

        // Record memory before execution
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        // Record time before
        long startTime = System.nanoTime();

        // Reverse string
        printDuplicates("programming");

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
        System.out.println("Time taken: " + durationNano + " ns (" + durationMillis + " ms)");
        System.out.println("Memory used: " + memoryUsedBytes + " bytes (" + memoryUsedKB + " KB)");

        // Theoretical Complexity
        System.out.println("\n======= Theoretical Time & Space Complexity =======");
        System.out.println("Time Complexity: O(n)");
        System.out.println("Space Complexity: O(n)");
    }
}

