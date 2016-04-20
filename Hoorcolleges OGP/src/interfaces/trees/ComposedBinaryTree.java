package interfaces.trees;

import be.kuleuven.cs.som.annotate.Basic;
import be.kuleuven.cs.som.annotate.Raw;
import interfaces.trees.exceptions.*;

/**
 * A class of composed binary trees.
 *		A composed binary tree consists of a root node in which a single
 *		element is stored, complemented with a left subtree and a right
 *		subtree, of which at least one is not empty.
 *
 * @invar   Each composed binary tree has at least two occurrences of
 *          a single object or at least one occurrence of two different
 *          objects.
 *          | getNbElements() >= 2
 *
 * @version 2.0
 * @author  Eric Steegmans
 */
public class ComposedBinaryTree extends NonEmptyBinaryTree {

    /**
     * Initialize this new composed binary tree with given elements.
     *
     * @param  elements
     *         The elements to be stored in this new composed
     *         binary tree.
     * @post   The number of occurrences of each object (including the null
     *         reference) in this new composed binary tree is equal
     *         to the number of occurrences of that element in the given
     *         array of elements.
     *       | for each element in (Object union {null}):
     *       |   (new.getNbOccurrencesOf(element) ==
     *       |        ExtArray.getNbOcurrencesOf(elements,element))
     * @throws IllegalArgumentException
     *         The given array of elements does not have at least 2 elements.
     *       | elements.length < 2
     * @throws IllegalElementException
     *         This new composed binary tree cannot have at least one element
     *         of the given array as one of its elements.
     *       | for some element in elements:
     *       |   (! canHaveAsElement(element))
     * @note   We assume a definition of a static inspector getNbOccurrencesOf
     *         returning the number of occurrences of a given object in a given
     *         array.
     */
	@Raw
    public ComposedBinaryTree(Object... elements)
            throws IllegalArgumentException, IllegalElementException {
        if (elements.length < 2)
            throw new IllegalArgumentException();
        // Register the element in the middle of the given array as
        // the root of this new unsorted composed binary tree.
        int middleIndex = elements.length / 2;
        setRootElement(elements[middleIndex]);
        // Register all elements before the middle index in the left
        // subtree of this new unsorted composed binary tree.
        setLeftTree(EmptyBinaryTree.getPrototype());
        for (int i = 0; i < middleIndex; i++)
            setLeftTree(getLeftTree().addElement(elements[i]));
        // Register all elements after the middle index in the right
        // subtree of this new unsorted composed binary tree.
        setRightTree(EmptyBinaryTree.getPrototype());
        for (int i = middleIndex + 1; i < elements.length; i++)
            setRightTree(getRightTree().addElement(elements[i]));
    }

    /**
     * Initialize this new composed binary tree with the null reference as
     * its root element.
     * 
     * @effect This new composed binary tree is initialized as a non-empty
     *         binary tree with the null reference as its root element.
     *       | super()
     * @note   This constructor is needed in some of the subclasses that
     *         need a constructor not throwing any exceptions.
     */
    @Raw
    protected ComposedBinaryTree() {
    }
    
	/**
	 * Return the number of occurrences of the given element in this
	 * composed binary tree.
	 */
	@Override
	@Basic
	public int getNbOccurrencesOf(Object element) {
		return -1;
	}

    /**
     * Check whether this composed binary tree can have occurrences
     * of the given element.
     */
    @Override
    public boolean canHaveAsElement(Object element) {
        return true;
    }

	/**
	 * Check whether this composed binary tree can have the given number
	 * of occurrences of the given element as the number of occurrences
	 * of that element in it.
	 * 
	 * @return True if and only if the given number of occurrences is zero
	 *         or if the given number of occurrences is positive and this
	 *         composed binary tree can have the given element as its element,
	 *         and the total number of elements in this composed binary tree
	 *         decremented with the number of occurrences of the given element
	 *         in this composed binary tree and incremented with the given
	 *         number of occurrences is above 1.
	 *       | result ==
	 *       |   ( (nbOccurrences == 0) ||
	 *       |   ( (nbOccurrences > 0) && canHaveAsElement(element) )
	 */
	@Raw
	@Override
	public boolean canHaveAsNbOccursOfElement(int nbOccurrences,
			Object element) {
		return ((nbOccurrences == 0) || ((nbOccurrences > 0) && canHaveAsElement(element)));
	}

    /**
     * Add the given element to this composed binary tree.
     */
    @Override
    public ComposedBinaryTree addElement(Object element)
            throws IllegalElementException {
        return null;
    }

    /**
     * Remove one occurrence of the given element from this composed
     * binary tree.
     *
     * @return This tree is returned if that tree stores more than 2 elements.
     *      | if (getNbElements() > 2)
     *      |   then result == this
     * @return A binary leaf tree is returned if this composed binary tree
     *         only has 2 elements.
     *      | if (getNbElements() == 2)
     *      |   then result instanceof LeafBinaryTree
     */
    @Override
    public NonEmptyBinaryTree removeElement(Object element)
            throws IllegalElementException {
        if ((getRootElement() == null) && (element == null))
            return removeRootElement();
        if ((getRootElement() != null) && getRootElement().equals(element))
            return removeRootElement();
        try {
            setLeftTree(getLeftTree().removeElement(element));
        }
        catch (IllegalElementException exc) {
            assert !getLeftTree().hasAsElement(element);
            setRightTree(getRightTree().removeElement(element));
        }
        return changeToLeafTree();
    }

    /**
     * Remove the element stored in the root of this composed binary tree.
     *
     * @return A binary leaf tree, if this unsorted composed binary tree
     *         only has 2 elements; otherwise, this composed binary tree.
     *      | if (getNbElements() == 2)
     *      |   then result instanceof LeafBinaryTree
     *      |   else result == this
     */
    @Override
    protected NonEmptyBinaryTree removeRootElement() {
        if (getLeftTree() instanceof NonEmptyBinaryTree) {
            NonEmptyBinaryTree leftTree = (NonEmptyBinaryTree) getLeftTree();
            setRootElement(leftTree.getRootElement());
            setLeftTree(leftTree.removeRootElement());
            return changeToLeafTree();
        }
        else
            return (NonEmptyBinaryTree) getRightTree();
    }

    /**
     * Return the left subtree of this composed binary tree.
     */
    @Override
    protected BinaryTree getLeftTree() {
        return leftTree;
    }

    /**
     * Set the left subtree of this composed binary tree to the given tree.
     * @param  leftTree
     *         The new left subtree for this composed binary tree.
     * @pre    This composed binary tree must can have the given tree as
     *         its left subtree.
	 *      | canHaveAsLeftTree(leftTree)
	 * @post  The left subtree of this composed binary tree is the same
	 *        as the given tree.
	 *      | new.getLeftTree() == leftTree
	 */
	protected final void setLeftTree(BinaryTree leftTree) {
		assert canHaveAsLeftTree(leftTree);
		this.leftTree = leftTree;
	}

    /**
     * Variable referencing the left subtree of this composed binary tree.
     */
    private BinaryTree leftTree;

    /**
     * Return the right subtree of this composed binary tree.
     */
    @Override
    protected BinaryTree getRightTree() {
        return rightTree;
    }

    /**
     * Set the right subtree of this composed binary tree to the given tree.
     * @param  rightTree
     *         The new right subtree for this composed binary tree.
     * @pre    This composed binary tree must can have the given tree as
     *         its right subtree.
     *       | canHaveAsRightTree(rightTree)
     * @post   The right subtree of this composed binary tree is the same
     *         as the given tree.
     *       | new.getRightTree() == rightTree
     */
    protected final void setRightTree(BinaryTree rightTree) {
		assert canHaveAsRightTree(rightTree);
        this.rightTree = rightTree;
    }

    /**
     * Variable referencing the right subtree of this composed binary tree.
     */
    private BinaryTree rightTree;

    /**
     * Check whether this composed binary tree can have the given
     * trees as its left subtree, respectively as its right subtree.
     * 
     * @return False if the given left tree and the given right
     *         tree are both empty trees.
     *       | if ( (left instanceof EmptyBinaryTree) &&
     *       |      (right instanceof EmptyBinaryTree) )
     *       |   then result == false
     */
    @Override
    protected boolean canHaveAsSubTrees(BinaryTree left, BinaryTree right) {
        return super.canHaveAsSubTrees(left, right)
            && ((!(left instanceof EmptyBinaryTree)) || (!(right instanceof EmptyBinaryTree)));
    }

    /**
     * Change this composed binary into a binary leaf tree, if it only has
     * one element.
     *
     * @return A new binary leaf tree, if this composed binary tree has a
     *		   single element; this tree otherwise.
     *		 | if (getNbElements() == 1)
     *		 |   then result instanceof LeafBinaryTree
     *		 |   else result == this
     * @return The resulting tree has the same elements as this composed
     *		   binary tree.
     *		 | for each object in (Object union {null}):
     *		 |   result.getNbOccurencesOf(object) ==
     *		 |       this.getNbOccurrencesOf(object)
     */
    protected NonEmptyBinaryTree changeToLeafTree() {
        try {
            if (getLeftTree().isEmpty() && getRightTree().isEmpty())
                return new LeafBinaryTree(getRootElement());
            else
                return this;
        }
        catch (IllegalElementException exc) {
            assert false;
            return null;
        }
    }

}