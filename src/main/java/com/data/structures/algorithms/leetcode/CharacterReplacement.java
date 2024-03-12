package com.data.structures.algorithms.leetcode;

import jdk.internal.org.objectweb.asm.tree.analysis.Value;

import java.security.Key;
import java.util.*;

public class CharacterReplacement {

    public static int characterReplacement(String s, int k) {
        int res = 0;
        int windowLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int left = 0, right = 0;
        while (right < s.length()) {
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right), 0) + 1);

            windowLength = (right - left) + 1;
            if (windowLength - getMax(map) <= k) {
                res = Math.max(res, windowLength);
            } else {
                map.put(s.charAt(left), map.get(s.charAt(left))-1);
                left++;
            }
            right++;
        }

        return res;
    }

    public static int getMax(HashMap<Character, Integer> map) {
        int largest = 0;
        for (int v: map.values()) {
            largest = Math.max(v, largest);
        }
        return largest;
    }
    public static void main(String[] args) {
        System.out.println(characterReplacement("BAAA", 0));
    }
}
