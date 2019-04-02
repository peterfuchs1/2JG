package G614;

import java.util.Scanner;

public class Ein_Ausgabe {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Bitte die Anzahl der Ganzzahlen eingeben: ");
		int stellen=s.nextInt();
		Zahlenarray a=new Zahlenarray(stellen);
		System.out.println(a.arrayToText());
		a.umdrehen();
		System.out.println(a.arrayToText());
	}

}
