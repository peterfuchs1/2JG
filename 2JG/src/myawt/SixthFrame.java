/**
 * 
 */
package myawt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;

/**
 * @author Walter Rafeiner-Magor
 */
public class SixthFrame extends Frame{
	/**
	 * 
	 */
	private static final long serialVersionUID = -772572366677255087L;
	public SixthFrame(String name){
		super(name);
		// es werden 5 Panels erzeugt
		Panel oben=new Panel();
		Panel links=new Panel();
		Panel rechts=new Panel();
		Panel unten=new Panel();
		Panel mitte=new MyFifthPanel("Mein Lieblingsfach lautet:");
		
		// Jedes Panel bekommt eine eigene Farbe
		oben.setBackground(Color.GREEN);
//		mitte.setBackground(Color.YELLOW);
		unten.setBackground(Color.BLUE);
		links.setBackground(Color.ORANGE);
		rechts.setBackground(Color.RED);
				
		// Die Panels werden nun ins Frame (Container) gesetzt
		this.add(oben, BorderLayout.NORTH);
		this.add(unten, BorderLayout.SOUTH);
		this.add(mitte, BorderLayout.CENTER);
		this.add(links, BorderLayout.WEST);
		this.add(rechts, BorderLayout.EAST);
		
		/*
		 * Wir verwenden nun eine eigene Klasse
		 * die sich um die Window-Ereignisse k�mmert!
		 */
		MyWindowAdapter mwa= new MyWindowAdapter();
		this.addWindowListener(mwa);	
		this.setSize(240, 240);					// Gr��e so kompakt wie m�glich
		this.setVisible(true);			// sichtbar machen!
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new SixthFrame("leeres Fenster");
	}
}
