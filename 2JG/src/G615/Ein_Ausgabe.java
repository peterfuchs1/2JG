package G615;

import java.util.Scanner;

public class Ein_Ausgabe {

	public static void main(String[] args) {
		
		int[] a=new int[5];
		ArrayMethoden.fillArray(a, 2);
		System.out.println(ArrayMethoden.arrayToText(a));
//		ArrayMethoden.fillZufallArray(a, 0, 6);
		ArrayMethoden.fillZufallArray(a, 0, 4);
		System.out.println(ArrayMethoden.arrayToText(a));
		ArrayMethoden.vertausche(a, 0, 4);
		System.out.println(ArrayMethoden.arrayToText(a));
	}

}
