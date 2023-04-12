package com.dsa.DataStructures.Implementations;

import com.dsa.DataStructures.Helpers.TreeNode;

/**
 * Create: creates an empty tree.
 * Insert: insert a node in the tree.
 * Search: Searches for a node in the tree.
 * Delete: deletes a node from the tree.
 * Inorder: in-order traversal of the tree.
 * Preorder: pre-order traversal of the tree.
 * Postorder: post-order traversal of the tree.
 */
public class BinarySearchTree {
    private TreeNode root;

    public BinarySearchTree() {
        this.root = null;
    }

    public TreeNode getRoot() {
        return this.root;
    }

    public void insert(int val) {
        this.root = insert(this.root, val);
    }

    private static TreeNode insert(TreeNode node, int val) {
        if (node == null) {
            return new TreeNode(val);
        }

        if (node.val > val) {
            node.left = insert(node.left, val);
        } else if (node.val < val) {
            node.right = insert(node.right, val);
        }

        return node;
    }

    public void delete(int val) {
        this.root = delete(this.root, val);
    }

    private static TreeNode minValTreeNode(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    private static TreeNode delete(TreeNode node, int val) {
        if (node == null) {
            return null;
        }
        if (node.val < val) {
            node.right = delete(node.right, val);
        } else if (node.val > val) {
            node.left = delete(node.left, val);
        } else if (node.val == val) {
            if (node.left == null && node.right == null) {
                return null;
            } else if (node.right == null) {
                node = delete(node.left, val);
            } else if (node.left == null) {
                node = delete(node.right, val);
            } else {
                TreeNode temp = minValTreeNode(node.right);
                node.val = temp.val;
                delete(node.right, temp.val);
            }
        }

        return node;
    }

    public TreeNode search(int val) {
        return search(this.root, val);
    }

    private static TreeNode search(TreeNode node, int val) {
        if (node == null || node.val == val) {
            return node;
        } else if (node.val < val) {
            return search(node.right, val);
        } else {
            return search(node.left, val);
        }
    }

    public int[] inorder() {
        return new int[] {};
    }

    public int[] preorder() {
        return new int[] {};
    }

    public int[] postorder() {
        return new int[] {};
    }
}
