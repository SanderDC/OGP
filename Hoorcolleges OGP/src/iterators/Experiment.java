package iterators;

import iterators.trees.*;
import iterators.trees.exceptions.*;

import java.util.*;

public class Experiment {
	
	public static void main(String args[]) {
		externalIteration();
		
		internalIteration();
		
//		experimentIterators();
	}
	
	public static void externalIteration() {
		try {
			// Create a search tree with some elements.
			BinaryTree myTree = new ComposedSearchTree(1,1,2,3,5,8,13,21,34,55);
			
			System.out.println("Enter factor: ");
			Scanner scanner = new Scanner(System.in);
			int factor = scanner.nextInt();
			
			// Compute the sum of the squares of all the Fibonacci numbers in
			// the tree that can be divided by the given factor.
			Integer total = 0;
			Iterator<Object> iter = myTree.iterator();
			while (iter.hasNext()){
				Integer value = (Integer) iter.next();
				if (value%factor == 0)
					total += value*value;
			}
//			for (Object value:myTree){
//				Integer val = (Integer) value;
//				if (val%factor == 0)
//					total += val*val;
//			}
			
			
			System.out.println("Total : " + total);
			scanner.close();
		}
		catch (IllegalElementException exc) {
			// Should not be thrown!
			System.out.println("Problem in constructing search tree!");
		}
		catch (Throwable exc) {
			System.out.println("Unexpected exception during experiment!");
		}
		System.out.println();
	}
	
	public static void internalIteration() {
		try {
			// Create a search tree with some elements.
			BinaryTree myTree = new ComposedSearchTree(1,1,2,3,5,8,13,21,34,55);
			
			System.out.println("Enter factor: ");
			Scanner scanner = new Scanner(System.in);
			final int factor = scanner.nextInt();
			
			// Compute the sum of all the Fibonacci numbers in the tree that can be
			// divided by the given factor.
			Integer total = 0;
			
			System.out.println("Total of odd Fibonacci numbers: " + total);
			scanner.close();
		}
		catch (IllegalElementException exc) {
			// Should not be thrown!
			System.out.println("Problem in constructing search tree!");
		}
		catch (Throwable exc) {
			System.out.println("Unexpected exception during experiment!");
		}
		System.out.println();
	}

	public static void experimentIterators() {
		List<Integer> theList = new ArrayList<Integer>();
		for (int i=1; i<=10; i++)
			theList.add(i*10);
		Iterator<Integer> listIterator = theList.iterator();
		for (int i=1; i<=5; i++)
			System.out.println(listIterator.next());
		theList.add(110);
		try {
			listIterator.next();
		} catch (ConcurrentModificationException exc) {
			System.out.println("Concurrent modification exception thrown!");
		}		
	}

}