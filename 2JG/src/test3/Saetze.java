package test3;

import java.util.Scanner;

public class Saetze {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String g = sc.nextLine();
		String[] saetze=g.split("\\.");
		String[][] zeilen=new String[saetze.length][];
		for(int i=0;i<saetze.length;++i) {
			String[] temp=saetze[i].split(" ");
			zeilen[i]=new String[temp.length];
			zeilen[i]=temp;
		}
		for(int i=0;i<zeilen.length;++i) {
			for(int j=0;j<zeilen[i].length;++j) {
				System.out.print(zeilen[i][j]+" ");
				
			}
			System.out.println();
		}
	}

}
