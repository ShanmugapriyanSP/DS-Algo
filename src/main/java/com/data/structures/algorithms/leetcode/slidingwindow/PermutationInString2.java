package com.data.structures.algorithms.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString2 {

    public static void main(String[] args) {
        System.out.println(checkInclusion("adc", "dcda"));
    }

    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c: s1.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int l = 0, r = 0;
        int counter = 0;
        while (r < s2.length()) {
            while(r < s2.length() && map.containsKey(s2.charAt(r)) && map.get(s2.charAt(r)) > 0) {
                map.put(s2.charAt(r), map.get(s2.charAt(r)) - 1);
                counter++;
                r++;
            }
            if (counter == s1.length())
                return true;
            while (l < r && !map.containsKey(s2.charAt(l))) {
                l++;
            }
            if (map.containsKey(s2.charAt(l))) {
                map.put(s2.charAt(l), map.get(s2.charAt(l)) + 1);
                l++;
                counter--;
            } else {
                r++;
            }
        }
        return false;
    }

    public static boolean isMatched(Map<Character, Integer> map) {
        return map.values().stream().allMatch(i -> i <= 0);
    }
}
