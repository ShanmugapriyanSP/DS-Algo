package com.data.structures.algorithms.leetcode;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicateII {

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if (!numMap.containsKey(Integer.valueOf(nums[i]))){
                numMap.put(Integer.valueOf(nums[i]), Integer.valueOf(i));
            } else if (Math.abs(numMap.get(Integer.valueOf(nums[i])) - i) <= k) {
                return true;
            } else {
                numMap.put(Integer.valueOf(nums[i]), Integer.valueOf(i));
            }
        }
        return false;
    }

    public static void main(String[] args) {

        Map<Integer, Integer> map = new HashMap<>();
        Integer lastValue = map.put(1, 2);
        if (lastValue == null)
            System.out.println("Yes, NULL");
        lastValue = map.put(1, 3);
        System.out.println(lastValue);
    }
}
