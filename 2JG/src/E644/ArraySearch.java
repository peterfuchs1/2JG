package E644;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class ArraySearch {
	/*minimum value*/
	public final static int MIN=1;
	/*maximum value*/
	public final static int MAX=1200;
	/*standard size of the array*/ 
	public final static int LIMIT =100;
	/*array*/
	int[] feld;
	/**
	 * create a new instance of ArraySearch
	 * use the value of ArraySearch.LIMIT as the   
	 * create int-array with random values
	 */
	public ArraySearch() {
		this(LIMIT);
	}
	/**
	 * create a new instance of ArraySearch
	 * use the size to create int-array with random values
	 * @param size of the array
	 */
	public ArraySearch(int size) {
		this(size,false);
	}
	
	/**
	 * @return the feld
	 */
	public int[] getFeld() {
		return feld;
	}
	/**
	 * create a new instance of ArraySearch
	 * use the size to create int-array with random values
	 * @param size of the array
	 * @param sorted should we sort the array?
	 */
	public ArraySearch(int size, boolean sorted) {
	    Random random = new Random();
		IntStream intStream = random.ints(MIN, MAX);
		feld =  intStream.limit(size+1) // Limit amount of elements
		                                    .toArray();
		if(sorted)
			Arrays.sort(feld);
	}
	/**
	 * use the linear search to find a element in a given array 
	 * @param array
	 * @param z element to find 
	 * @return index of searched element or 
	 * -1 if we could not find the element
	 */
	public static int linearSearch(int[] array, int z) {
		int ret=-1;
		for(int i=0;i<array.length;++i) {
			if(array[i]==z) {
				ret=i;
				break;
			}
		}
		return ret;
	}
	/**
	 * verify whether a given array is sorted or not
	 * @param array
	 * @return sorted
	 */
	public static boolean isSorted(int[] array) {
		boolean ret=true;
		for(int i=1;i<array.length;++i) {
			if(array[i-1]>array[i]) {
				ret=false;
				break;
			}
		}
		return ret;
	}
	/**
	 * search for minimum in given array 
	 * @param array
	 * @return index of minimum
	 */
	public static int searchMin(int[] array) {
		return ArraySearch.searchMin(array, 0, array.length-1);
	}
	/**
	 * search for minimum in given array 
	 * @param array
	 * @param min minimum index
	 * @param max maximum index
	 * @return index of minimum
	 */
	public static int searchMin(int[] array, int min, int max) {
		int minimum=array[min];
		int ret=min;
		for(int i=min+1;i<max;++i) {
			if(array[i]<minimum) {
				ret=i;
				minimum=array[i];
			}
		}
		return ret;
	}
	/**
	 * search for maximum in given array 
	 * @param array
	 * @return index of maximum
	 */
	public static int searchMax(int[] array) {
		return ArraySearch.searchMax(array, 0, array.length-1);
	}
	/**
	 * search for maximum in given array
	 * @param array
	 * @param min minimum index
	 * @param max maximum index
	 * @return index of maximum
	 */
	public static int searchMax(int[] array, int min, int max) {
		int maximum=array[min];
		int ret=min;
		for(int i=min+1;i<max;++i) {
			if(array[i]>maximum) {
				ret=i;
				maximum=array[i];
			}
		}
		return ret;
	}
	/**
	 * use the binary search to find a element in a given array 
	 * @param array
	 * @param key element to find 
	 * @return index of searched element or 
	 * -1 if we could not find the element
	 */
	public static int binarySearch(int[] array, int key) {
		int low=0;
		int high=array.length-1;
		int index = -1;
	     
	    while (low <= high) {
	        int mid = (low + high) / 2;
	        if (array[mid] < key) {
	            low = mid + 1;
	        } else if (array[mid] > key) {
	            high = mid - 1;
	        } else if (array[mid] == key) {
	            index = mid;
	            break;
	        }
	    }
	    return index;
	}
	public static void main(String[] args) {
		ArraySearch as =new ArraySearch();
		int array[]=as.getFeld();
		System.out.println(ArraySearch.isSorted(array));
		System.out.println("max= "+ArraySearch.searchMax(array)+
				"; min= "+ArraySearch.searchMin(array));
		int z=10;
		System.out.println("Suche "+z+": "
		+ArraySearch.linearSearch(array, z));
		as =new ArraySearch(50,true);
		array=as.getFeld();
		System.out.println(ArraySearch.isSorted(array));
		System.out.println("max= "+ArraySearch.searchMax(array)+
				"; min= "+ArraySearch.searchMin(array));
		z=10;
		System.out.println("Suche "+z+": "
		+ArraySearch.binarySearch(array, z));
		
	}
}
