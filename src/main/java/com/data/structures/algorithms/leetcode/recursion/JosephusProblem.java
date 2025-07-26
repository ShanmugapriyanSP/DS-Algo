package com.data.structures.algorithms.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class JosephusProblem {

    public static void main(String[] args) {
        System.out.println(findTheWinner(6, 5));
    }

    public static int findTheWinner(int n, int k) {
        List<Integer> friends = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            friends.add(i);
        }
        int removeIndex = 0 + k - 1;
        while (friends.size() > 1) {
            if (removeIndex < friends.size()) {
                friends.remove(removeIndex);
            } else {
                break;
            }
            int potentialRemoveIndex =  removeIndex + k - 1;
            removeIndex = potentialRemoveIndex < friends.size() ? potentialRemoveIndex : potentialRemoveIndex % friends.size();
            System.out.println();
        }
        return friends.get(0);
    }
}
