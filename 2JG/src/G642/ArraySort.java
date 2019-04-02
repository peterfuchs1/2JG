package G642;

import G641.ArraySearch;

public class ArraySort {

	public static void main(String[] args) {
		ArraySearch as = new ArraySearch();
		int[] array = as.getFeld();
		ArraySort.selectionSortOpt(array);
		System.out.println(ArraySearch.isSorted(array));
		as = new ArraySearch();
		array = as.getFeld();
		ArraySort.bubbleSortOpt(array);
		System.out.println(ArraySearch.isSorted(array));
	}

	public static void selectionSort(int[] array) {
		int n = array.length; // initialise to a's length
		/* advance the position through the entire array */
		/* (could do j < n-1 because single element is also min element) */
		for (int j = 0; j < n - 1; j++) {
			/* find the min element in the unsorted a[j .. n-1] */
			/* assume the min is the first element */
			int iMin = ArraySearch.searchMin(array, j, n - 1);
			/* test against elements after j to find the smallest */
			for (int i = j + 1; i < n; i++) {
				/* if this element is less, then it is the new minimum */
				if (array[i] < array[iMin]) {
					/* found new minimum; remember its index */
					iMin = i;
				}
			}
			if (iMin != j) {
				int temp = array[j];
				array[j] = array[iMin];
				array[iMin] = temp;
			}
		}
	}
	public static void selectionSortOpt(int[] array) {
		int n = array.length; // Anzahl der Elemente
		for (int j = 0; j < n - 1; j++) {
			// Annahme: erstes unsortiertes Element ist das Minimum
			// in diesem Durchlauf
			int iMin = j;
			// Teste alle unsortierten Elemente 
			// Element array[j] ist bereits sortiert!
			for (int i = j + 1; i < n; i++) {
				// Ist das aktuelle Element kleiner als das Minimum?
				if (array[i] < array[iMin]) {
					// Es wurde ein neues Minimum gefunden 
					iMin = i;
				}
			}
			// War das erste Element ein Minimum in diesem Durchlauf? 
			if (iMin != j) {
				// Elemente tauschen!
				int temp = array[j];
				array[j] = array[iMin];
				array[iMin] = temp;
			}
		}
	}
	/**
	 * bubble sort algorithm
	 * @param array
	 */
	public static void bubbleSort(int[] array) {
		int n = array.length - 1;
		for (int j = n; j >=0; --j) {
			for (int i = 0; i < n; ++i) {
				if (array[i] > array[i + 1]) {
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
				}
			}
		}
	}
	/**
	 * bubble sort with optimized algorithm
	 * @param array
	 */
	public static void bubbleSortOpt(int[] array) {
		// Anzahl der Elemente
		int n = array.length - 1;
		// Gab es bei diesem Durchlauf einen Tausch?
		boolean tausch;
		do {
			// In diesem Durchlauf gabe es noch
			// keinen Tausch!
			tausch=false;
			for (int i = 0; i < n; ++i) {
				// Wenn das naechste Element groesser ist
				if (array[i] > array[i + 1]) {
					// Muessen die Elemente getauscht werden
					int temp = array[i];
					array[i] = array[i + 1];
					array[i + 1] = temp;
					// Es gab in diesem Durchlauf einen Tausch 
					tausch=true;
				}
			}
			// Letzte Position ist bereits ok
			n--;
			// Falls es einen Tausch gab -> wiederholen!
		} while (tausch); 
	}

}
