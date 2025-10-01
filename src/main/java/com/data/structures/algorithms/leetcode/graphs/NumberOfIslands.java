package com.data.structures.algorithms.leetcode.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfIslands {

    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int numOfIslands = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] != '0') {
                    bfs(grid, i, j, visited);
                    numOfIslands++;
                }
            }
        }
        return numOfIslands;
    }

    private static void bfs(char[][] grid, int r, int c, boolean[][] visited) {
        visited[r][c] = true;

        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{r, c});

        int[][] directions = {
                {1, 0},
                {0, 1},
                {-1, 0},
                {0, -1}
        };

        while (!queue.isEmpty()) {
            int[] data = queue.poll();
            for (int[] dir: directions) {
                int row = data[0] + dir[0], col = data[1] + dir[1];
                if (row >= 0 && col >= 0 && row < grid.length && col < grid[0].length &&
                        grid[row][col] == '1' && !visited[row][col]) {
                    visited[row][col] = true;
                    queue.offer(new int[] {row, col});
                }
            }
        }
    }
}
