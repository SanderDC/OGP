package genericClasses.nongeneric;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

@SuppressWarnings(value="all")
public class BoundedArrayList implements Iterable {

	protected int size;
	protected final Object[] elements;
	protected final Class elementType;

	public void add(Object element) throws IllegalStateException,
			IllegalArgumentException {
		if (this.size == elements.length)
			throw new IllegalStateException();
		if ((element != null)
			&& (!this.elementType.isAssignableFrom(element.getClass())))
			throw new IllegalArgumentException();
		elements[this.size++] = element;
	}

	public void remove(Object element) {
		int index = 0;
		while ((index < this.size) && (get(index) != element))
			index++;
		if (index < this.size) {
			this.size--;
			for (int i = index; i < this.size; i++)
				elements[i] = elements[i + 1];
		}
	}
	
	public Object get(int index) throws IndexOutOfBoundsException {
		if (index >= this.size)
			throw new IndexOutOfBoundsException();
		return elements[index];
	}

	public boolean contains(Object element) {
		for (int i = 0; i < this.size; i++) {
			Object currentElement = get(i);
			if ((currentElement == null) && (element == null))
				return true;
			if ((currentElement != null) && currentElement.equals(element))
				return true;
		}
		return false;
	}

	public BoundedArrayList(Class elementType, int capacity)
			throws IllegalArgumentException {
		if (elementType == null)
			throw new IllegalArgumentException();
		this.elements = new Object[Math.abs(capacity)];
		this.size = 0;
		this.elementType = elementType;
	}

    public Object[] toArray() {
    	return Arrays.copyOf(elements, size);
	}

    public Iterator iterator() {
        return new Iterator() {

            public boolean hasNext() {
                return pos < size;
            }

            public Object next() throws NoSuchElementException {
                if (!hasNext())
                    throw new NoSuchElementException();
                return get(pos++);
            }

            public void remove() throws UnsupportedOperationException {
                throw new UnsupportedOperationException();
            }

            private int pos = 0;

        };
    }

    public void addAll(BoundedArrayList others) throws IllegalStateException,
            IllegalArgumentException {
        if (others != null) {
            if (this.size + others.size > elements.length)
                throw new IllegalStateException();
            for (Object elem : elements)
                if (!this.elementType.isAssignableFrom(elem.getClass()))
                    throw new IllegalArgumentException();
            for (Object elem : others)
                add(elem);
        }
    }

//	public static BoundedArrayList copy(BoundedArrayList source1,
//			BoundedArrayList source2) throws IllegalArgumentException,
//			IllegalStateException {
//		// We cannot compute the least common supertype of both lists
//		// in an easy way. We therefore opt for Object.
//		int capacity = source1.elements.length + source2.elements.length;
//		BoundedArrayList resultList = new BoundedArrayList(Object.class,
//			capacity);
//		resultList.addAll(source1);
//		resultList.addAll(source2);
//		return resultList;
//	}

}
