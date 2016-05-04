package genericClasses.nongeneric;

// - Ordered bounded array lists keep their elements sorted
//   from small to big. All elements in ordered bounded array
//   lists must therefore implement the interface Comparable.
// - An alternative is to supply an object of type Comparator
//   at construction time. However, that would not give us
//   opportunities to illustrate strengths and weaknesses of
//   generic classes in Java.
@SuppressWarnings(value="all")
public class OrderedBoundedArrayList extends BoundedArrayList {

	// We must now also check whether the supplied elementType
	// implements the interface Comparable.
	public OrderedBoundedArrayList(Class elementType, int capacity)
			throws IllegalArgumentException {
		super(elementType, capacity);
		if (! (Comparable.class.isAssignableFrom(elementType)))
			throw new IllegalArgumentException();
	}

	// This method is overridden to strengthen its return type.
	public Comparable get(int index) throws IndexOutOfBoundsException {
		return (Comparable) super.get(index);
	}

	// Redefinition to register the element at the proper place.
	public void add(Object element) throws IllegalStateException,
			IllegalArgumentException {
		if (this.size == elements.length)
			throw new IllegalStateException();
		if (!this.elementType.isAssignableFrom(element.getClass()))
			throw new IllegalArgumentException();
		Comparable newElement = (Comparable) element;
		int pos = this.size - 1;
		while ((pos >= 0) && (get(pos).compareTo(newElement) == 1))
			elements[pos + 1] = get(pos--);
		elements[pos + 1] = element;
		this.size = this.size + 1;
	}
}
