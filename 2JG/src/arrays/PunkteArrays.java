package arrays;

import java.awt.Point;

/**
 * ObjektArray am Beispiel von Point[]
 * 
 * @author wrafeiner
 * @version 2018-12-07
 */
public class PunkteArrays {
	/**
	 * Element zu Array hinzufuegen
	 * 
	 * @param ps Array
	 * @param p  Element
	 * @return konnte das Element hinzugefuegt werden?
	 */
	public static boolean hinzufuegen(Point[] ps, Point p) {
		boolean hinzugefuegt = false;
		int i;
		for (i = 0; i < ps.length && !hinzugefuegt; i++) {
			if (ps[i] == null) {
				ps[i] = p;
				hinzugefuegt = true;
			}
		}
		return hinzugefuegt;
	}

	/**
	 * Element am Index im Array entfernen
	 * 
	 * @param ps    Array
	 * @param index Index
	 * @return konnte das Element entfernt werden?
	 */
	public static boolean entfernen(Point[] ps, int index) {
		boolean deleted = false;
		if (index >= 0 && index < ps.length) {
			ps[index] = null;
			deleted = true;
		}
		return deleted;
	}

	/**
	 * Ausgabe aller Elemente des Arrays
	 * 
	 * @param ps Array
	 * @return String-Representation in der Form: Point[0]=(10,10)
	 */
	public static String toString(Point[] ps) {
		String s = new String();
		for (int i = 0; i < ps.length; ++i) {
			if (ps[i] != null) {
				s += "Point[" + i;
				s += "]=(" + ps[i].x;
				s += "," + ps[i].y;
				s += ")\n";
			} else {
				s += "Point[" + i;
				s += "]=null\n";
			}
		}
		return s;
	}

	/**
	 * Element aus dem Array entfernen
	 * 
	 * @param ps Array
	 * @param p  Element
	 * @return konnte das Element entfernt werden?
	 */
	public static boolean entfernen(Point[] ps, Point p) {
		boolean deleted = false;
		for (int i = 0; i < ps.length; ++i) {
			if (ps[i] == p) {
				ps[i] = null;
				deleted = true;
			}
		}
		return deleted;
	}

	/**
	 * Teste PunktArray mit 3 Elementen
	 * 
	 * @param args Commandline Parameter
	 */
	public static void main(String[] args) {
		Point[] ps = new Point[4];
		Point p1 = new Point(10, 70);
		PunkteArrays.hinzufuegen(ps, p1);
		Point p2 = new Point(100, 10);
		PunkteArrays.hinzufuegen(ps, p2);
		Point p3 = new Point(50, 20);
		PunkteArrays.hinzufuegen(ps, p3);
		System.out.println(PunkteArrays.toString(ps));
		PunkteArrays.entfernen(ps, 0);
		System.out.println(PunkteArrays.toString(ps));
		PunkteArrays.entfernen(ps, p2);
		System.out.println(PunkteArrays.toString(ps));
	}

}