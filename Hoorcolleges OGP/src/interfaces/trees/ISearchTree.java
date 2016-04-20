package interfaces.trees;

import interfaces.trees.exceptions.IllegalElementException;

public interface ISearchTree extends IBinaryTree {

	/**
	 * Check whether this binary tree can have occurrences of the given
	 * element.
	 * 
	 * @param  element
	 *         The element to check.
	 * @return	
	 * 			| if (! (element instanceof Comparable))
	 * 			| then result == false
	 */
	@Override
	boolean canHaveAsElement(Object element);

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
	NonEmptyBinaryTree addElement(Object element) throws IllegalElementException;

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
	ISearchTree removeElement(Object element) throws IllegalElementException;
}
