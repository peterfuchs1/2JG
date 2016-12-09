/**
 * 
 */
package myawt;

import java.awt.Frame;
import java.awt.Window;

/**
 * @author Walter Rafeiner-Magor
 */
public class FirstWindow extends Window {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public FirstWindow(){
		super(new Frame("leeres Fenster"));
		this.setSize(480, 320); // Größe in Pixel
		this.setVisible(true);	// sichtbar machen!
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new FirstWindow();
	}
}
