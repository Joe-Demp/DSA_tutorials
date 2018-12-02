package pqueue;

import java.util.Comparator;
import java.util.LinkedList;

public class ListPriorityQueue<E> implements PriorityQueue<E> {
	private int size = 0;
	private LinkedList<E> queue;
	private Comparator<E> comp;
	
	public class DefaultComparator<E> implements Comparator<E> {
		public int compare(E a, E b) throws ClassCastException {
			return ((Comparable<E>)a).compareTo(b);
		}
	}
	
	public ListPriorityQueue() {
		queue = new LinkedList<E>();
		comp = new DefaultComparator<E>();
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {return queue.isEmpty();}

	@Override
	public void insert(E value) {queue.add(value);}

	@Override
	public E min() {
		if (!queue.isEmpty()) {
			E minValue = queue.getFirst();
			
			for (E e : queue) {
				if (comp.compare(e, minValue) < 0)	//	if e is smaller than the current minValue
					minValue = e;
			}
			return minValue;
		}//	endif
		return null;
	}

	@Override
	public E removeMin() {
		E minValue = min();
		
		if (queue.remove(minValue)) return minValue;
		else return null;
	}

	public static void main(String[] args) {
		ListPriorityQueue<Character> charQueue = new ListPriorityQueue<Character>();
		
		charQueue.insert('a');
		charQueue.insert('b');
		charQueue.insert('c');
		charQueue.insert('d');
		charQueue.insert('e');
		charQueue.insert('f');
		charQueue.insert('g');
		charQueue.insert('h');
		charQueue.insert('i');
		charQueue.insert('j');
		charQueue.insert('A');
		
		System.out.println("min value = " + charQueue.min());
		while (!charQueue.isEmpty()) {
			System.out.println("min removed : " + charQueue.removeMin());
		}
	}

}
