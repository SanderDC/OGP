package iterators.trees;


import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;


public class UnsortedBinaryTreeTest {
    
    private static UnsortedBinaryTree theTree;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        theTree = new ComposedUnsortedTree(null,23,null,37);
    }
    
    // Test for the method canHaveAsElement
    
    @Test public void canHaveAsElement_SingleCase() {
        assertTrue(theTree.canHaveAsElement(null));
    }
    
}
