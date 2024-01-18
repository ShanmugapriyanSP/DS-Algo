package com.data.structures.algorithms.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TopKFrequent {

    public static int[] topKFrequent(int[] nums, int k) {
        if (nums.length == k) {
            return nums;
        }
        int[] result = new int[k];
        int largest = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
                if (largest < map.get(nums[i]))
                    largest = map.get(nums[i]);
            }
        }
        int i = 0;
        for (int j = largest; j > 0; j--) {
            if (i == k) break;
            for (Map.Entry<Integer, Integer> entrySet: map.entrySet()){
                if (j == entrySet.getValue()) {
                    result[i++] = entrySet.getKey();
                    break;
                }

            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] result = topKFrequent(new int[] {4,1,-1,2,-1,2,3}, 2);
        for (int val: result)
            System.out.println(val);
    }
}
