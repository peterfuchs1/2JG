package G641;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class ArraySearch {
	public final static int MIN=1;
	public final static int MAX=1200;
	public final static int LIMIT =100;
	int[] feld;
	public ArraySearch() {
		this(LIMIT);
	}
	public ArraySearch(int size) {
		this(size,false);
	}
	
	/**
	 * @return the feld
	 */
	public int[] getFeld() {
		return feld;
	}
	public ArraySearch(int size, boolean sorted) {
	    Random random = new Random();
		IntStream intStream = random.ints(MIN, MAX);
		feld =  intStream.limit(size+1) // Limit amount of elements
		                                    .toArray();
		if(sorted)
			Arrays.sort(feld);
	}
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
	public static int searchMin(int[] array) {
		return ArraySearch.searchMin(array, 0, array.length-1);
	}
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
	public static int searchMax(int[] array) {
		return ArraySearch.searchMax(array, 0, array.length-1);
	}
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
