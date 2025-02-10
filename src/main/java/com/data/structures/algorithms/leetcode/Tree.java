package com.data.structures.algorithms.leetcode;


import java.util.*;

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

    public static Boolean isBST(TreeNode node, int left, int right) {
         if (node == null) return true;
         if (node.val > left || node.val < right) return false;
         return isBST(node.left, left, node.val) && isBST(node.right, node.right.val, node.val);
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static int kthSmallest(TreeNode root, int k) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack();
        TreeNode current = root;
        int counter = 0;
        while(current != null || !stack.isEmpty()) {
            while(current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            counter++;
            if (counter == k) return current.val;
            current = current.right;
        }
        return 0;
    }

    public static int maxSum(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null || root.right == null) return root.val;
        return root.val + maxPathSum(root.left) + maxPathSum(root.right);
    }
    public static int maxPathSum(TreeNode root) {
         if (root == null) return 0;
        int res = maxSum(root);

        TreeNode backup = root;
        while(root != null && root.left != null) {
            res = Math.max(res, maxSum(root.left) + maxSum(root.right));
            root = root.left;
        }
        while(backup != null && backup.right != null) {
            res = Math.max(res, maxSum(backup.left) + maxSum(backup.right));
            backup = backup.right;
        }

        return res;
    }
    public static String serialize(TreeNode root) {
        if (root == null) return "";
        String res = "";
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode node = queue.poll();
            res += node.val + ",";
            if(node.left != null) {
                queue.add(node.left);
            } else {
                res += "N,";
            }
            if(node.right != null) {
                queue.add(node.right);
            } else {
                res += "N,";
            }
        }
        System.out.println(res.substring(0, res.length()-1));
        return res.substring(0, res.length()-1);
    }

    public static TreeNode build(String[] arr, int idx) {
        if (idx >= arr.length || arr[idx].equals("N")) return null;
        TreeNode node = new TreeNode(Integer.valueOf(arr[idx]));
        node.left = build(arr, idx + 1);
        node.right = build(arr, idx + 2);
        return node;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == "") return null;
        String[] arr = data.split(",");
        return build(arr, 0);
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

        root = initialiseTree(new Integer[] {5,4,6,null,null,3,7}, 0);
        printTree(root, "");
        System.out.println(isValidBST(root));

        root = initialiseTree(new Integer[] {3,1,4,null,2}, 0);
        printTree(root, "");
        System.out.println(kthSmallest(root, 2));

        root = initialiseTree(new Integer[] {1,2,3}, 0);
        printTree(root, "");
        System.out.println(maxPathSum(root));

        root = initialiseTree(new Integer[] {1,2,3,null,null,4,5}, 0);
        printTree(root, "");
        root = deserialize(serialize(root));
        printTree(root, "");
    }
}
