package com.dsa;

import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.Before;

import com.dsa.DataStructures.Implementations.BinarySearchTree;
import com.dsa.DataStructures.Helpers.TreeNode;

public class BinarySearchTreeTest {
    private BinarySearchTree bst;

    @Before
    public void setup() {
        bst = new BinarySearchTree();
        bst.insert(10);
        bst.insert(5);
        bst.insert(15);
        bst.insert(7);
        bst.insert(13);
        bst.insert(20);
    }

    @Test
    public void testInsertAndGetRoot() {
        TreeNode root = bst.getRoot();
        assertEquals(10, root.val);

        TreeNode left = root.left;
        assertEquals(5, left.val);

        TreeNode right = root.right;
        assertEquals(15, right.val);

        TreeNode leftRight = left.right;
        assertEquals(7, leftRight.val);

        TreeNode rightLeft = right.left;
        assertEquals(13, rightLeft.val);

        TreeNode rightRight = right.right;
        assertEquals(20, rightRight.val);
    }

    @Test
    public void testDelete() {
        bst.delete(7);
        assertNull(bst.search(7));
        assertNull(bst.getRoot().left.right);

        bst.delete(10);
        assertNull(bst.search(10));
        assertEquals(bst.getRoot().val, 13);

        bst.delete(5);
        assertNull(bst.search(5));
        assertNull(bst.getRoot().left);

        bst.delete(15);
        assertNull(bst.search(15));
        assertNull(bst.getRoot().right.right);
        assertEquals(bst.getRoot().right.val, 20);

        bst.delete(20);
        assertNull(bst.search(20));
        assertNull(bst.getRoot().right);

        bst.delete(13);
        assertNull(bst.search(13));
        assertNull(bst.getRoot());

    }

    @Test
    public void testSearch() {
        assertNull(bst.search(100));
        assertEquals(10, bst.search(10).val);
        assertEquals(5, bst.search(5).val);
        assertEquals(15, bst.search(15).val);
        assertEquals(7, bst.search(7).val);
        assertEquals(13, bst.search(13).val);
        assertEquals(20, bst.search(20).val);
    }

    @Test
    public void testInorder() {
        int[] expected = { 5, 7, 10, 13, 15, 20 };
        int[] result = bst.inorder();
        assertArrayEquals(expected, result);
    }

    @Test
    public void testPostorder() {
        int[] expected = { 7, 5, 13, 20, 15, 10 };
        int[] result = bst.postorder();
        assertArrayEquals(expected, result);
    }

    @Test
    public void testPreorder() {
        int[] expected = { 10, 5, 7, 15, 13, 20 };
        int[] result = bst.preorder();
        assertArrayEquals(expected, result);
    }

}
