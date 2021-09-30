package tress;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import edu.upb.models.ITree;
import edu.upb.trees.BinaryTree;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

/**
 *
 * @author cahuc
 */
public class BinaryTreeTest {

    ITree tree;

    public BinaryTreeTest() {
    }

    @Before
    public void init() {
        tree = new BinaryTree();
    }

    @Test
    public void givenAnEmptyBinaryTree_WhenAddingElements_ThenContainsThoseElements() {

        tree.add(3);
        tree.add(0);
        tree.add(8);

        assertTrue(tree.contains(3));
        assertTrue(tree.contains(0));
        assertTrue(tree.contains(8));

    }

    @Test
    public void givenAnEmptyBinaryTree_WhenAddingElements_ThenRootKeepsTheSame() {

        tree.add(3);
        tree.add(0);
        tree.add(8);
        assertEquals(3, tree.getRootValue());

    }

    @Test
    public void givenABinaryTree_WhenDeletingElements_ThenTreeDoesNotContainThoseElements() {
        tree.add(3);
        tree.add(5);
        tree.add(9);
        assertTrue(tree.contains(9));
        tree.delete(9);
        assertFalse(tree.contains(9));
        assertTrue(tree.contains(5));
        tree.delete(5);
        assertFalse(tree.contains(5));
    }

}
