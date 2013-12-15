/**
 * 
 */
package sw;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JColorChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * Controller f�r Zeichenbrett 
 * Actionlistener: JMenuItems im Frame 
 * MouseAdapter: View
 * 
 * @author Walter Rafeiner-Magor
 * @version 1.2
 */
public class LineController extends MouseAdapter implements ActionListener {
	private MyDrawingPanel3 view;		// MyJPanel
	private MyDrawingFrame3 frame;		// MyFrame
	private int lastX;					// letzte X-Koordinaten
	private int lastY;					// letzte Y-Koordinaten
	private boolean freehand;			// Freihandzeichnen aktiv?

	public LineController() {
		freehand = true;							// Freihandzeichnen aktiviert
		view = new MyDrawingPanel3(this);			// Mit MyJPanel verkn�pft
		frame = new MyDrawingFrame3(view, this);	// Mit MyFrame verkn�pft
		frame.getItemFreehand().setSelected(true);	// JRadioButtonMenuItem gesetzt
	}

	/* 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		if (o instanceof JMenuItem) {			 	// Falls Objekt der Klasse JMenuItem
			JMenuItem item = (JMenuItem) o;		 	// Cast to JMenuItem
			if (item == frame.getItemFreehand()) 	// Freihandzeichnen
				freehand = true;					// aktivieren
			if (item == frame.getItemLine())		// Linien zeichnen
				freehand = false;
			if (item == frame.getItemForeground())	// JColorChooser f�r die Stiftfarbe
				view.setForeground(JColorChooser.showDialog(
						view, "Stiftfarbe",view.getForeground())
						);							// ausw�hlen und setzen
			if (item == frame.getItemBackground())	// JColorChooser f�r die Hintergrundfarbe
				view.setBackground(JColorChooser.showDialog(
						view,"Hintergrund", view.getBackground())
						);							// ausw�hlen und setzen
			if (item == frame.getItemInfo()) {		// Info der Applikation anzeigen
				JOptionPane.showMessageDialog(frame,
						"Zeichenbrett v1.2\n(c) Walter Rafeiner-Magor", "Info",
						JOptionPane.OK_OPTION);
			}
		}
	}

	/**
	 * Eine Methode des MouseListener Interface. Wird aufgerufen, wenn der User
	 * einen Mousebutton drueckt.
	 */
	public void mousePressed(MouseEvent e) {
		int x = e.getX(); // Liefert X-Koordinaten des Mausklicks!
		int y = e.getY(); // Liefert Y-Koordinaten des Mausklicks!
		if (!view.isGestartet()) {
			view.setGestartet(true);
			merkeKoordinaten(x, y);
		}
		// Punkt und Farbe speichern und zeichnen
		if (freehand)
			view.addLine(new Line(x, y, x, y, view.getForeground()));
		merkeKoordinaten(x, y);
	}

	/**
	 * Eine Methode des MouseMotionListener interface. Wird aufgerufen, wenn der
	 * User die Maus mit gedruecktem Button zieht.
	 */
	public void mouseDragged(MouseEvent e) {
		if (freehand) {
			int x = e.getX(); // Liefert X-Koordinaten des Mausklicks!
			int y = e.getY(); // Liefert Y-Koordinaten des Mausklicks!
			if (!view.isGestartet()) {
				view.setGestartet(true);
				merkeKoordinaten(x, y);
			}
			// Linie und Farbe speichern und zeichnen
			view.addLine(new Line(lastX, lastY, x, y, view.getForeground()));
			merkeKoordinaten(x, y);
		}
	}

	/**
	 * Eine Methode des MouseListener Interface. Wird aufgerufen, wenn der User
	 * einen Mousebutton losl�sst.
	 */
	public void mouseReleased(MouseEvent e) {
		if (!freehand) {
			int x = e.getX(); // Liefert X-Koordinaten des Mausklicks!
			int y = e.getY(); // Liefert Y-Koordinaten des Mausklicks!
			if (!view.isGestartet()) {
				view.setGestartet(true);
				merkeKoordinaten(x, y);
			}
			// neue Linie und Farbe speichern:
			view.addLine(new Line(lastX, lastY, x, y, view.getForeground()));
			merkeKoordinaten(x, y);
		}
	}

	/**
	 * Sichert die letzten Koordinaten
	 * 
	 * @param x
	 * @param y
	 */
	private void merkeKoordinaten(int x, int y) {
		lastX = x;
		lastY = y;
	}

}
