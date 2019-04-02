package G612;

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
}
