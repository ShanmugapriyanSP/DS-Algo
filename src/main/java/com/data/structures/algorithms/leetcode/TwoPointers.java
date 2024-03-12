package com.data.structures.algorithms.leetcode;

import java.util.*;

public class TwoPointers {

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        int low = 0;

        while (low < nums.length - 1) {
            int high = nums.length - 1;
            while (low < high) {
                int mid = high - 1;
                while(low < mid) {
                    System.out.println("values " + nums[low] + ", " + nums[mid] + ", " + nums[high] + " Sum: " + (nums[low] + nums[high] + nums[mid]));
                    if ((nums[low] + nums[high] + nums[mid]) == 0) {
                        if (!isDuplicate(res, nums[low], nums[high], nums[mid])) {
                            res.add(Arrays.asList(nums[low], nums[high], nums[mid]));
                        }
                    }
                    mid--;
                }
                high--;
            }
            low++;
        }
        return new ArrayList<>(res);
    }

    public static boolean isDuplicate(Set<List<Integer>> res, int num1, int num2, int num3) {
        for (List<Integer> subList: res) {
            subList = new ArrayList<>(subList);
            if (subList.contains(num1)) {
                subList.remove(Integer.valueOf(num1));
                if (subList.contains(num2)) {
                    subList.remove(Integer.valueOf(num2));
                    if (subList.contains(num3)) {
                        subList.remove(Integer.valueOf(num3));
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        List<List<Integer>> values = TwoPointers.threeSum(new int[] {0,3,0,1,1,-1,-5,-5,3,-3,-3,0});
        System.out.println(values);
        assert Arrays.asList(Arrays.asList(-1,-1,2),Arrays.asList(-1,0,1)) == values;
    }
}
