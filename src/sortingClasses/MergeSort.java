package sortingClasses;

public class MergeSort {
	
	/**
	 * An implementation of the Merge Sort algorithm for an array of Integers
	 * @param arr an array of Integers
	 * @param left the lower bound of the array to consider
	 * @param right the upper bound of the array to consider
	 */
	public static void sort(Integer [] arr, int left, int right) {
		if (right - left <= 1)	//	the array has 1 or no elements (sorted)
			return;
		else {
			//	define new boundaries for the next sorts
			int middle = (right + left) / 2;
			sort( arr, left, middle);
			sort( arr, middle + 1, right);
			merge( arr, left, middle, right );
		}
	}
	
	private static void merge(Integer [] arr, int left, int middle, int right) {
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
