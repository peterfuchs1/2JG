import java.util.Scanner;

public class array {

	public static void main(String[] args) {

		System.out.println("Bitte geben Sie die Anzahl der Werte ein: ");
		Scanner sc = new Scanner(System.in);
		double[] zahlen = new double[sc.nextInt()];
		for(int i=0;i<zahlen.length;++i) {
			System.out.println("Bitte die Zahl "+(i+1)+" eingeben: ");
			zahlen[i]=sc.nextInt();
		}
		String aus = "";
		for (int i = 0; i < zahlen.length; i++) {
			aus = aus + zahlen[i] + " ";
		}
		System.out.println(aus);

	}

}
