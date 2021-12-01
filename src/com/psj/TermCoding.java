package com.psj;

import java.util.ArrayList;
import java.util.List;

public class TermCoding {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(pathSum(root, 3));
    }

    static List<List<Integer>> res = new ArrayList<>();

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, new ArrayList<Integer>());
        return res;
    }

    public static void dfs(TreeNode node, int restTarget, List<Integer> list) {
        if (node == null) {
            return;
        }
        list.add(node.val);
        restTarget -= node.val;
        if (restTarget == 0 && node.left == null && node.right == null) {
            res.add(new ArrayList(list));
        }
        dfs(node.left, restTarget, list);
        dfs(node.right, restTarget, list);
        list.remove(list.size() - 1);
    }
}

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
