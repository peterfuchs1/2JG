package E644;

import java.time.*;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
/**
 * Compare different sort algorithm
 * @author walter rafeiner-magor
 * @version 2019-01-24
 *
 */
public class ArraySort {
	/* define the number of elements */
	public static int SIZE=300000;
	
	public static void main(String[] args) {

		System.out.println("Vergleich von Sortierverfahren mit "+SIZE+ " Elementen:");
		System.out.println("Test von unsortierten Datenbestaenden!");
		ArraySearch as = new ArraySearch(SIZE);
		int[] array = as.getFeld();
		ArraySort.sort(array);
		System.out.println("Test von sortierten Datenbestaenden!");
		as = new ArraySearch(SIZE,true);
		array = as.getFeld();
		ArraySort.sort(array);
	}
	/**
	 * sort with given array
	 * an print out duration
	 * @param array
	 */
	private static void sort(int[] array) {
		int[] array2=Arrays.copyOf(array, SIZE);
		int[] array3=Arrays.copyOf(array, SIZE);
		System.out.print("Selection sort: ");
		LocalTime l=LocalTime.now();
		// start with selection sort
		ArraySort.selectionSort(array);
		LocalTime l2=LocalTime.now();
		System.out.println(l.until(l2, ChronoUnit.MILLIS)+"ms");
		
		array = array2;
		System.out.print("Bubble sort: ");
		l=LocalTime.now();
		// start with optimized bubble sort
		ArraySort.bubbleSortOpt(array);
		l2=LocalTime.now();
		System.out.println(l.until(l2, ChronoUnit.MILLIS)+"ms");
		
		array = array3;
		System.out.print("Insertion sort: ");
		l=LocalTime.now();
		// start with insertion sort
		ArraySort.insertionSort(array);
		l2=LocalTime.now();
		System.out.println(l.until(l2, ChronoUnit.MILLIS)+"ms");
	}
	/**
	 * use the selection sort algorithm (with search minimum)
	 * @param array
	 * @version 2019-01-24
	 */
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
	/**
	 * use the selection sort algorithm (without search minimum)
	 * @param array
	 * @version 2019-01-24
	 */
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
	 * use the bubble sort algorithm
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
	 * use the insertion sort algorithm 
	 * @param array
	 * @version 2019-01-24
	 */
	public static void insertionSort(int[] array) {
		 int n = array.length; 
	        for (int i=1; i<n; ++i) 
	        { 
	            int key = array[i]; 
	            int j = i-1; 
	  
	            /* Move elements of array[0..i-1], that are 
	               greater than key, to one position ahead 
	               of their current position */
	            while (j>=0 && array[j] > key) 
	            { 
	                array[j+1] = array[j]; 
	                j = j-1; 
	            } 
	            array[j+1] = key; 
	        } 
	}

	/**
	 * use bubble sort with optimized algorithm
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
