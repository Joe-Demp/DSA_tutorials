package sortingClasses;

public class BubbleSort {
	
	public static void sort(Integer [] arr) {
//		i represents the upper bound for each run of the inner loop
		for ( int i = arr.length; i > 0; --i) {
			for ( int j = 0; j < i - 1; ++j ) {
				if ( arr[ j ] > arr[ j + 1 ] )
					swap( j, j + 1, arr);
			}
		}
	}
	
	private static void swap(int x, int y, Integer [] arr) {
		Integer tmp = arr[ x ];
		arr[ x ] = arr[ y ];
		arr[ y ] = tmp;
	}

	public static void main(String[] args) {
		Integer [] myArray = { 2, 3, 6, 4, 1, 0, 9, 7, 8, 5};
		sort( myArray );
		for (int i = 0; i < myArray.length; ++i)
			System.out.print( myArray[ i ] + ", ");
	}

}
