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
public abstract class BinaryTree implements IBinaryTree {

}