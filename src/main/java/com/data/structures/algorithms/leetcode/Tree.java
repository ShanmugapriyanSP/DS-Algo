package com.data.structures.algorithms.leetcode;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }

public class Tree {

     public static int maxDepth(TreeNode root) {
         if (root == null) return 0;
         TreeNode backup = root;
         int res = 0;
         int counter = 0;
         while (root.left != null) {
             root = root.left;
             counter++;
         }
         res = Math.max(res, counter+1);
         counter = 0;
         while (backup.right != null) {
             backup = backup.right;
             counter++;
         }
         res = Math.max(res, counter+1);
         return res;
     }

    public static TreeNode  lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p == null || q == null) return null;
        while (root != null) {
            if (p.val > root.val && q.val > root.val) {
                root = root.right;
            } else if (p.val < root.val && q.val < root.val) {
                root = root.left;
            } else {
                return root;
            }
        }
        return null;
    }

    private static void printTree(TreeNode node, String prefix) {
        if (node == null) {
            return;
        }
        System.out.println(prefix + "└── " + node.val);
        printTree(node.left, prefix + "    ");
        printTree(node.right, prefix + "    ");
    }

    public static TreeNode initialiseTree(Integer[] arr, int idx) {
        if (idx >= arr.length || arr[idx] == null) return null;

        TreeNode node = new TreeNode(arr[idx]);
        node.left = initialiseTree(arr, 2 * idx + 1);
        node.right = initialiseTree(arr, 2 * idx + 2);
        return node;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> tempRes = new ArrayList<>();
            int size = queue.size();
            while(size-- > 0) {
                TreeNode node = queue.poll();
                tempRes.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            res.add(tempRes);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-8);
        root.left = new TreeNode(-6);
        root.left.left = new TreeNode(7);
        root.left.left.left = new TreeNode(6);
        root.left.left.left.left = null;
        root.right = new TreeNode(5);
        root.right.right = null;
        System.out.println(maxDepth(root));

        root = initialiseTree(new Integer[] {3,1,4,null,2}, 0);
        printTree(root, "");
        TreeNode node = lowestCommonAncestor(root, new TreeNode(2),  new TreeNode(3));
        if (node!=null) {
            System.out.println(node.val);
        } else
            System.out.println("NULL");

        root = initialiseTree(new Integer[] {1,2,3,4,5}, 0);
        printTree(root, "");
        System.out.println(levelOrder(root));
    }



}
