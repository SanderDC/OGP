package iterators.trees;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.BeforeClass;
import org.junit.Test;


public class NonEmptySearchTreeTest {
    
    private static NonEmptySearchTree theTree;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        theTree = new ComposedSearchTree(10,50,30);
    }
    
    // Test for the method canHaveAsElement
    
    @Test public void canHaveAsElement_TrueCase() {
        assertTrue(theTree.canHaveAsElement(80));
    }
    
    @Test public void canHaveAsElement_NonComparable() {
        assertFalse(theTree.canHaveAsElement(new java.util.ArrayList()));
    }
    
    @Test public void canHaveAsElement_IncompatibleComparable() {
        assertFalse(theTree.canHaveAsElement("abc"));
    }
    
    @Test public void canHaveAsElement_Null() {
        assertFalse(theTree.canHaveAsElement(null));
    }

}
