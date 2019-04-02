package G621;
import java.util.Scanner;

public class Ein_Ausgabe {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Bitte die Anzahl der Zeilen eingeben: ");
		int stellen=s.nextInt();
		NumberSquare a=new NumberSquare(stellen);
//		System.out.println("Bitte nun die Werte fuer die Zellen eingeben: ");
//		for(int i=0;i<stellen;++i) {
//			for(int j=0;j<stellen;++j) {
//				System.out.println("Bitte Wert fuer Zelle["+i+"]["+j+"] eingeben:");
//				s=new Scanner(System.in);
//				int value=s.nextInt();
//				a.setNumber(i, j, value);
//			}
//		}
		System.out.println(a.stringForm());
		String ein=(a.isMagicSquare())?"ein":"kein";
		System.out.println("Es handelt sich um "+ein+" magisches Quadrat");
		a.fillMagicSquare();
		System.out.println(a.stringForm());
		ein=(a.isMagicSquare())?"ein":"kein";
		System.out.println("Es handelt sich um "+ein+" magisches Quadrat");

	}

}