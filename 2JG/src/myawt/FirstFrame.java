/**
 * 
 */
package myawt;

import java.awt.Frame;

/**
 * @author Walter Rafeiner-Magor
 */
public class FirstFrame extends Frame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public FirstFrame(String name){
		super(name);
		this.setSize(480, 320); // Gr��e in Pixel
		this.setVisible(true);	// sichtbar machen!
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new FirstFrame("leeres Fenster");
	}
}
