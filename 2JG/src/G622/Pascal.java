package G622;

import java.util.Scanner;

public class Pascal {

	public static void main(String[] args){
		System.out.println("Bitte die Anzahl der Zeilen eingeben: ");
		Scanner s=new Scanner(System.in);
		int x=s.nextInt();
		int[][] a=Pascal.pascal(x);
		System.out.println(Pascal.arrayToString(a));
		System.out.println(Pascal.arrayToTriangle(a));

	}
	public static int[][] pascal(int x) {
		if(x < 2) throw new RuntimeException("Es koennen nur Zeilen groesse 1 verwendet werden!");
		int[][] a=new int[x][];
		for(int i=0;i<x;++i) {
			a[i]=new int[i+1];
			for(int j=0;j<a[i].length;j++) {
				if (j==0 ||j==a[i].length-1)
					a[i][j]=1;
				else {
					a[i][j]=a[i-1][j-1]+a[i-1][j];
				}
			}
		}
		return a;
	}
	public static String arrayToString(int[][] array) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < array.length; ++i) {
			for (int j = 0; j < array[i].length; ++j) {
				s.append(array[i][j]);
				if (j < array[i].length - 1)
					s.append(' ');
			}
			s.append('\n');
		}
		return s.toString();
	}

	public static String arrayToTriangle(int[][] array) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < array.length; ++i) {
			for(int j=i;j<array.length;++j)
				s.append(' ');
			for (int j = 0; j < array[i].length; ++j) {
				s.append(array[i][j]);
				if (j < array[i].length - 1) {
					s.append(" ");
				}
			}
			s.append('\n');
		}
		return s.toString();
	}

	
}
