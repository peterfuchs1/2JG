/**
 * 
 */
package sw;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;

/**
 * @author Walter Rafeiner-Magor
 * 
 */
public class LineController extends MouseAdapter implements ActionListener {

	private MyDrawingPanel3 view;
	private MyDrawingFrame3 frame;
	private int lastX;
	private int lastY;
	private boolean freehand;

	public LineController() {
		freehand = false;
		view = new MyDrawingPanel3(this);
		frame = new MyDrawingFrame3(view, this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		JMenuItem item=(JMenuItem)ae.getSource();
		if(item==frame.getItemFreehand())
			freehand=true;
		if(item==frame.getItemLine())
			freehand=false;
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
		// Punkt speichern und zeichnen
		if(freehand)
			view.addLine(new Line(x, y, x, y));
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
			// Linie speichern und zeichnen
			view.addLine(new Line(lastX, lastY, x, y));
			merkeKoordinaten(x, y);
		}
	}
	/**
	 * Eine Methode des MouseListener Interface. Wird aufgerufen, wenn der User
	 * einen Mousebutton loslässt.
	 */
	public void mouseReleased(MouseEvent e) {
		if (!freehand) {
			int x = e.getX(); // Liefert X-Koordinaten des Mausklicks!
			int y = e.getY(); // Liefert Y-Koordinaten des Mausklicks!
			if (!view.isGestartet()) {
				view.setGestartet(true);
				merkeKoordinaten(x, y);
			}
			// neue Linie speichern:
			view.addLine(new Line(lastX, lastY, x, y));
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

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		new LineController();
	}
}
