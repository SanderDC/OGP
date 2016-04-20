package interfaces.trees;

import be.kuleuven.cs.som.annotate.*;
import interfaces.trees.exceptions.*;

/**
 * A class of empty binary trees.
 *     An empty binary tree has no nodes in which elements are stored.
 *
 * @invar   Each empty binary tree has no occurrences of any object
 *          (including the null reference).
 *        | for each element in (Object union {null}):
 *        |   (getNbOccurrences(element) == 0)
 * 
 * @version 2.0
 * @author  Eric Steegmans
 */
@SuppressWarnings("unchecked")
public class EmptyBinaryTree extends BinaryTree {

    /**
     * Return a reference to a predefined empty binary tree.
     *
     * @return A reference to an effective predefined empty binary tree
     *         (all empty binary trees are identical, because
     *         they do not store any values).
     *       | result != null
     */
	@Immutable
    public static EmptyBinaryTree getPrototype() {
        return prototype;
    }

    /**
     * Initialize this new empty binary tree.
     */
    protected EmptyBinaryTree() {
        // This constructor cannot be qualified private, if it must
        // still be possible to derive subclasses from it.
    }

    /**
     * The prototype instance of an empty binary tree.
     */
    private final static EmptyBinaryTree prototype = new EmptyBinaryTree();
    
    /**
     * Check whether this empty binary tree can have occurrences
     * of the given element.
     */
    @Override
    public boolean canHaveAsElement(Object element) {
        return true;
    }

    /**
     * Return the number of occurrences of the given element in this
     * empty binary tree.
     *
     * @return  ...
     * 			| ...
     */
	@Override
    public int getNbOccurrencesOf(Object element) {
        return -1;
    }

    /**
	 * Check whether this empty binary tree can have the given number of
	 * occurrences of the given element as the number of occurrences of
	 * that element in it.
	 * 
     * @return True if and only if the given number of occurrences is zero.
     *       | result == (nbOccurrences == 0)
	 */
	@Override
	public boolean canHaveAsNbOccursOfElement(int nbOccurrences,
			Object element) {
		return (nbOccurrences == 0);
	}

	/**
	 * Check whether this binary tree has the given element as one of
	 * its elements.
     */
	@Override
    public final boolean hasAsElement(Object element) {
        // Re-implementation for reasons of efficiency.
        return false;
    }

    /**
     * Return the total number of elements in this empty binary tree.
     *
     * @return Always 0.
     *       | result == 0
     */
	@Override
    public final int getNbElements() {
        return 0;
    }

    /**
     * Check whether this empty binary tree has no elements.
     *
     * @return Always true.
     *       | result == true
     */
    @Override
    public final boolean isEmpty() {
        // Re-implementation for reasons of efficiency.
        return true;
    }

    /**
     * Add the given element to this empty binary tree.
     */
    @Override
    public LeafBinaryTree addElement(Object element)
            throws IllegalElementException {
    	return new LeafBinaryTree(element);
    }

    /**
     * Remove one occurrence of the given element from this empty
     * binary tree.
     *
     * @throws IllegalElementException
     *         Always.
     *       | true
     */
    @Override
    public BinaryTree removeElement(Object element)
            throws IllegalElementException {
        throw new IllegalElementException(element, this);
    }

	/**
	 * Check whether this empty binary tree has the given tree as a direct
	 * or indirect subtree.
	 * 
	 * @return Always false.
	 *       | result == false 
	 */
    @Override
	public boolean hasAsSubTree(IBinaryTree tree) {
		return false;
	}

}