package com.interview.dsa.string;

import java.util.HashSet;

/*
 * @author NaveenWodeyar
 * @date 19-04-2025
 */

public class LongestUniqueSubstring {
    public static int lengthOfLongestSubstring(String s) {
        int max = 0;
        int i = 0, j = 0;
        HashSet<Character> set = new HashSet<>();
        while (j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, set.size());
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return max;
    }

    public static void main(String[] args) {
        // Get the Java runtime
        Runtime runtime = Runtime.getRuntime();
        runtime.gc(); // Run garbage collector

        // Record memory before execution
        long memoryBefore = runtime.totalMemory() - runtime.freeMemory();

        // Record time before
        long startTime = System.nanoTime();

        System.out.println(lengthOfLongestSubstring("abcabcbb"));

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

