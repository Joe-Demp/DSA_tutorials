package sortingClasses;

public class Swap {
	protected static void swap(int x, int y, Integer [] arr) {
		Integer tmp = arr[ x ];
		arr[ x ] = arr[ y ];
		arr[ y ] = tmp;
	}
}
