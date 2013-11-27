/**
 * 
 */
package awt;

import java.awt.Label;
import java.awt.Panel;

/**
 * @author Walter Rafeiner-Magor
 *
 */
public class MyFirstPanel extends Panel {
	private Label l;

	/**
	 * Konstruktor
	 * @param String 
	 */
	public MyFirstPanel(String t) {
		l=new Label(t);		// Ein neues Label mit Text wird erstellt
		this.add(l);		// Das Label wird dem Panel hinzugefügt
	}	
}
