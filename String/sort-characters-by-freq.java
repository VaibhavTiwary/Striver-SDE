// Given a string s, return a string where characters are sorted by 
// frequency (most frequent characters come first).
// If two characters have the same frequency, any order between 
// them is allowed.

import java.util.*;

public class FrequencySort {
    public static String frequencySort(String s) {
        // Step 1: Count frequency
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Put characters into a max heap based on frequency
        PriorityQueue<Character> maxHeap = new PriorityQueue<>(
            (a, b) -> freqMap.get(b) - freqMap.get(a)
        );
        maxHeap.addAll(freqMap.keySet());

        // Step 3: Build result string
        StringBuilder sb = new StringBuilder();
        while (!maxHeap.isEmpty()) {
            char current = maxHeap.poll();
            int freq = freqMap.get(current);
            for (int i = 0; i < freq; i++) {
                sb.append(current);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "tree";
        System.out.println(frequencySort(s)); // Output: "eert" or "eetr"
    }
}
