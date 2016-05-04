package genericClasses.nongeneric;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

//@SuppressWarnings(value="all")
public class BoundedArrayList<T> implements Iterable<T> {

	protected int size;
	protected final Object[] elements;

	public void add(T element) throws IllegalStateException{
		if (this.size == elements.length)
			throw new IllegalStateException();
		elements[this.size++] = element;
	}

	public void remove(T element) {
		int index = 0;
		while ((index < this.size) && (get(index) != element))
			index++;
		if (index < this.size) {
			this.size--;
			for (int i = index; i < this.size; i++)
				elements[i] = elements[i + 1];
		}
	}
	
	public T get(int index) throws IndexOutOfBoundsException {
		if (index >= this.size)
			throw new IndexOutOfBoundsException();
		return (T) elements[index];
	}

	public boolean contains(T element) {
		for (int i = 0; i < this.size; i++) {
			Object currentElement = get(i);
			if ((currentElement == null) && (element == null))
				return true;
			if ((currentElement != null) && currentElement.equals(element))
				return true;
		}
		return false;
	}

	public BoundedArrayList(int capacity){
		this.elements = (T[]) new Object[Math.abs(capacity)];
		this.size = 0;
	}

    public Object[] toArray() {
    	return Arrays.copyOf(elements, size);
	}

    public Iterator<T> iterator() {
        return new Iterator<T>() {

            public boolean hasNext() {
                return pos < size;
            }

            public T next() throws NoSuchElementException {
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

    public void addAll(BoundedArrayList<? extends T> others) throws IllegalStateException,
            IllegalArgumentException {
        if (others != null) {
            if (this.size + others.size > elements.length)
                throw new IllegalStateException();
            for (T elem : others)
                add(elem);
        }
    }

	public static <E> BoundedArrayList<E> copy(BoundedArrayList<? extends E> source1,
			BoundedArrayList<? extends E> source2) throws IllegalArgumentException,
			IllegalStateException {
		// We cannot compute the least common supertype of both lists
		// in an easy way. We therefore opt for Object.
		int capacity = source1.elements.length + source2.elements.length;
		BoundedArrayList<E> resultList = new BoundedArrayList<E>(capacity);
		resultList.addAll(source1);
		resultList.addAll(source2);
		return resultList;
	}

}
