/**
 * 
 */
package myawt;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @author Walter Rafeiner-Magor
 */
public class SecondFrame extends Frame implements WindowListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1690195784916975402L;
	public SecondFrame(String name){
		super(name);
		this.addWindowListener(this);	// Unsere Klasse kümmert sich um Window-Ereignisse!
		this.setSize(480, 320); 		// Größe in Pixel
		this.setBackground(Color.ORANGE);	// Hintergrund erhält eine neue Farbe
		this.setVisible(true);			// sichtbar machen!
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new SecondFrame("leeres Fenster");
	}
	@Override
	public void windowClosed(WindowEvent we) {
		System.err.println("Window closed");
	}
	@Override
	public void windowActivated(WindowEvent we) {
		System.err.println("Window activated");
	}
	@Override
	public void windowClosing(WindowEvent we) {
		System.err.println("Window closing");
		System.exit(0);
	}
	@Override
	public void windowDeactivated(WindowEvent we) {
		System.err.println("Window deactivated");
	}
	@Override
	public void windowDeiconified(WindowEvent we) {
		System.err.println("Window deiconified");
	}
	@Override
	public void windowIconified(WindowEvent we) {
		System.err.println("Window iconified");
	}
	@Override
	public void windowOpened(WindowEvent we) {
		System.err.println("Window opened");
	}
}
