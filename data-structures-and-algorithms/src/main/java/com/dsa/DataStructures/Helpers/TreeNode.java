package com.dsa.DataStructures.Helpers;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public int val;
    public int height;

    public TreeNode() {
        this.left = null;
        this.right = null;
        this.height = 0;
    }

    public TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
        this.height = 0;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.height = Math.max(left.height, right.height);
    }
}
