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
	private MouseEvent lastMouseEvent=null;

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
			if (item == frame.getItemDelete()) // Aktion Löschen
				{
				view.deleteDrawable();
				view.repaint();
				}
			else if (item == frame.getItemRestore()) // Aktion Löschen
				{
				view.restoreDrawable();
				view.repaint();
				}
			else if (item == frame.getItemFreehand()) // Freihandzeichnen
				modus = Modus.FREEHAND; // aktivieren
			else if (item == frame.getItemLine()) // Linien zeichnen
				modus = Modus.LINES;
			else if (item == frame.getItemRectangle()) // Linien zeichnen
				modus = Modus.RECTANGLE;
			else if (item == frame.getItemOval()) // Linien zeichnen
				modus = Modus.OVAL;
			else if (item == frame.getItemRectangleFull()) // Linien zeichnen
				modus = Modus.RECTANGLE_FULL;
			else if (item == frame.getItemRoundedRectangleFull()) // Linien zeichnen
				modus = Modus.ROUNDED_RECTANGLE_FULL;
			else if (item == frame.getItemRoundedRectangle()) // Linien zeichnen
				modus = Modus.ROUNDED_RECTANGLE;
			else if (item == frame.getItemOvalFull()) // Linien zeichnen
				modus = Modus.OVAL_FULL;

			else if (item == frame.getItemForeground()) // JColorChooser für die
													// Stiftfarbe
				view.setForeground(JColorChooser.showDialog(view, "Stiftfarbe",
						view.getForeground())); // auswählen und setzen
			else if (item == frame.getItemBackground()) // JColorChooser für die
													// Hintergrundfarbe
				view.setBackground(JColorChooser.showDialog(view,
						"Hintergrund", view.getBackground())); // auswählen und
																// setzen
			else if (item == frame.getItemInfo()) { // Info der Applikation anzeigen
				JOptionPane.showMessageDialog(frame,
						"Zeichenbrett v1.4\n(c) Walter Rafeiner-Magor", "Info",
						JOptionPane.OK_OPTION);
			}
			else if (item == frame.getItemLoad()) { // Info der Applikation anzeigen
				JOptionPane.showMessageDialog(frame,
						"Not implemented yet!", "Info",
						JOptionPane.OK_OPTION);
			}
			else if (item == frame.getItemSave()) { // Info der Applikation anzeigen
				JOptionPane.showMessageDialog(frame,
						"Not implemented yet!", "Info",
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
		if(modus!=Modus.FREEHAND && lastMouseEvent!=null && lastMouseEvent.getID()==MouseEvent.MOUSE_DRAGGED)
			// letzte Linie vergessen
			view.deleteDrawable();
		switch (modus) { // Figuren zeichnen
		case FREEHAND:
			view.addDrawable(new Line(lastX, lastY, x, y, view.getForeground()));
			break;
		case LINES:
			view.addDrawable(new Line(lastX, lastY, x, y, view.getForeground()));
			break;
		case RECTANGLE_FULL:
		case RECTANGLE:
			boolean fullr = (modus == Modus.RECTANGLE_FULL);
			view.addDrawable(new Rectangle(lastX, lastY, x, y, view
					.getForeground(), fullr));
			break;
		case ROUNDED_RECTANGLE_FULL:
		case ROUNDED_RECTANGLE:
			boolean fullrr = (modus == Modus.ROUNDED_RECTANGLE_FULL);
			view.addDrawable(new RoundedRectangle(lastX, lastY, x, y, view
					.getForeground(), fullrr));
			break;

		case OVAL:
		case OVAL_FULL:
			boolean fullo = (modus == Modus.OVAL_FULL);
			view.addDrawable(new Oval(lastX, lastY, x, y, view.getForeground(),
					fullo));
			break;
		}
		if(modus!=Modus.FREEHAND)
			view.repaint(); // neu zeichnen
		else
			merkeKoordinaten(x, y);
		lastMouseEvent=e;
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
			// Dragged Version vergessen!
			view.deleteDrawable();
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
			case ROUNDED_RECTANGLE:
			case ROUNDED_RECTANGLE_FULL:
				boolean fullrr = (modus == Modus.ROUNDED_RECTANGLE_FULL);
				view.addDrawable(new RoundedRectangle(lastX, lastY, x, y, view
						.getForeground(),fullrr));
				break;
			case OVAL:
			case OVAL_FULL:
				boolean fullo = (modus == Modus.OVAL_FULL);
				view.addDrawable(new Oval(lastX, lastY, x, y, view
						.getForeground(),fullo));
				break;
			}
			merkeKoordinaten(x, y);
			lastMouseEvent=e;
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
