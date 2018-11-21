package sortingClasses;

import java.util.LinkedList;

public class MergeSort {
	
	/**
	 * An implementation of the Merge Sort algorithm for an array of Integers
	 * @param arr an array of Integers
	 * @param left the lower bound of the array to consider, 0 if the whole array
	 * @param right the upper bound of the array to consider, size - 1 if the whole array
	 */
	public static void sort(Integer [] arr, int left, int right) {
		if (right - left < 1)	//	the array is 1 element (sorted)
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
		LinkedList<Integer> result = new LinkedList<Integer>();
		Integer lIndex = left, rIndex = middle + 1;
		
		while ( lIndex <= middle && rIndex <= right ) {
			if ( arr[ lIndex ] < arr[ rIndex ] )
				result.add(arr[ lIndex++ ]);
			else
				result.add(arr[ rIndex++ ]);
		}
		
		//	one of these while loops will be entered
		while( lIndex <= middle ) 
			result.add(arr[ lIndex++ ]);
		
		while( rIndex <= right )
			result.add( arr[ rIndex++ ] );
		
		//	finally, edit the original array
		for( Integer i : result )
			arr[ left++ ] = i;
	}

	public static void main(String[] args) {
		Integer [] myArray = { 2, 3, 6, 4, 1, 0, 9, 7, 8, 5};
		sort( myArray, 0, 9 );
		
		System.out.println("");
		for ( Integer in : myArray )
			System.out.print( in + ", ");
	}

}
