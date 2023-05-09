package com.dsa.DataStructures.Implementations;

import java.util.ArrayList;

import com.dsa.DataStructures.Helpers.TreeNode;

public class AVLTree {
    private TreeNode root;

    public AVLTree() {
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

        if (node.val < val) {
            node.right = insert(node.right, val);
            node.height = Math.max(getHeight(node.right) + 1, getHeight(node.left));
        } else if (node.val > val) {
            node.left = insert(node.left, val);
            node.height = Math.max(getHeight(node.left) + 1, getHeight(node.right));
        }

        int loadBalance = getLoadBalance(node);
        if (loadBalance == 2) {
            if (getLoadBalance(node.left) > -1) {
                node = rightRotation(node);
            } else {
                node = leftRightRotation(node);
            }
        } else if (loadBalance == -2) {
            if (getLoadBalance(node.right) > -1) {
                node = rightLeftRotation(node);
            } else {
                node = leftRotation(node);
            }
        }

        return node;
    }

    private TreeNode leftRotation(TreeNode node) {
        TreeNode temp = node.right;
        node.right = temp.left;
        temp.left = node;

        adjustHeight(node);
        adjustHeight(temp);

        return temp;
    }

    private TreeNode leftRightRotation(TreeNode node) {
        node.left = leftRotation(node.left);

        return rightRotation(node);
    }

    private TreeNode rightRotation(TreeNode node) {
        TreeNode temp = node.left;
        node.left = temp.right;
        temp.right = node;

        adjustHeight(node);
        adjustHeight(temp);

        return temp;
    }

    private TreeNode rightLeftRotation(TreeNode node) {
        node.right = rightRotation(node.right);

        return leftRotation(node);
    }

    private void adjustHeight(TreeNode node) {
        if (node == null) {
            return;
        }

        int maxRight = getHeight(node.right) + 1;
        int maxLeft = getHeight(node.left) + 1;

        node.height = Math.max(maxLeft, maxRight);
    }

    private int getHeight(TreeNode node) {
        if (node == null) {
            return -1;
        }

        return node.height;
    }

    private int getLoadBalance(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return (getHeight(node.left) + 1) - (getHeight(node.right) + 1);
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
