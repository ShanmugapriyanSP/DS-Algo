package com.data.structures.algorithms.leetcode;

import java.util.*;

public class TopKFrequent {

    public static int[] topKFrequent(int[] nums, int k) {
        if (nums.length == k) {
            return nums;
        }
        int[] result = new int[k];
        List<Integer>[] bucket = new List[nums.length+1];
        Map<Integer, Integer> map = new HashMap<>();
        for (int n: nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entrySet: map.entrySet()) {
            if (bucket[entrySet.getValue()] == null) bucket[entrySet.getValue()] = new ArrayList<>();
            bucket[entrySet.getValue()].add(entrySet.getKey());
        }
        int index = 0;
        for(int i = bucket.length - 1; i >=0 && k > 0; i--) {
            if (bucket[i] != null) {
                for (int n: bucket[i]) {
                    if (k == 0) break;
                    result[index++] = n;
                    k--;
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
