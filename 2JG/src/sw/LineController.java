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
 * Controller für Zeichenbrett Actionlistener: JMenuItems im Frame MouseAdapter:
 * View
 * 
 * @author Walter Rafeiner-Magor
 * @version 1.2
 */
public class LineController extends MouseAdapter implements ActionListener {
	private MyDrawingPanel3 view; // MyJPanel
	private MyDrawingFrame3 frame; // MyFrame
	private int lastX; // letzte X-Koordinaten
	private int lastY; // letzte Y-Koordinaten
	private Modus modus; // Welcher Modus ist aktiv?

	public LineController() {
		modus = Modus.FREEHAND; // Freihandzeichnen aktiviert
		view = new MyDrawingPanel3(this); // Mit MyJPanel verknüpft
		frame = new MyDrawingFrame3(view, this); // Mit MyFrame verknüpft
		frame.getItemFreehand().setSelected(true); // JRadioButtonMenuItem
													// gesetzt
	}

	/*
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		if (o instanceof JMenuItem) { // Falls Objekt der Klasse JMenuItem
			JMenuItem item = (JMenuItem) o; // Cast to JMenuItem
			if (item == frame.getItemFreehand()) // Freihandzeichnen
				modus = Modus.FREEHAND; // aktivieren
			if (item == frame.getItemLine()) // Linien zeichnen
				modus = Modus.LINES;
			if (item == frame.getItemRectangle()) // Linien zeichnen
				modus = Modus.RECTANGLE;
			if (item == frame.getItemOval()) // Linien zeichnen
				modus = Modus.OVAL;
			if (item == frame.getItemRectangleFull()) // Linien zeichnen
				modus = Modus.RECTANGLE_FULL;
			if (item == frame.getItemOvalFull()) // Linien zeichnen
				modus = Modus.OVAL_FULL;

			if (item == frame.getItemForeground()) // JColorChooser für die
													// Stiftfarbe
				view.setForeground(JColorChooser.showDialog(view, "Stiftfarbe",
						view.getForeground())); // auswählen und setzen
			if (item == frame.getItemBackground()) // JColorChooser für die
													// Hintergrundfarbe
				view.setBackground(JColorChooser.showDialog(view,
						"Hintergrund", view.getBackground())); // auswählen und
																// setzen
			if (item == frame.getItemInfo()) { // Info der Applikation anzeigen
				JOptionPane.showMessageDialog(frame,
						"Zeichenbrett v1.3\n(c) Walter Rafeiner-Magor", "Info",
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
		if (modus == Modus.FREEHAND)
			view.addDrawable(new Line(x, y, x, y, view.getForeground()));
		merkeKoordinaten(x, y);
	}

	/**
	 * Eine Methode des MouseMotionListener interface. Wird aufgerufen, wenn der
	 * User die Maus mit gedruecktem Button zieht.
	 */
	public void mouseDragged(MouseEvent e) {

		int x = e.getX(); // Liefert X-Koordinaten des Mausklicks!
		int y = e.getY(); // Liefert Y-Koordinaten des Mausklicks!
		if (!view.isGestartet()) {
			view.setGestartet(true);
			merkeKoordinaten(x, y);
		}
		switch (modus) {
		case FREEHAND:
			// Linie und Farbe speichern und zeichnen
			view.addDrawable(new Line(lastX, lastY, x, y, view.getForeground()));
			merkeKoordinaten(x, y);
			break;
		case LINES:
			// letzte Linie vergessen
			// neue Linie erstellen
			view.deleteLine();
			view.addDrawable(new Line(lastX, lastY, x, y, view.getForeground()));
			view.repaint(); // neu zeichnen
			break;
		case RECTANGLE_FULL:
		case RECTANGLE:
			boolean fullr = (modus == Modus.RECTANGLE_FULL);
			// letzte Linie vergessen
			// neue Linie erstellen
			view.deleteLine();
			view.addDrawable(new Rectangle(lastX, lastY, x, y, view
					.getForeground(), fullr));
			view.repaint(); // neu zeichnen
			break;
		case OVAL:
		case OVAL_FULL:
			boolean fullo = (modus == Modus.OVAL_FULL);
			// letzte Linie vergessen
			// neue Linie erstellen
			view.deleteLine();
			view.addDrawable(new Oval(lastX, lastY, x, y, view.getForeground(),
					fullo));
			view.repaint(); // neu zeichnen
			break;
		}

	}

	/**
	 * Eine Methode des MouseListener Interface. Wird aufgerufen, wenn der User
	 * einen Mousebutton loslässt.
	 */
	public void mouseReleased(MouseEvent e) {
		if (modus != Modus.FREEHAND) {
			int x = e.getX(); // Liefert X-Koordinaten des Mausklicks!
			int y = e.getY(); // Liefert Y-Koordinaten des Mausklicks!
			if (!view.isGestartet()) {
				view.setGestartet(true);
				merkeKoordinaten(x, y);
			}
			// neue Linie und Farbe speichern:
			switch (modus) {
			case LINES:
				view.addDrawable(new Line(lastX, lastY, x, y, view
						.getForeground()));
				break;
			case RECTANGLE:
			case RECTANGLE_FULL:
				boolean fullr = (modus == Modus.RECTANGLE_FULL);
				view.addDrawable(new Rectangle(lastX, lastY, x, y, view
						.getForeground(),fullr));
				break;
			case OVAL:
			case OVAL_FULL:
				boolean fullo = (modus == Modus.OVAL_FULL);
				view.addDrawable(new Oval(lastX, lastY, x, y, view
						.getForeground(),fullo));
				break;
			}
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
