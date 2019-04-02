/**
 * 
 */
package test4;

/**
 * @author wrafeiner
 *
 */
public class DimmLichtTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DimmLicht dl=null;
		try {
			dl = new DimmLicht("WZ", false, 30);
		} catch (NegativeValueException e1) {
			e1.printStackTrace();
		}
		System.out.println(dl.beschreibung());
		dl.einschalten();
		System.out.println(dl.beschreibung());
		try {
			dl.erhoehen(40);
		} catch (NegativeValueException e) {
			e.printStackTrace();
		}
		System.out.println(dl.beschreibung());
		try {
			dl.verringern(90);
		} catch (NegativeValueException e) {
			e.printStackTrace();
		}
		System.out.println(dl.beschreibung());
		dl.ausschalten();
		System.out.println(dl.beschreibung());

	}

}
