package interfaces.trees;

import be.kuleuven.cs.som.annotate.*;
import interfaces.trees.exceptions.*;

/**
 * An class of binary trees for storing objects.
 *		A binary tree may contain several occurrences of the same object.
 *		The position of the objects in a binary tree is not explicitated.
 * 
 * @invar   Each binary tree must can have the number of occurrences of
 *          each object (including the null reference) in that tree as
 *          the number of occurrences of that object in that tree.
 *        | for each element in (Object union {null}):
 *        |   canHaveAsNbOccursOfElement
 *        |       (getNbOccurrences(element),element)
 * 
 * @version  2.0
 * @author   Eric Steegmans
 */
public abstract class BinaryTree {

	/**
	 * Initialize this new binary tree with no elements.
	 * 
	 * @post   This new binary tree has no elements.
	 *       | new.getNbElements() == 0
	 * @note   This constructor is needed in some of the subclasses that
	 * 		   need a constructor not throwing any exceptions.
	 */
	@Raw
	protected BinaryTree() {
	}

	/**
	 * Return the number of occurrences of the given element in this binary tree.
	 *
	 * @param  element
	 *		   The element whose number of occurrences must be computed.
	 */
	@Basic @Raw
	public abstract int getNbOccurrencesOf(Object element);

	/**
	 * Check whether this binary tree can have occurrences of the given
	 * element.
	 * 
	 * @param  element
	 *         The element to check.
	 */
	@Raw
	public abstract boolean canHaveAsElement(Object element);

	/**
	 * Check whether this binary tree can have the given number of occurrences
	 * of the given element as the number of occurrences of that element in it.
	 * 
	 * @param  nbOccurrences
	 *         The number of occurrences to check.
	 * @param  element
	 *         The element to check.
     * @return True if the given number of occurrences is zero.
     *       | if (nbOccurrences == 0)
     *       |   then result == true
	 * @return False if the given number of occurrences is negative.
	 *       | if (nbOccurrences < 0)
	 *       |   then result == false
	 * @return False if the given number of occurrences is positive and if
	 *         this binary tree cannot have occurrences of the
	 *         given element.
	 *       | if ( (nbOccurrences > 0) && (! canHaveAsElement(element)))
	 *       |   then result == false
	 */
	@Raw
	public boolean canHaveAsNbOccursOfElement(int nbOccurrences, Object element) {
		return (nbOccurrences == 0)
				|| ((nbOccurrences > 0) && canHaveAsElement(element));
	}

	/**
	 * Check whether this binary tree has the given element as one of
	 * its elements.
	 *
	 * @param  element
	 *         The element to be checked.
	 * @return True if the number of occurrences of the given element
	 *         in this binary tree is positive; false otherwise.
	 *       | result == (getNbOccurencesOf(element) > 0)
	 */
	public boolean hasAsElement(Object element) {
		return (getNbOccurrencesOf(element) > 0);
	}

	/**
	 * Return the total number of elements in this binary tree.
	 *
	 * @return The total number of occurrences of all elements (the null
	 *         reference included) in this binary tree.
	 *       | result ==
	 *       |   sum( { object in (Object union {null}):
	 *       |       getNbOccurrencesOf(element) } )
	 */
	@Raw
	public abstract int getNbElements();

	/**
	 * Check whether this binary tree has no elements.
	 *
	 * @return True if this binary tree has no elements; false otherwise.
	 *       | result == (getNbElements() == 0)
	 */
	public boolean isEmpty() {
		return (getNbElements() == 0);
	}

	/**
	 * Add the given element to this binary tree.
	 *
	 * @param  element
	 *         The element to be added.
	 * @post   If this binary tree is returned as a result, the given
	 *         element is added to this binary tree. Otherwise, the
	 *         state of this binary tree is left untouched.
	 *       | if (result == this)
	 *       |   then (new.getNbOccurrencesOf(element) ==
	 *       |        getNbOccurencesOf(element) + 1)
	 * @return Except for the element to be added, the number of occurrences
	 *         of all elements in the resulting tree is equal to the number
	 *         of occurrences of those elements in this binary tree.
	 *       | for each object in (Object union {null}):
	 *       |   if (object != element)
	 *       |     then (result.getNbOccurrences(object) ==
	 *       |               this.getNbOccurrences(object))
	 * @return The number of occurrences of the given element in the
	 *         resulting tree is one higher than the number of occurrences
	 *         of that element in this binary tree (upon entry).
	 *       | result.getNbOccurrencesOf(element) ==
	 *       |     this.getNbOccurencesOf(element) + 1
	 * @throws IllegalElementException
	 *         This binary tree cannot have any occurrences of the
	 *         given element.
	 *       | ! canHaveElement(element)
	 */
	public abstract BinaryTree addElement(Object element)
			throws IllegalElementException;

	/**
	 * Remove one occurrence of the given element from this binary tree.
	 *
	 * @param  element
	 *         The element for which one occurrence must be removed.
	 * @post   If this binary tree is returned as a result, the number of
	 *         occurrences of the given element in this binary tree is one
	 *         less than its number of occurrences upon entry. Otherwise,
	 *         the state of this binary tree is left untouched.
	 *       | if (result == this)
	 *       |   then (new.getNbOccurrencesOf(element) ==
	 *       |             getNbOccurencesOf(element) - 1)
	 * @return Except for the element to be removed, the number of occurrences
	 *         of all elements in the resulting tree is equal to their number
	 *         of occurrences in this binary tree.
	 *       | for each object in (Object union {null}):
	 *       |   if (object != element) then
	 *       |     then (result.getNbOccurrences(object) ==
	 *       |               this.getNbOccurrences(object))
	 * @return The number of occurrences of the given element in the resulting
	 *         tree is one lower than the number of occurrences of that element
	 *         in this binary tree (upon entry).
	 *       | result.getNbOccurrencesOf(element) ==
	 *       |     this.getNbOccurencesOf(element) - 1
	 * @throws IllegalElementException
	 *         This binary tree does not have the given element as one of its
	 *         elements.
	 *       | ! hasAsElement(element)
	 */
	public abstract BinaryTree removeElement(Object element)
			throws IllegalElementException;

	/**
	 * Check whether this binary tree has the given tree as a direct or
	 * indirect subtree.
	 * 
	 * @param  tree
	 *         The tree to check.
	 * @return False if the given tree is not effective.
	 *       | if (tree == null)
	 *       |   then result == false
	 */
	protected abstract boolean hasAsSubTree(BinaryTree tree);

}