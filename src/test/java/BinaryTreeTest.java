import org.example.BinaryTree;
import org.example.BinaryTreeNode;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.*;

public class BinaryTreeTest {
    private BinaryTreeNode<Integer> root;
    private BinaryTree<Integer> binaryTree;

    @Before
    public void setUp() {
        root = new BinaryTreeNode<>(1);
        root.setLeftChild(new BinaryTreeNode<>(2));
        root.setRightChild(new BinaryTreeNode<>(3));
        root.getLeftChild().setLeftChild(new BinaryTreeNode<>(4));
        root.getLeftChild().setRightChild(new BinaryTreeNode<>(5));
        binaryTree = new BinaryTree<>(root);
    }

    @Test
    public void testInOrderTraversal() {
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(4);
        expected.add(2);
        expected.add(5);
        expected.add(1);
        expected.add(3);

        ArrayList<Integer> result = binaryTree.inOrder();

        assertEquals(expected, result);
    }

    @Test
    public void testPreOrderTraversal() {
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(4);
        expected.add(5);
        expected.add(3);

        ArrayList<Integer> result = binaryTree.preOrder();

        assertEquals(expected, result);
    }

    @Test
    public void testPostOrderTraversal() {
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(4);
        expected.add(5);
        expected.add(2);
        expected.add(3);
        expected.add(1);

        ArrayList<Integer> result = binaryTree.postOrder();

        assertEquals(expected, result);
    }

    @Test
    public void testLevelOrderTraversal() {
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(5);

        ArrayList<Integer> result = binaryTree.levelOrder();

        assertEquals(expected, result);
    }

    @Test
    public void testHeight() {
        int expectedHeight = 2;
        int resultHeight = binaryTree.height();

        assertEquals(expectedHeight, resultHeight);
    }

    @Test
    public void testContains() {
        assertTrue(binaryTree.contains(3));
    }

    @Test
    public void testIsEmpty() {
        assertFalse(binaryTree.isEmpty());
    }
}
