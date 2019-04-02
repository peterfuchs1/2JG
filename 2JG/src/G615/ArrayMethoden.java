package G615;

import java.util.Random;

public class ArrayMethoden {

	public static int[] zufallsArray(int stellen) {
		Random r=new Random();
		return r.ints(stellen, 0, stellen*2+1).toArray();
	}
	public static String arrayToText(int[] a) {
		StringBuilder s=new StringBuilder();
		for (int i=0;i<a.length;++i) {
			s.append(a[i]);
			if(i<a.length-1)
				s.append(" ,");
		}
		return s.toString();
	}
	public static void fillArray(int[] a, int zahl) {
		for (int i=0;i<a.length;++i) {
			a[i]=zahl;
		}
	}
	public static void fillZufallArray(int[] a, int von, int bis) {
		Random r=new Random();
		if  (ArrayMethoden.testIndex(a,von)&&ArrayMethoden.testIndex(a,bis)&&(bis>=von)) {
					for (int i=von;i<=bis;++i) {
						a[i]=r.nextInt();
					}
					return;
		}
		throw new RuntimeException("Indizes von:"+von+ " bzw. bis:"+bis+" entsprechen nicht dem Array");
	}
	public static void vertausche(int[] a, int i1, int i2) {
		if  (ArrayMethoden.testIndex(a,i1)&&ArrayMethoden.testIndex(a,i2)) {
			int temp=a[i2];
			a[i2]=a[i1];
			a[i1]=temp;
		}
		else
			throw new RuntimeException("Indizes index1:"+i1+ " bzw. index2:"+i2+" entsprechen nicht dem Array");
	}
	private static boolean testIndex(int[] a, int index) {
		boolean ret=false;
		if(index>=0&&index<a.length) ret=true;
		return ret;
	}
	
}
