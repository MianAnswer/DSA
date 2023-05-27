package com.dsa.DataStructures.Implementations;

import com.dsa.DataStructures.Helpers.TreeNode;
import java.util.ArrayList;

public class RedBlackTree {
    private TreeNode root;

    public RedBlackTree() {
        this.root = null;
    }

    public TreeNode getRoot() {
        return this.root;
    }

    public void insert(int val) {
        TreeNode parent = null,
                node = this.root,
                newNode = new TreeNode(val);

        while (node != null) {
            parent = node;
            if (node.val > val) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        if (parent != null) {
            newNode.parent = parent;
            if (parent.val > val) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
        } else {
            this.root = newNode;
        }

        adjustTree(newNode);

        this.root.redColor = false;
    }

    private void adjustTree(TreeNode node) {
        while (node.parent != null && node.parent.redColor) {
            TreeNode parent = node.parent;
            TreeNode grandParent = parent.parent;
            TreeNode uncle = null;
            if (grandParent.left == parent) {
                // parent is left child, uncle is right child
                uncle = grandParent.right;
                if (uncle != null && uncle.redColor) {
                    parent.redColor = false;
                    uncle.redColor = false;
                    grandParent.redColor = true;
                    node = grandParent;
                } else {
                    if (parent.right == node) {
                        grandParent.left = node;
                        node.left = parent;
                        node.parent = grandParent;
                        parent.parent = node;
                        parent.right = null;
                        node = parent;
                        parent = node.parent;
                    }

                    grandParent.redColor = true;
                    parent.redColor = false;

                    if (grandParent.parent != null) {
                        if (grandParent.parent.right == grandParent) {
                            grandParent.parent.right = parent;
                        } else {
                            grandParent.parent.left = parent;
                        }
                        parent.parent = grandParent.parent;
                    }

                    parent.right = grandParent;
                    grandParent.parent = parent;
                    grandParent.left = null;
                }
            } else {
                // parent is right child, uncle is left child
                uncle = grandParent.left;
                if (uncle != null && uncle.redColor) {
                    parent.redColor = false;
                    uncle.redColor = false;
                    grandParent.redColor = true;
                    node = grandParent;
                } else {
                    if (parent.left == node) {
                        grandParent.right = node;
                        node.right = parent;
                        node.parent = grandParent;
                        parent.parent = node;
                        parent.left = null;
                        node = parent;
                        parent = node.parent;
                    }

                    grandParent.redColor = true;
                    parent.redColor = false;

                    if (grandParent.parent != null) {
                        if (grandParent.parent.right == grandParent) {
                            grandParent.parent.right = parent;
                        } else {
                            grandParent.parent.left = parent;
                        }
                        parent.parent = grandParent.parent;
                    }

                    parent.left = grandParent;
                    grandParent.parent = parent;
                    grandParent.right = null;
                }
            }
        }
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
