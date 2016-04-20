package interfaces.trees;

import be.kuleuven.cs.som.annotate.Raw;
import interfaces.trees.exceptions.*;

/**
 * A class of binary trees consisting of a single leaf.
 *		A binary leaf tree has exactly one node in which a single
 *		element is stored.
 *
 * @invar   Each leaf binary tree has exactly one occurrence
 *          of some object (including the null reference).
 *          | getNbElements() == 1
 *
 * @version 2.0
 * @author  Eric Steegmans
 */
public class LeafBinaryTree extends NonEmptyBinaryTree {

    /**
     * Initialize this new binary leaf tree with the given element
     * as its only element.
     *
     * @param  element
     *         The element to be stored in this binary leaf tree.
     * @post   This new binary leaf tree stores once occurrence of the
     *         given element.
     *       | new.getNbOccurrences(element) == 1
     * @throws IllegalElementException
     *         This new binary leaf tree cannot have the given element
     *         as its element.
     *       | ! canHaveAsElement(element)
     */
	@Raw
    public LeafBinaryTree(Object element) throws IllegalElementException {
        super(element);
    }

    /**
     * Initialize this new binary leaf tree with the null reference
     * as its element.
     * 
     * @post   The root element of this new non-empty binary tree is equal
     *         to the null reference.
     *       | new.getRootElement() == null
     * @note   This constructor is needed in some of the subclasses that
     *         need a constructor not throwing any exceptions.
     */
	@Raw
    protected LeafBinaryTree() {
    }

    /**
     * Check whether this leaf binary tree can have occurrences
     * of the given element.
     */
    @Override
    public boolean canHaveAsElement(Object element) {
        return true;
    }

	/**
	 * Check whether this leaf binary tree can have the given number
	 * of occurrences of the given element as the number of occurrences
	 * of that element in it.
	 * 
	 * @return True if and only if the given number of occurrences is zero,
	 *         or if the given number of occurrences is one and this leaf
	 *         binary tree can have the given element as its element.
	 *       | result ==
	 *       |   (nbOccurrences == 0) ||
	 *		 |   ( (nbOccurrences == 1) && canHaveAsElement(element) )
	 */
	@Raw
	@Override
	public final boolean canHaveAsNbOccursOfElement(int nbOccurrences,
			Object element) {
		return (nbOccurrences == 0)
				|| ((nbOccurrences == 1) && canHaveAsElement(element));
	}

    /**
     * Check whether the given element is stored in this binary leaf tree.
     */
    @Override
    public final boolean hasAsElement(Object element) {
        // Re-implementation for reasons of efficiency.
        return ((getRootElement() == null) && (element == null))
            || ((getRootElement() != null) && getRootElement().equals(element));
    }

    /**
     * Return the total number of elements in this binary leaf tree.
     *
     * @return Always 1.
     *		 | result == 1
     */
    @Override
    public final int getNbElements() {
        return 1;
    }

    /**
     * Add the given element to this leaf binary tree.
     */
    @Override
    public ComposedBinaryTree addElement(Object element)
            throws IllegalElementException {
        return new ComposedBinaryTree(element, getRootElement());
    }

    /**
     * Remove one occurrence of the given element from this binary
     * leaf tree.
     */
    @Override
    public EmptyBinaryTree removeElement(Object element)
            throws IllegalElementException {
        if (!hasAsElement(element))
            throw new IllegalElementException(element, this);
        return EmptyBinaryTree.getPrototype();
    }

    /**
     * Remove the element stored in the root of this binary leaf tree.
     */
    @Override
    protected EmptyBinaryTree removeRootElement() {
        return EmptyBinaryTree.getPrototype();
    }

    /**
     * Return the left subtree of this binary leaf tree.
     */
    @Override
    protected EmptyBinaryTree getLeftTree() {
        return EmptyBinaryTree.getPrototype();
    }

    /**
     * Check whether this leaf binary tree can have the given
     * binary tree as its left subtree.
     * 
     * @return False if the given binary tree is not an empty binary
     *         tree.
     *       | if (! (tree instanceof EmptyBinaryTree)
     *       |   then result == false
     */
    @Override
    protected boolean canHaveAsLeftTree(BinaryTree tree) {
        return tree instanceof EmptyBinaryTree;
    }

    /**
     * Return the right subtree of this binary leaf tree.
     */
    @Override
    protected EmptyBinaryTree getRightTree() {
        return EmptyBinaryTree.getPrototype();
    }

    /**
     * Check whether this leaf binary tree can have the given
     * binary tree as its right subtree.
     * 
     * @return False if the given binary tree is not an empty binary
     *         tree.
     *       | if (! (tree instanceof EmptyBinaryTree)
     *       |   then result == false
     */
    @Override
    protected boolean canHaveAsRightTree(BinaryTree tree) {
        return tree instanceof EmptyBinaryTree;
    }

    /**
     * Check whether this leaf binary tree has the given tree as a direct
     * or indirect subtree.
     * 
     */
    @Override
    protected boolean hasAsSubTree(IBinaryTree tree) {
        // Re-implementation for reasons of efficiency.
        return (getLeftTree() == tree) || (getRightTree() == tree);
    }

    /**
     * Check whether this leaf binary tree can have the given
     * trees as its left subtree, respectively as its right subtree.
     * 
     * @return True if this non-empty binary tree can have the given
     *         left tree as its left subtree and the given right tree
     *         as its right subtree; false otherwise.
     *       | result ==
     *       |   canHaveAsLeftTree(left) && canHaveAsRightTree(right)
     */
    @Override
    protected boolean canHaveAsSubTrees(BinaryTree left, BinaryTree right) {
        return super.canHaveAsSubTrees(left, right);
    }

}