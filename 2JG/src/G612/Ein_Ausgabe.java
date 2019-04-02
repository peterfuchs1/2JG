package G612;

import java.util.Scanner;

public class Ein_Ausgabe {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Bitte die Anzahl der Ganzzahlen eingeben: ");
		int stellen=s.nextInt();
		int[] a=ArrayMethoden.zufallsArray(stellen);
		System.out.println(ArrayMethoden.arrayToText(a));
	}

}
