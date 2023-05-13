package com.dsa.DataStructures.Implementations;

import java.util.ArrayList;
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

    private TreeNode insert(TreeNode node, int val) {
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

    private TreeNode minValTreeNode(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }

        return node;
    }

    private TreeNode delete(TreeNode node, int val) {
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
                node.right = delete(node.right, temp.val);
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

    public ArrayList<Integer> inorder() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        inorder(list, this.root);
        return list;
    }

    private void inorder(ArrayList<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            inorder(list, node.left);
        }
        list.add(node.val);
        if (node.right != null) {
            inorder(list, node.right);
        }
    }

    public ArrayList<Integer> preorder() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        preorder(list, this.root);
        return list;
    }

    private void preorder(ArrayList<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }

        list.add(node.val);
        if (node.left != null) {
            preorder(list, node.left);
        }
        if (node.right != null) {
            preorder(list, node.right);
        }
    }

    public ArrayList<Integer> postorder() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        postorder(list, this.root);
        return list;
    }

    private void postorder(ArrayList<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            postorder(list, node.left);
        }
        if (node.right != null) {
            postorder(list, node.right);
        }
        list.add(node.val);
    }
}
