/**
 * 
 */
package awt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * @author Walter Rafeiner-Magor
 */
public class ThirdFrame extends Frame implements WindowListener{
	public ThirdFrame(String name){
		super(name);
		// es werden 5 Panels erzeugt
		Panel oben=new Panel();
		Panel links=new Panel();
		Panel rechts=new Panel();
		Panel unten=new Panel();
		Panel mitte=new Panel();
		
		// Jedes Panel bekommt eine eigene Farbe
		oben.setBackground(Color.GREEN);
		mitte.setBackground(Color.YELLOW);
		unten.setBackground(Color.BLUE);
		links.setBackground(Color.ORANGE);
		rechts.setBackground(Color.RED);
		
		// Die Panels werden nun ins Frame (Container) gesetzt
		this.add(oben, BorderLayout.NORTH);
		this.add(unten, BorderLayout.SOUTH);
		this.add(mitte, BorderLayout.CENTER);
		this.add(links, BorderLayout.WEST);
		this.add(rechts, BorderLayout.EAST);
		
		this.addWindowListener(this);	// Unsere Klasse kümmert sich um Window-Ereignisse!
		this.setSize(480, 320); 		// Größe in Pixel
		this.setVisible(true);			// sichtbar machen!
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new ThirdFrame("leeres Fenster");
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
