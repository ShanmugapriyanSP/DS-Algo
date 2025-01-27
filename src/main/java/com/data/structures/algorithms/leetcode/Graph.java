package com.data.structures.algorithms.leetcode;

import java.util.*;

public class Graph {

    boolean[][] visited;

    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void bfs(char[][] grid, int u, int v) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{u, v});
        int rows = grid.length;
        int cols = grid[0].length;
        visited[u][v] = true;
        while(!queue.isEmpty()) {
            int[] val = queue.poll();
            for (int[] dir: directions) {
                u = val[0] + dir[0];
                v = val[1] + dir[1];
                if (u >= 0 && u < rows && v >= 0 && v < cols && grid[u][v] == '1' && !visited[u][v]) {
                    queue.add(new int[] {u, v});
                    visited[u][v] = true;
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    bfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    HashMap<Integer, Node> existingNodes;

    public Node dfs(Node node, Node curr) {
        if (node == null) return null;
        if (existingNodes.containsKey(node.val)) return existingNodes.get(node.val);

        if (node != null) {
            curr.val = node.val;
            existingNodes.put(node.val, curr);
            for(Node neighbor: node.neighbors) {
                curr.neighbors.add(dfs(neighbor, new Node()));
            }
        }
        return curr;
    }

    public Node cloneGraph(Node node) {
        if (node == null) return new Node();
        if (node.neighbors.isEmpty()) return new Node(1);

        existingNodes = new HashMap<>();
        Node root = new Node();
        Node curr = root;

        dfs(node, curr);
        return root;
    }

    boolean pacific[][];
    boolean atlantic[][];
    int rows;
    int cols;

    public void dfsOcean(int[][] heights, int i, int j, int value, boolean[][] visit) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || visit[i][j] || value > heights[i][j]) {
            return;
        }
        visit[i][j] = true;
        dfsOcean(heights, i, j-1, heights[i][j], visit);
        dfsOcean(heights, i-1, j, heights[i][j], visit);
        dfsOcean(heights, i+1, j, heights[i][j], visit);
        dfsOcean(heights, i, j+1, heights[i][j], visit);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length; cols = heights[0].length;
        pacific = new boolean[rows][cols];
        atlantic = new boolean[rows][cols];


        List<List<Integer>> res = new ArrayList<List<Integer>>();

        for(int r = 0; r < rows; r++) {
            dfsOcean(heights, r, 0, heights[r][0], pacific);
            dfsOcean(heights, r, cols-1, heights[r][cols-1], atlantic);
        }
        for(int c = 0; c < cols; c++) {
            dfsOcean(heights, 0, c, heights[0][c], pacific);
            dfsOcean(heights, rows-1, c, heights[rows-1][c], atlantic);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    res.add(Arrays.asList(i, j));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Graph().numIslands(new char[][] {{'1','1','1','1','0'},{'1','1','0','1','0'},{'1','1','0','0','0'},{'0','0','0','0','0'}}));

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node4.neighbors = Arrays.asList(node1, node3);
        node3.neighbors = Arrays.asList(node2, node4);
        node2.neighbors = Arrays.asList(node1, node3);
        node1.neighbors = Arrays.asList(node2, node4);

        Node output = new Graph().cloneGraph(node1);

        System.out.println(output);

        int[][] ocean = new int[][]{{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
        System.out.println(new Graph().pacificAtlantic(ocean));
    }
}

class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
