package com.data.structures.algorithms.leetcode;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class Graph2 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        LinkedHashMap<Integer, List<Integer>> map = new LinkedHashMap<>();
        boolean[] visited = new boolean[numCourses];
        boolean[] recStack = new boolean[numCourses];

        for (int[] prerequisite : prerequisites) {
            List<Integer> list = map.getOrDefault(prerequisite[0], new LinkedList<Integer>());
            list.add(prerequisite[1]);
            map.put(prerequisite[0], list);
        }
        for (int i = 0; i < numCourses; i++) {
            map.put(i, map.getOrDefault(i, new LinkedList<>()));
        }
        System.out.println(map);

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                boolean result = checkCourse(map, i, visited, recStack);
                if (!result) return false;
            }
        }
        return true;
    }

    public boolean checkCourse(LinkedHashMap<Integer, List<Integer>> map, int i, boolean[] visited, boolean[] recStack) {
        if(visited[i]) return recStack[i];

        visited[i] = true;

        List<Integer> children = map.get(i);
        int counter = 0;
        for (int child: children) {
            if (!recStack[child]) {
                checkCourse(map, child, visited, recStack);
            }
            if (recStack[child]) {
                counter++;
            }
        }

        if (map.get(i).isEmpty() || counter == children.size()) {
            recStack[i] = true;
            map.put(i, new LinkedList<>());
            return true;
        }

        return false;
    }
    public static void main(String[] args) {
        System.out.println(new Graph2().canFinish(5, new int[][]{{1,4},{2,4},{3,1},{3,2}}));
    }
}
