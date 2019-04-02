package G631;

import java.util.Random;

public class ArrayMethoden {

	public static int[] zufallsArray(int stellen) {
		Random r = new Random();
		return r.ints(stellen, 0, stellen * 2 + 1).toArray();
	}

	public static String arrayToText(int[] a) {
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < a.length; ++i) {
			s.append(a[i]);
			if (i < a.length - 1)
				s.append(" ,");
		}
		return s.toString();
	}

	public static void fillArray(int[] a, int zahl) {
		for (int i = 0; i < a.length; ++i) {
			a[i] = zahl;
		}
	}

	public static void fillZufallArray(int[] a, int von, int bis) {
		Random r = new Random();
		if (ArrayMethoden.testIndex(a, von) && ArrayMethoden.testIndex(a, bis) && (bis >= von)) {
			for (int i = von; i <= bis; ++i) {
				a[i] = r.nextInt();
			}
			return;
		}
		throw new RuntimeException("Indizes von:" + von + " bzw. bis:" + bis + " entsprechen nicht dem Array");
	}

	public static void vertausche(int[] a, int i1, int i2) {
		if (ArrayMethoden.testIndex(a, i1) && ArrayMethoden.testIndex(a, i2)) {
			int temp = a[i2];
			a[i2] = a[i1];
			a[i1] = temp;
		} else
			throw new RuntimeException("Indizes index1:" + i1 + " bzw. index2:" + i2 + " entsprechen nicht dem Array");
	}

	private static boolean testIndex(int[] a, int index) {
		boolean ret = false;
		if (index >= 0 && index < a.length)
			ret = true;
		return ret;
	}

	/**
	 * Diese Methode kopiert ein Array von ints.
	 * 
	 * @param array Ausgangs-Array
	 * @return neue array
	 */
	public static int[] kopiere(int[] array) {
		if (array == null)
			throw new RuntimeException("Array ist null!");
		int[] a = new int[array.length];
		for (int i = 0; i < array.length; ++i) {
			a[i] = array[i];
		}
		return a;
	}
	/**
	 * Diese Methode kopiert ein 2D-Array von ints.
	 * 
	 * @param array Ausgangs-Array
	 * @return neue Array
	 */
	public static int[][] kopiere(int[][] array) {
		if (array == null)
			throw new RuntimeException("Array ist null!");
		int x = array.length;
		int y = array[0].length;
		int[][] a = new int[x][y];
		for (int i = 0; i < x; ++i) {
			for (int j = 0; j < y; ++j) {
				a[i][j] = array[i][j];
			}
		}
		return a;
	}
	/**
	 * Diese Methode kopiert ein Array von ints.
	 * 
	 * @param quelle Ausgangs-Array
	 * @param ziel   Ziel-Array
	 * @return Ziel-Array
	 */
	public static int[] kopiere(int[] quelle, int[] ziel) {
		if (quelle == null)
			throw new RuntimeException("Array1 ist null!");
		if (ziel == null)
			throw new RuntimeException("Array2 ist null!");
		int grenze=(ziel.length<quelle.length)?ziel.length:quelle.length;
		for (int i = 0; i < grenze; ++i)
			ziel[i] = quelle[i];
		return ziel;
	}


	/**
	 * Vergroessert ein Array von ints
	 * @param quelle Ausgangs-Array
	 * @param erweitern Anzahl zusaetzlicher Elemente
	 * @return
	 */
	public static int[] vergroessern(int [] quelle, int erweitern){
		if(erweitern<0||erweitern>quelle.length)
			throw new RuntimeException("Parameter zur Erweiterung["+erweitern+"] fehlerhaft!");
		int groesse=quelle.length+erweitern;
		int[] ziel=new int[groesse];
		return ArrayMethoden.kopiere(quelle,ziel);
	}
	/**
	 * Verkleinert ein Array von ints
	 * @param quelle Ausgangs-Array
	 * @param erweitern Anzahl reduzierter Elemente
	 * @return
	 */
	public static int[] verkleinern(int [] quelle, int reduzieren){
		if(reduzieren<0||reduzieren>quelle.length)
			throw new RuntimeException("Parameter zur Erweiterung["+reduzieren+"] fehlerhaft!");
		int groesse=quelle.length-reduzieren;
		int[] ziel=new int[groesse];
		return ArrayMethoden.kopiere(quelle,ziel);
	}
	/**
	 * Testet das Vergroessern und Verkleinern
	 * @param args
	 */
	public static void main(String[] args) {
		int groesse=15;
		int quelle[]=ArrayMethoden.zufallsArray(groesse);
		// Ausgabe Quelle
		System.out.println(ArrayMethoden.arrayToText(quelle));

		int[] ziel1=ArrayMethoden.vergroessern(quelle, 2);
		// Ausgabe der Quelle + 2 Elemente
		System.out.println(ArrayMethoden.arrayToText(ziel1));
		
		int [] ziel2=ArrayMethoden.verkleinern(quelle, 4);
		// Ausgabe der Quelle - 4 Elemente
		System.out.println(ArrayMethoden.arrayToText(ziel2));
		

	}
}
