/**
 * 
 */
package sw;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;

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
public class LineController extends MouseAdapter implements ActionListener,
		KeyListener {
	private MyDrawingPanel3 view; // MyJPanel
	private MyDrawingFrame3 frame; // MyFrame
	private int lastX; // letzte X-Koordinaten
	private int lastY; // letzte Y-Koordinaten
	private Modus modus; // Welcher Modus ist aktiv?
	private MouseEvent lastMouseEvent = null;
	private boolean alt, shift;// SHIFT- und ALT-Taste

	public LineController() {
		modus = Modus.FREEHAND; // Freihandzeichnen aktiviert
		view = new MyDrawingPanel3(this); // Mit MyJPanel verknüpft
		frame = new MyDrawingFrame3(view, this); // Mit MyFrame verknüpft
		frame.getItemFreehand().setSelected(true); // JRadioButtonMenuItem
													// gesetzt
		alt = shift = false;	// SHIFT- und ALT-Taste initialisiert
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
			if(view.isGestartet()){// bereits gestartet !!
				if (item == frame.getItemDuplicate()) { 
					// Element duplizieren
					view.addDrawable(view.getDrawables()[view.getIndex()-1].clone());
					view.repaint();} 
				else if (item == frame.getItemHome())  
					// Element in Homeposition
					this.homePosition();
				else if (item == frame.getItemColor()){ 
					// JColorChooser für die Elementfarbe
					Drawable d=view.getDrawables()[view.getIndex()-1];
					Color c=d.getColor();
							d.setColor(JColorChooser.showDialog(view,
							"Elementfarbe", c));
							view.repaint();}
				else if (item == frame.getItemDelete())  
						// Element Löschen
						this.deleteItem(); 
				else if (item == frame.getItemRestore())  
						// Element wiederherstellen
						this.restoreItem();
			}
			else{/*noch nicht gestartet*/} 
			if (item == frame.getItemNew())  
				// Neues Zeichenbrett
				this.newNotePad();
			else if (item == frame.getItemFreehand()) // Freihandzeichnen
				modus = Modus.FREEHAND; // aktivieren
			else if (item == frame.getItemLine()) 
				// Linien zeichnen
				modus = Modus.LINES;
			else if (item == frame.getItemRectangle()) 
				// Rechteck zeichnen
				modus = Modus.RECTANGLE;
			else if (item == frame.getItemOval()) 
				// Ellipse zeichnen
				modus = Modus.OVAL;
			else if (item == frame.getItemRectangleFull()) 
				// Rechteck ausmalen
				modus = Modus.RECTANGLE_FULL;
			else if (item == frame.getItemRoundedRectangleFull()) 
				// abgerundetes Rechteck ausmalen
				modus = Modus.ROUNDED_RECTANGLE_FULL;
			else if (item == frame.getItemRoundedRectangle()) 
				// abgerundetes Rechteck zeichnen
				modus = Modus.ROUNDED_RECTANGLE;
			else if (item == frame.getItemOvalFull()) 
				// Ellipse ausmalenen
				modus = Modus.OVAL_FULL;
			else if (item == frame.getItemForeground()) 
				// JColorChooser für die Stiftfarbe
				view.setForeground(JColorChooser.showDialog(view, "Stiftfarbe",
						view.getForeground())); 
				// auswählen und setzen
			else if (item == frame.getItemBackground()) 
				// JColorChooser für die Hintergrundfarbe
				view.setBackground(JColorChooser.showDialog(view,
						"Hintergrund", view.getBackground())); 
				// auswählen und setzen
			else if (item == frame.getItemAbout()) { 
				// Info der Applikation anzeigen
				JOptionPane.showMessageDialog(frame,
						"Zeichenbrett v1.7\n(c) Walter Rafeiner-Magor", "Info",
						JOptionPane.OK_OPTION);} 
			else if (item == frame.getItemHelp())  
				// Hilfe der Applikation anzeigen
				 this.showHelp();
			else if (item == frame.getItemLoad()) 
				// File laden
				this.notImplementedYet();
			else if (item == frame.getItemSave())  
				// File speichern
				this.notImplementedYet();
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
			this.gestartet();
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
			this.gestartet();
			merkeKoordinaten(x, y);
		}
		if (modus != Modus.FREEHAND && lastMouseEvent != null
				&& lastMouseEvent.getID() == MouseEvent.MOUSE_DRAGGED)
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
		if (modus != Modus.FREEHAND)
			view.repaint(); // neu zeichnen
		else
			merkeKoordinaten(x, y);
		lastMouseEvent = e;
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
				this.gestartet();
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
						.getForeground(), fullr));
				break;
			case ROUNDED_RECTANGLE:
			case ROUNDED_RECTANGLE_FULL:
				boolean fullrr = (modus == Modus.ROUNDED_RECTANGLE_FULL);
				view.addDrawable(new RoundedRectangle(lastX, lastY, x, y, view
						.getForeground(), fullrr));
				break;
			case OVAL:
			case OVAL_FULL:
				boolean fullo = (modus == Modus.OVAL_FULL);
				view.addDrawable(new Oval(lastX, lastY, x, y, view
						.getForeground(), fullo));
				break;
			default:
			}
			merkeKoordinaten(x, y);
			lastMouseEvent = e;
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

	@SuppressWarnings("unused")
	private void save(String filename, Drawable[] d) {
		int length = view.getIndex();
		ObjectOutputStream outputStream = null;
		try {
			outputStream = new ObjectOutputStream(
					new FileOutputStream(filename));
			for (int i = 0; i < length; i++) {
				outputStream.writeObject(d[i]);
			}
			outputStream.flush();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (outputStream != null)
				try {
					outputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
				}
		}
	}

	@SuppressWarnings("unused")
	private void load(String filename, Drawable[] d) {
		int index = 0;
		ObjectInputStream inputStream = null;
		Object o;
		try {
			inputStream = new ObjectInputStream(new FileInputStream(filename));
			while ((o = inputStream.readObject()) != null) {
				d[index++] = (Drawable) o;
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
				}
			} else {
				view.setIndex(index);
				if (index < MyDrawingPanel3.MAX_DRAWABLES)
					view.getDrawables()[index] = null;
			}
		}
	}

	/**
	 * SHIFT für Vergrößerung ALT für Pixel-Schritte
	 */
	@Override
	public void keyPressed(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_SHIFT)
			shift = true;
		else if (ke.getKeyCode() == KeyEvent.VK_ALT)
			alt = true;
	}

	/**
	 * Letztes Element wird in die Richtungen verschoben, vergrößert (SHIFT+)
	 * oder verkleinert (SHIFT+)
	 */
	@Override
	public void keyReleased(KeyEvent ke) {

		if (view.isGestartet()) {
			switch (ke.getKeyCode()) {
			case KeyEvent.VK_HOME:
				this.homePosition();break;
			case KeyEvent.VK_LEFT:
			case KeyEvent.VK_RIGHT:
			case KeyEvent.VK_UP:
			case KeyEvent.VK_DOWN:
				// Letztes Element geholt
				Drawable d = view.getDrawables()[view.getIndex() - 1];
				if (ke.getKeyCode() == KeyEvent.VK_LEFT) { // Taste Left
					int diff = d.getStartX();
					int start = diff;
					// Bei ALT+ 1 ansonsten 5 Pixel
					start = (alt) ? start - 1 : start - 5;
					diff = start - diff;
					if(shift)
						start = (alt) ? start + 1 : start + 5;
					start = (start < 0) ? 0 : start;
					
					// Bei SHIFT wird der Startpunkt belassen
					if (!shift)
						d.setStartX(start);
					
						
					d.setEndX(d.getEndX() + diff);
				}
				if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {// Taste Right
					int diff = d.getStartX();
					int start = diff;
					// Bei ALT+ 1 ansonsten 5 Pixel
					start = (alt) ? start + 1 : start + 5;
					diff = start - diff;
					// Bei SHIFT wird der Startpunkt belassen
					if (!shift)
						d.setStartX(start);
					d.setEndX(d.getEndX() + diff);
				}
				if (ke.getKeyCode() == KeyEvent.VK_UP) {
					int diff = d.getStartY();
					int start = diff;
					// Bei ALT+ 1 ansonsten 5 Pixel
					start = (alt) ? start - 1 : start - 5;
					diff = start - diff;
					if(shift)
						start = (alt) ? start + 1 : start + 5;
					// Bei SHIFT wird der Startpunkt belassen
					start = (start < 0) ? 0 : start;
					if(!shift)
						d.setStartY(start);
					d.setEndY(d.getEndY() + diff);
				}
				if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
					int diff = d.getStartY();
					int start = diff;
					// Bei ALT+ 1 ansonsten 5 Pixel
					start = (alt) ? start + 1 : start + 5;
					diff = start - diff;
					// Bei SHIFT wird der Startpunkt belassen
					if (!shift)
						d.setStartY(start);
					d.setEndY(d.getEndY() + diff);

				}
				view.repaint(); // Anzeige aktualisieren
				break;
			case KeyEvent.VK_SHIFT:
				shift = false; // SHIFT und
				break;
			case KeyEvent.VK_ALT:
				alt = false; // ALT zurücksetzen
				break;
			}

			
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
	}
	/**
	 * Element in Homeposition setzen
	 */
	private void homePosition(){
		view.getDrawables()[view.getIndex()-1].setHomePosition();
		view.repaint();
	}
	/**
	 * Neues Zeichenbrett erstellen
	 */
	private void newNotePad(){
		if (!view.isEmtpy()) {
			if (JOptionPane.showConfirmDialog(frame,
					"Die aktuelle Zeichnung wird verworfen!",
					"Warnung", JOptionPane.YES_NO_OPTION,
					JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
				view.setEmtpy();
				view.setFocusable(true);
				frame.disableEditMenu();
				view.repaint();
			}
		}
	}
	/**
	 * Zeigt die Hilfe als Dialog an
	 */
	private void showHelp(){
		JOptionPane.showMessageDialog(frame,
				"Menü Datei: Mit Neu kann ein neues Zeichenbrett erstellt werden\n\n"+
				"Menü Bearbeiten: Einzelne Elemente löschen oder wiederherstellen\n\n"+
				"Zeichen: Verschieden Zeichenmethoden\n\n"+
				"Erweiterte Möglichkeiten Tastatur:\n"+
				"Elemente können mit Pfeiltaste  um 5 Pixel verschoben werden.\n"+
				"Elemente können mit Pfeiltasten und ALT un 1 Pixel verschoben werden.\n"+
				"Elemente können mit Pfeiltasten und SHIFT vergrößert und verkleinert werden.\n", 
						"Hilfe",
				JOptionPane.OK_OPTION);
	}
	private void deleteItem(){
		view.deleteDrawable();
		view.repaint();
	}
	private void restoreItem(){
		view.restoreDrawable();
		view.repaint();
	}
	private void notImplementedYet(){
		JOptionPane.showMessageDialog(frame, "Not implemented yet!",
				"Info", JOptionPane.OK_OPTION);
	}
	private void gestartet(){
		view.setGestartet(true);
		frame.enableEditMenu();
	}
}
