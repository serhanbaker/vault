/*
 * #### Array List ####
 * Time Complexity, indexing: O(1), search: O(n), insertion: O(n), deletion: O(n)
 *
 * Space Complexity: O(n)
 *
 * */

public class ArrayList<Type> implements Iterable<Type> {
	private static final int DEFAULT_CAPACITY = 10;
	private Type[] items;
	private int size;

	public ArrayList() {
		clear();
	}

	public void clear() {
		size = 0;
		ensureCapacity(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public void ensureCapacity(int newCapacity) {
		if (newCapacity < size)
			return;
		Type[] old = items;
		items = (Type[]) new Object[newCapacity];
		for (int i = 0; i < size; i++)
			items[i] = old[i];
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void append(Type x) {
		add(size(), x);
	}

	public void add(int idx, Type x) {
		if (items.length == size())
			ensureCapacity(size() * 2 + 1);
		for (int i = size; i > idx; i--)
			items[i] = items[i - 1];
		items[idx] = x;
		size++;
	}

	public void remove(int idx) {
		for (int i = idx; i < size() - 1; i++)
			items[i] = items[i + 1];
		size--;
	}

	public Type get(int idx) {
		if (idx < 0 || idx >= size())
			throw new ArrayIndexOutOfBoundsException("Index: " + idx
					+ ", Size: " + size());
		return items[idx];
	}

	public void set(int idx, Type newVal) {
		if (idx < 0 || idx >= size())
			throw new ArrayIndexOutOfBoundsException("Index: " + idx
					+ ", Size: " + size());
		items[idx] = newVal;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer("[ ");
		for (Type x : this) {
			sb.append(x);
			sb.append(" ");
		}
		sb.append("]");
		return new String(sb);
	}

	public java.util.Iterator<Type> iterator() {
		return new ArrayListIterator();
	}

	private class ArrayListIterator implements java.util.Iterator<Type> {
		private int current = 0;
		private boolean okToRemove = false;

		public boolean hasNext() {
			return current < size();
		}

		public Type next() {
			if (!hasNext())
				throw new java.util.NoSuchElementException();

			okToRemove = true;
			return items[current++];
		}

		public void remove() {
			if (!okToRemove)
				throw new IllegalStateException();

			ArrayList.this.remove(--current);
			okToRemove = false;
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.append(1);
		numbers.append(6);
		numbers.append(3);
		numbers.append(7);
		numbers.append(5);
		System.out.println(numbers.toString());
		numbers.add(2, 11);
		System.out.println(numbers.toString());
		numbers.remove(4);
		System.out.println(numbers.toString());
	}

}
