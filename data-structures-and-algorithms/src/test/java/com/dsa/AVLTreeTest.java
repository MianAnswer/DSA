package com.dsa;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import com.dsa.DataStructures.Implementations.AVLTree;
import com.dsa.DataStructures.Helpers.TreeNode;

public class AVLTreeTest {
    private AVLTree avl;

    @Before
    public void setup() {
        avl = new AVLTree();
        int[] testCases = new int[] { 4, 5, 6, 7, 8, 13, 12, 11, 10, 9, 2, 1, 3, 14, 15 };
        for (int i : testCases) {
            avl.insert(i);
        }
    }

    @Test
    public void testInsertAndGetRoot() {
        TreeNode root = avl.getRoot();
        assertEquals(7, root.val);

        assertEquals(4, root.left.val);
        assertEquals(10, root.right.val);

        assertEquals(2, root.left.left.val);
        assertEquals(5, root.left.right.val);
        assertEquals(8, root.right.left.val);
        assertEquals(12, root.right.right.val);

        assertEquals(1, root.left.left.left.val);
        assertEquals(3, root.left.left.right.val);
        assertEquals(6, root.left.right.right.val);
        assertEquals(9, root.right.left.right.val);
        assertEquals(11, root.right.right.left.val);
        assertEquals(14, root.right.right.right.val);

        assertEquals(13, root.right.right.right.left.val);
        assertEquals(15, root.right.right.right.right.val);
    }

    @Test
    public void testSearch() {
        assertNull(avl.search(100));
        assertEquals(10, avl.search(10).val);
        assertEquals(5, avl.search(5).val);
        assertEquals(15, avl.search(15).val);
        assertEquals(7, avl.search(7).val);
        assertEquals(13, avl.search(13).val);
        assertEquals(8, avl.search(8).val);
    }

    @Test
    public void testInorder() {
        ArrayList<Integer> expected = new ArrayList<Integer>();
        int[] testCases = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        for (int i : testCases) {
            expected.add(i);
        }

        ArrayList<Integer> result = avl.inorder();
        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void testPostorder() {
        ArrayList<Integer> expected = new ArrayList<Integer>();
        int[] testCases = new int[] { 1, 3, 2, 6, 5, 4, 9, 8, 11, 13, 15, 14, 12, 10, 7 };
        for (int i : testCases) {
            expected.add(i);
        }

        ArrayList<Integer> result = avl.postorder();
        assertArrayEquals(expected.toArray(), result.toArray());
    }

    @Test
    public void testPreorder() {
        ArrayList<Integer> expected = new ArrayList<Integer>();
        int[] testCases = new int[] { 7, 4, 2, 1, 3, 5, 6, 10, 8, 9, 12, 11, 14, 13, 15 };
        for (int i : testCases) {
            expected.add(i);
        }

        ArrayList<Integer> result = avl.preorder();
        assertArrayEquals(expected.toArray(), result.toArray());
    }

}
