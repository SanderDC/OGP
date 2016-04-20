package interfaces.trees;

import be.kuleuven.cs.som.annotate.Basic;
import interfaces.trees.exceptions.IllegalElementException;

public class ComposedSearchTree extends ComposedBinaryTree implements ISearchTree {
	
	/**
	 * Return the number of occurrences of the given element in this
	 * composed binary tree.
	 */
	@Override
	public int getNbOccurrencesOf(Object element) {
		int nbOccs = super.getNbOccurrencesOf(element);
		if (((Comparable)getRootElement()).compareTo(element) >= 0)
			nbOccs += getLeftTree().getNbOccurrencesOf(element);
		else
			nbOccs += getRightTree().getNbOccurrencesOf(element);
		return nbOccs;
	}

	@Override
	public ISearchTree removeElement(Object element) throws IllegalElementException {
		// TODO Auto-generated method stub
		return null;
	}

}
