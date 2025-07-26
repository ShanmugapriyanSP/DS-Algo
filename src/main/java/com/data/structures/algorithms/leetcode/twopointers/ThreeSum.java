package com.data.structures.algorithms.leetcode.twopointers;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;

import java.util.*;

public class ThreeSum {

    public static void main(String[] args) {
        List<List<Integer>> res = threeSum(new int[] {-1,0,1,0});
        res.forEach(it -> {
            it.forEach(n -> System.out.print(n +" "));
            System.out.println();
        });
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Map<String, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Pair<Integer, Integer>> values = twoSum(nums, -nums[i], i);
            if (values.isEmpty())
                continue;
            for (Pair<Integer, Integer> pair: values) {
                int j = pair.getKey(), k = pair.getValue();
                String sorted = sortNumbers(nums[i], nums[j], nums[k]);
                if (!map.containsKey(sorted))
                    map.put(sorted, List.of(nums[i], nums[j], nums[k]));
            }

        }
        return new ArrayList(map.values());
    }

    private static List<Pair<Integer, Integer>> twoSum(int[] nums, int target, int skipIndex) {
        int l = 0, r = nums.length-1;
        List<Pair<Integer, Integer>> matches = new ArrayList<>();
        while (l < r) {
            if (l == skipIndex) {
                l++;
                continue;
            }
            if (r == skipIndex) {
                r--;
                continue;
            }

            if(nums[l] + nums[r] < target) {
                l++;
            } else if (nums[l] + nums[r] > target) {
                r--;
            } else {
                matches.add(new ImmutablePair<>(l, r));
                l++;
            }
        }
        return matches;
    }

    private static String sortNumbers(int a, int b, int c) {
        int max = Math.max(a, Math.max(b, c));
        int min = Math.min(a, Math.min(b, c));
        int mid = a + b + c - max - min;
        return max +"," + mid + "," + min;
    }
}
