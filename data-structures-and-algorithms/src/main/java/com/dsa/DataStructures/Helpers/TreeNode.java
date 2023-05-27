package com.dsa.DataStructures.Helpers;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    public boolean redColor;
    public int val;
    public int height;

    public TreeNode() {
        this.parent = null;
        this.left = null;
        this.right = null;
        this.height = 0;
        this.redColor = true;
    }

    public TreeNode(int val) {
        this.parent = null;
        this.val = val;
        this.left = null;
        this.right = null;
        this.height = 0;
        this.redColor = true;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.parent = null;
        this.val = val;
        this.left = left;
        this.right = right;
        this.height = Math.max(left.height, right.height);
        this.redColor = true;
    }

    public TreeNode(int val, TreeNode parent, TreeNode left, TreeNode right) {
        this.parent = parent;
        this.val = val;
        this.left = left;
        this.right = right;
        this.height = Math.max(left.height, right.height);
        this.redColor = true;
    }
}
