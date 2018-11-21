package sortingClasses;

public class SelectionSort {
	
	public static void sort( Integer [] arr ) {
		Integer min;	//	the index of the minimum in the sub-array
		
		for (int i = 0; i < arr.length - 1; ++i) {
			min = i;
			for (int j = i + 1; j < arr.length; ++j) {
				if ( arr[ j ] < arr[ min ])
					min = j;
			}	//	end inner for
			if ( min != i )
				Swap.swap(i, min, arr);
		}	//	end outer for
	}

	public static void main(String[] args) {
		Integer [] myArray = { 2, 3, 6, 4, 1, 0, 9, 7, 8, 5};
		sort( myArray );
		for (int i = 0; i < myArray.length; ++i)
			System.out.print( myArray[ i ] + ", ");
	}

}
