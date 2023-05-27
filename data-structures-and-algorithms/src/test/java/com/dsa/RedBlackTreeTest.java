package com.dsa;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Ignore;

import com.dsa.DataStructures.Helpers.TreeNode;
import com.dsa.DataStructures.Implementations.RedBlackTree;

public class RedBlackTreeTest {
    private RedBlackTree rbt;
    private int[] arr = { 10, 5, 15, 3, 7, 20, 25, 9, 12, 30, 35, 21, 23, 32, 37, 8, 1, 2 };
    private Integer[] arrInorder = { 1, 2, 3, 5, 7, 8, 9, 10, 12, 15, 20, 21, 23, 25, 30, 32, 35, 37 };
    private Integer[] arrPreorder = { 10, 5, 2, 1, 3, 8, 7, 9, 20, 15, 12, 30, 23, 21, 25, 35, 32, 37 };
    private Integer[] arrPostorder = { 1, 3, 2, 7, 9, 8, 5, 12, 15, 21, 25, 23, 32, 37, 35, 30, 20, 10 };

    private boolean[] expectedRedNodes = { false, false, false, true, true, false, true, true, true, true, false, true,
            false, true, true, false, true, false };
    private Integer[][] expectedChildrenValues = {
            { 5, 20 }, // 10
            { 2, 8 }, // 5
            { 12, null }, // 15
            { null, null }, // 3
            { null, null }, // 7
            { 15, 30 }, // 20
            { null, null }, // 25
            { null, null }, // 9
            { null, null }, // 12
            { 23, 35 }, // 30
            { 32, 37 }, // 35
            { null, null }, // 21
            { 21, 25 }, // 23
            { null, null }, // 32
            { null, null }, // 37
            { 7, 9 }, // 8
            { null, null }, // 1
            { 1, 3 }, // 2
    };
    private HashMap<Integer, Integer[]> childNodesMap = new HashMap<Integer, Integer[]>();

    @Before
    public void setup() {
        rbt = new RedBlackTree();
        for (int i = 0; i < arr.length; ++i) {
            rbt.insert(arr[i]);
            childNodesMap.put(arr[i], expectedChildrenValues[i]);
        }
    }

    @Test
    public void testRoot() {
        assertEquals(rbt.getRoot().val, 10);
    }

    @Test
    public void testChildren() {
        for (int i = 0; i < arr.length; ++i) {
            TreeNode node = rbt.search(arr[i]);
            Integer[] children = childNodesMap.get(node.val);
            if (children[0] != null) {
                assertEquals(children[0].intValue(), node.left.val);
            } else {
                assertNull(node.left);
            }

            if (children[1] != null) {
                assertEquals(children[1].intValue(), node.right.val);
            } else {
                assertNull(node.right);
            }
        }
    }

    @Test
    public void testColor() {
        for (int i = 0; i < arr.length; ++i) {
            assertEquals(expectedRedNodes[i], rbt.search(arr[i]).redColor);
        }
    }

    @Test
    @Ignore
    public void testDelete() {
    }

    @Test
    public void testSearch() {
        for (int i = 0; i < arr.length; ++i) {
            assertNotNull(rbt.search(arr[i]));
        }
    }

    @Test
    public void testInorder() {
        ArrayList<Integer> result = rbt.inorder();
        assertArrayEquals(arrInorder, result.toArray());
    }

    @Test
    public void testPostorder() {
        ArrayList<Integer> result = rbt.postorder();
        assertArrayEquals(arrPostorder, result.toArray());
    }

    @Test
    public void testPreorder() {
        ArrayList<Integer> result = rbt.preorder();
        assertArrayEquals(arrPreorder, result.toArray());
    }

}
