package pqueue;

public interface PriorityQueue<E> {
	/**
	 * Returns the number of items in the priority queue.
	 *
	 * @return number of items
	 */
	int size();
	/**
	 * Tests whether the priority queue is empty.
	 *
	 * @return true if the priority queue is empty, false otherwise
	 */
	boolean isEmpty();
	/**
	 * Inserts a value
	 *
	 * @param value the associated value of the new entry
	 */
	 void insert(E value);
	/**
	 * Returns (but does not remove) an entry with minimal key.
	 *
	 * @return entry having a minimal value (or null if empty)
	 */
	 E min();
	/**
	 * Removes and returns an entry with minimal key.
	 *
	 * @return the removed entry (or null if empty)
	 */
	 E removeMin();
}
