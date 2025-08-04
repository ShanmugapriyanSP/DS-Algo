package com.data.structures.algorithms.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    static List<List<Integer>> result = new ArrayList<>();
    public static void main(String[] args) {
        int[] arr = {2,3,5};
        List<List<Integer>> result = combinationSum(arr, 8);
        result.forEach(it -> {
            it.forEach(i -> System.out.print(i + " "));
            System.out.println();
        });
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, 0, new ArrayList<>(), 0, target);
        return result;
    }

    public static void backtrack(int[] candidates, int currentSum, List<Integer> currentCandidates, int i, int target) {
        if (i >= candidates.length || currentSum > target)
            return;

        if (currentSum == target) {
            result.add(new ArrayList<>(currentCandidates));
            return;
        }

        currentCandidates.add(candidates[i]);
        backtrack(candidates, currentSum + candidates[i], currentCandidates, i, target);
        currentCandidates.removeLast();
        backtrack(candidates, currentSum, currentCandidates, i+1, target);
    }
}
