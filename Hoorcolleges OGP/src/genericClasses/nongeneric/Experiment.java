package genericClasses.nongeneric;

import java.util.Iterator;

@SuppressWarnings(value="all")
public class Experiment {

	public static void main(String[] args) {
		experimentAddRetrieve();
		experimentToArray();
		experimentPolymorphism();
		experimentGenericSubclasses();
		experimentGenericMethods();
	}

	public static void experimentAddRetrieve() {
//		final int TEN = 10;
//		BoundedArrayList myList = new BoundedArrayList(Number.class, TEN+1);
//		for (long i = 0; i < TEN; i++)
//			myList.add(i);
//		
//		System.out.print("Expected values [0..9]: ");
//		for (int i = 0; i < TEN; i++) {
//			Number currentElement = (Number) myList.get(i);
//			System.out.print(currentElement.longValue() + " ");
//		}
//		System.out.println();
//		
//		try {
//			myList.add(true);
//		}
//		catch (IllegalArgumentException exc) {
//			System.out.println("Expected IllegalArgumentException!");
//		}
	}

	public static void experimentToArray() {
		try {
//			BoundedArrayList<Integer> myElements = new BoundedArrayList<Integer>(8);
//			myElements.add(7);
//			myElements.add(24);
//			Integer[] myIntegers = myElements.toArray();
//			System.out.println("Value at position 1: " + myIntegers[1]);
		}
		catch (Exception exc) {
			System.out.println("Exception thrown of type " + exc.getClass());
		}
	}

	public static void experimentPolymorphism() {

//		try {
//			Integer[] myIntegers = new Integer[8];
//			Object[] myObjects = myIntegers;
//			myObjects[1] = new Boolean(true);
//			Integer first = myIntegers[1];
//			System.out.println(first);
//		}
//		catch (Exception exc) {
//			System.out.println("Exception thrown of type " + exc.getClass());
//		}

		// - Try to assign and manipulate an array list of integers
		//   in polymorphic ways: fixed type.
//		{
//          BoundedArrayList<Integer> myIntegers = new BoundedArrayList<Integer>(8);
//          BoundedArrayList<Object> myObjects = myIntegers;
//			myObjects.add("abc");
//          BoundedArrayList<Object> myObjects2 = (BoundedArrayList<Object>)myIntegers;
//		}

		// - Try to assign and manipulate an array list of integers
		//   in polymorphic ways: unbounded wildcard.
//		{
//			BoundedArrayList<Integer> myIntegers = new BoundedArrayList<Integer>(8);
//	        myIntegers.add(new Integer(12));
//	        BoundedArrayList<?> myThings = myIntegers;
//	        myThings.add(new Integer(10));
//			myThings.add(null);
//	        myThings.remove(new Float(3.4));
//	        Object myValue = myThings.get(0);
//	        System.out.println("Expected value [12]: " + myValue);
//	    }

		// - Try to assign and manipulate an array list of integers
		//   in polymorphic ways: bounded wildcard with upper limit.
//	    {
//	        BoundedArrayList<Integer> myIntegers = new BoundedArrayList<Integer>(8);
//	        myIntegers.add(new Integer(12));
//	        BoundedArrayList<? extends Number> myThings = myIntegers;
//			myThings.add(new Integer(10));
//	        Number myValue = myThings.get(0);
//	        System.out.println("Expected value [12]: " + myValue);
//	    }

		// - Try to assign and manipulate an array list of integers
		//   in polymorphic ways: bounded wildcard with lower limit
//		{
//			BoundedArrayList<Number> myNumbers = new BoundedArrayList<Number>(8);
//		    myNumbers.add(new Integer(12));
//		    BoundedArrayList<? super Integer> myThings = myNumbers;
//		    myThings.add(new Integer(10));
//		    myThings.add(new Float(13.56));
//		    myThings.add(new Object());
//		    Integer myIntValue = myThings.get(0);
//		    Object myValue = myThings.get(1);
//		    System.out.println("Expected value [10]: " + myValue);
//		}
		
		// - Try to assign and manipulate an array list of integers
        //   in polymorphic ways: raw type.
//      {
//          BoundedArrayList<Integer> myIntegers = new BoundedArrayList<Integer>(8);
//          BoundedArrayList myObjects = myIntegers;
//          myObjects.add(new Integer(12));
//          myObjects.add(new Float(2.5));
//          Object myValue = myObjects.get(0);
//          System.out.println("Expected value [12]: " + myValue);
//          try {
//              Integer myInteger = myIntegers.get(1);
//              System.out.println(myInteger);
//          } catch (ClassCastException exc) {
//              System.out.println("Expected ClassCastException!");
//          }
//      }

		// Experiment with polymorphism in binding arguments.
//		{
//          BoundedArrayList<Integer> myIntegers = new BoundedArrayList<Integer>(8);
//          BoundedArrayList<Number> myNumbers = new BoundedArrayList<Number>(12);
//          myNumbers.add(new Long(2));
//          myIntegers.add(new Integer(4));
//          myIntegers.add(new Integer(6));
//          myNumbers.addAll(myIntegers);
//          System.out.println("Expected value [6]: " + myNumbers.get(2));
//		}

	}

	public static void experimentGenericSubclasses() {
		// Adding and retrieving legal elements to an ordered bounded array list.
//		{
//			final int TEN = 10;
//	        OrderedBoundedArrayList<Long> myList = new OrderedBoundedArrayList<Long>(TEN);
//			// Add some elements to the list.
//			for (int i = 0; i < TEN; i++)
//				myList.add(Math.round(Math.random() * 100));
//			// Print the elements of the list.
//			System.out.print("Random numbers in ascending order: ");
//			for (int i = 0; i < TEN; i++) {
//				Number currentElement = (Number) myList.get(i);
//				System.out.print(currentElement.longValue() + " ");
//			}
//			System.out.println();
//		}
		// Polymorphic assignments involving ordered bounded array lists.
//		{
//	        BoundedArrayList<Long> myList;
//	        OrderedBoundedArrayList<Long> myOrderedList = new OrderedBoundedArrayList<Long>(20);
//			myOrderedList.add(new Long(45));
//			myOrderedList.add(new Long(12));
//			// Legal Polymorphic assignment.
//			myList = myOrderedList;
//			myList.add(new Long(25));
//			System.out.println("Expecting [25]: " + myList.get(1));
//		}
		// Attempt to register an illegal element in an ordered bounded array list,
		// via a reference of type bounded array list.
//		try {
//          BoundedArrayList<Long> myList;
//          OrderedBoundedArrayList<Long> myOrderedList = new OrderedBoundedArrayList<Long>(20);
//			// Legal Polymorphic assignment.
//			myList = myOrderedList;
//			myList.add(new String("abc"));
//		}
//		catch (IllegalArgumentException exc) {
//			System.out.println("Expected IllegalArgumentException!");
//		}
	}

	// Determine the type of elements of all result lists.
	public static void experimentGenericMethods() {
//        BoundedArrayList<Integer> intList = new BoundedArrayList<Integer>(10);
//        BoundedArrayList<Number> numberList = new BoundedArrayList<Number>(10);
//        BoundedArrayList resultList1 = BoundedArrayList.copy(intList,numberList);
//        BoundedArrayList<Float> floatList = new BoundedArrayList<Float>(10);
//        BoundedArrayList resultList2 = BoundedArrayList.copy(intList,floatList);
//        BoundedArrayList<String> stringList = new BoundedArrayList<String>(10);
//        BoundedArrayList resultList3 = BoundedArrayList.copy(intList,stringList);
	}

}
