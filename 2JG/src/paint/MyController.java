/**
 * 
 */
package paint;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.AbstractButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

/**
 * Controller für Zeichenbrett Actionlistener: JMenuItems im Frame MouseAdapter:
 * View
 * 
 * @author Walter Rafeiner-Magor
 * @version 3.0
 */
public class MyController extends WindowAdapter implements ActionListener,
		KeyListener,MouseMotionListener, MouseListener {
//	Konstanten
	public static final int FAST=7;
	public static final int SLOW=1;
	
	private MyPanel view; // MyJPanel
	private MyFrame frame; // MyFrame
	private int lastX; // letzte X-Koordinaten
	private int lastY; // letzte Y-Koordinaten
	private Modus modus; // Welcher Modus ist aktiv?
	private MouseEvent lastMouseEvent = null;
	private boolean alt, shift;// SHIFT- und ALT-Taste

	public MyController() {
		modus = Modus.FREEHAND; // Freihandzeichnen aktiviert
		view = new MyPanel(this); // Mit MyJPanel verknüpft
		frame = new MyFrame(view, this); // Mit MyFrame verknüpft
		frame.getItemFreehand().setSelected(true); // JRadioButtonMenuItem
													// gesetzt
		alt = shift = false; // SHIFT- und ALT-Taste initialisiert
    	this.initColor();				// Black on White und 
		this.updateButtonColor();		// Buttonfarben aktualisieren
	}

	/*
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent ae) {
		Object o = ae.getSource();
		if (o instanceof AbstractButton) { // Falls Objekt der Klasse JMenuItem
			AbstractButton item = (AbstractButton) o; // Cast to JMenuItem
			if (view.isGestartet()) {// bereits gestartet !!
				if (item == frame.getItemDuplicate()) {
					// Element duplizieren
					view.addDrawable(view.getDrawables()[view.getIndex() - 1]
							.clone());
					view.repaint();
				} else if (item == frame.getItemHome())
					// Element in Homeposition
					this.homePosition();
				else if (item == frame.getItemColor()) {
					// JColorChooser für die Elementfarbe
					Drawable d = view.getDrawables()[view.getIndex() - 1];
					Color c = d.getColor();
					Color fg=this.getColorChooser(view, "Elementfarbe", c);
					d.setColor(fg);
					view.setForeground(fg);
					this.setButtonColor(frame.getItemForeground(), fg);
					view.repaint();
				} else if (item == frame.getItemDelete())
					// Element Löschen
					this.deleteItem();
				else if (item == frame.getItemRestore())
					// Element wiederherstellen
					this.restoreItem();
			} else {/* noch nicht gestartet */
			}
			if (item == frame.getItemNew())
				// Neues Zeichenbrett
				this.newNotePad();
			else if (item == frame.getItemFreehand()) // Freihandzeichnen
				modus = Modus.FREEHAND; // aktivieren
			else if (item == frame.getItemText()) // Text
				modus = Modus.TEXT; // aktivieren
			else if (item == frame.getItemLine())
				// Linien zeichnen
				modus = Modus.LINES;
			else if (item == frame.getItemRectangle())
				// Rechteck zeichnen
				modus = Modus.RECTANGLE;
			else if (item == frame.getItemOval())
				// Ellipse zeichnen
				modus = Modus.OVAL;
			else if (item == frame.getItemPolygon())
				// Polygon zeichnen
				modus = Modus.POLYGON;
			else if (item == frame.getItemPolygonFull())
				// Polygon zeichnen
				modus = Modus.POLYGON_FULL;
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
			else if ( item ==frame.getItemForeground()){
				// JColorChooser für die Stiftfarbe
				Color bg=this.getColorChooser(view, "Stiftfarbe", view.getForeground());
				view.setForeground(bg);
				this.setButtonColor(item, bg);
			}
			// auswählen und setzen
			else if (item ==frame.getItemBackground()){
				// JColorChooser für die Hintergrundfarbe
			Color bg=this.getColorChooser(view, "Hintergrundfarbe", view.getBackground()); 
			view.setBackground(bg);
			this.setButtonColor(item, bg);
			}
			// auswählen und setzen
			else if (item == frame.getItemAbout())
				// Info der Applikation anzeigen
				this.about();
			else if (item == frame.getItemHelp())
				// Hilfe der Applikation anzeigen
				this.showHelp();
			else if (item == frame.getItemLoad()) 
				// File laden
				this.load();
			else if (item == frame.getItemSave()) 
				// File speichern
				this.save();
		}
	}

	/**
	 * About
	 */
	private void about() {
		JOptionPane.showMessageDialog(frame,
				"Zeichenbrett v3.0\n(c) Walter Rafeiner-Magor", "Info",
				JOptionPane.OK_OPTION);
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
		switch(modus){
		case FREEHAND:
			view.addDrawable(new Line(x, y, x, y, view.getForeground()));
			break;
		case POLYGON:
			view.addDrawable(new MyPolygon(x, y, x, y, view.getForeground()));
			break;
		case POLYGON_FULL:
			view.addDrawable(new MyPolygon(x, y, x, y, view.getForeground(),true));
			break;
		}
			
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
		if (modus != Modus.FREEHAND && 
			modus !=Modus.POLYGON && 
			modus!=Modus.POLYGON_FULL&& 
			lastMouseEvent != null
				&& lastMouseEvent.getID() == MouseEvent.MOUSE_DRAGGED)
			// letzte Linie vergessen
			view.deleteDrawable();
		switch (modus) { // Figuren zeichnen
		case TEXT:
			this.notImplementedYet();
			break;
		case FREEHAND:{
			view.getDrawables()[view.getIndex()-1].addPoint(x, y);
			break;}
		case LINES:
			view.addDrawable(new Line(lastX, lastY, x, y, view.getForeground()));
			break;
		case POLYGON_FULL:
		case POLYGON:
			view.getDrawables()[view.getIndex()-1].addPoint(x, y);
			break;
		case RECTANGLE_FULL:
		case RECTANGLE:
			boolean fullr = (modus == Modus.RECTANGLE_FULL);
			view.addDrawable(new MyRectangle(lastX, lastY, x, y, view
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
		view.repaint(); // neu zeichnen
		// letztes MausEvent merken
		lastMouseEvent = e;
	}

	/**
	 * Eine Methode des MouseListener Interface. Wird aufgerufen, wenn der User
	 * einen Mousebutton loslässt.
	 */
	public void mouseReleased(MouseEvent e) {
		if (modus != Modus.FREEHAND && modus !=Modus.POLYGON&& modus !=Modus.POLYGON_FULL) {
			int x = e.getX(); // Liefert X-Koordinaten des Mausklicks!
			int y = e.getY(); // Liefert Y-Koordinaten des Mausklicks!
			if (!view.isGestartet()) {
				this.gestartet();
				merkeKoordinaten(x, y);
			}
			// Dragged Version vergessen!
			if(lastMouseEvent.getID()!=MouseEvent.MOUSE_RELEASED)
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
				view.addDrawable(new MyRectangle(lastX, lastY, x, y, view
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
			}
			merkeKoordinaten(x, y);
		}
			lastMouseEvent = e;
		
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
				this.homePosition();
				break;
			case KeyEvent.VK_LEFT:
			case KeyEvent.VK_RIGHT:
			case KeyEvent.VK_UP:
			case KeyEvent.VK_DOWN:
				// Letztes Element geholt
				Drawable d = view.getDrawables()[view.getIndex() - 1];
				java.awt.Rectangle r=d.p.getBounds();
				if (ke.getKeyCode() == KeyEvent.VK_LEFT) { // Taste Left
					// d.getStartX();
					int start = d.p.xpoints[0];
					// Bei ALT+ 1 ansonsten 5 Pixel
					int diff = (alt)?-SLOW:-FAST;
					if(r.x+diff<0)
							diff=-r.x;
					// um diff verschieben
					d.p.translate(diff, 0);
					// Bei SHIFT wird der Startpunkt belassen
					if(shift&& modus!=Modus.POLYGON&&modus!=Modus.POLYGON_FULL)
						d.p.xpoints[0]=start;

				}
				if (ke.getKeyCode() == KeyEvent.VK_RIGHT) {// Taste Right
					int start = d.p.xpoints[0];
					// Bei ALT+ 1 ansonsten 5 Pixel
					int diff = (alt)?+SLOW:+FAST;
					// um diff verschieben
					d.p.translate(diff, 0);
					// Bei SHIFT wird der Startpunkt belassen
					if(shift&& modus!=Modus.POLYGON&&modus!=Modus.POLYGON_FULL)
						d.p.xpoints[0]=start;
				}
				if (ke.getKeyCode() == KeyEvent.VK_UP) {
					int start = d.p.ypoints[0];
					// Bei ALT+ 1 ansonsten 5 Pixel
					int diff = (alt)?-SLOW:-FAST;
					if(r.y+diff<0)
						diff=-r.y;
					// um diff verschieben
					d.p.translate(0,diff);
					// Bei SHIFT wird der Startpunkt belassen
					if(shift&& modus!=Modus.POLYGON&&modus!=Modus.POLYGON_FULL)
						d.p.ypoints[0]=start;
				}
				if (ke.getKeyCode() == KeyEvent.VK_DOWN) {
					int start = d.p.ypoints[0];
					// Bei ALT+ 1 ansonsten 5 Pixel
					int diff = (alt)?+SLOW:+FAST;
					// um diff verschieben
					d.p.translate(0,diff);
					// Bei SHIFT wird der Startpunkt belassen
					if(shift&& modus!=Modus.POLYGON&&modus!=Modus.POLYGON_FULL)
						d.p.ypoints[0]=start;

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
	private void homePosition() {
		view.getDrawables()[view.getIndex() - 1].setHomePosition();
		view.repaint();
	}

	/**
	 * Neues Zeichenbrett erstellen
	 */
	private void newNotePad() {
		if (!view.isEmtpy()) {
			if (JOptionPane.showConfirmDialog(frame,
					"Die aktuelle Zeichnung wird verworfen!", "Warnung",
					JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE) == JOptionPane.YES_OPTION) {
				view.setEmtpy();
				view.setFocusable(true);
				frame.disableEditMenu();
				this.initColor();
				this.updateButtonColor();
				view.repaint();
			}
		}
	}

	/**
	 * Zeigt die Hilfe als Dialog an
	 */
	private void showHelp() {
		JOptionPane
				.showMessageDialog(
						frame,
						"Menü Datei: Mit Neu kann ein neues Zeichenbrett erstellt werden\n\n"
								+ "Menü Bearbeiten: Einzelne Elemente löschen oder wiederherstellen\n\n"
								+ "Zeichen: Verschieden Zeichenmethoden\n\n"
								+ "Erweiterte Möglichkeiten Tastatur:\n"
								+ "Elemente können mit Pfeiltaste  um 5 Pixel verschoben werden.\n"
								+ "Elemente können mit Pfeiltasten und ALT un 1 Pixel verschoben werden.\n"
								+ "Elemente können mit Pfeiltasten und SHIFT vergrößert und verkleinert werden.\n",
						"Hilfe", JOptionPane.OK_OPTION);
	}

	private void deleteItem() {
		view.deleteDrawable();
		view.repaint();
	}

	private void restoreItem() {
		view.restoreDrawable();
		view.repaint();
	}

	private void notImplementedYet() {
		JOptionPane.showMessageDialog(frame, "Not implemented yet!", "Info",
				JOptionPane.OK_OPTION);
	}

	private void gestartet() {
		view.setGestartet(true);
		frame.enableEditMenu();
	}
	/**
	 * Speichere den Inhalt des Drawable-Array in ein File
	 * 
	 * @param file
	 * @param d
	 */
	private void save() {
		File file = null;
		// Create a file chooser
		final JFileChooser fc = new JFileChooser();
		if(fc.showSaveDialog(view)== JFileChooser.APPROVE_OPTION)
				file = fc.getSelectedFile();
		if (file == null){
			JOptionPane.showMessageDialog(frame, 
					"Die aktuelle Zeichnung"
					+ " wurde nicht gespeichert!");
			return;
		}
		Drawable[] d= view.getDrawables();
		int length = view.getIndex();
		int ok = JOptionPane.YES_OPTION;
		if (file.exists())
			ok = JOptionPane.showConfirmDialog(frame,
					"Soll das File " + file.getName()
							+ " überschrieben werden?", "Speichern",
					JOptionPane.YES_NO_OPTION);
		if (ok == JOptionPane.YES_OPTION) {
			ObjectOutputStream oos = null;
			try {
				oos = new ObjectOutputStream(new FileOutputStream(file));
				Drawable[] dneu = Arrays.copyOfRange(d, 0, length);
				// Speichert Hintergrundfarbe
				oos.writeObject(view.getBackground());
				// Speichert das Drawable-Array
				oos.writeObject(dneu);
				// Buffer leeren und schließen
				oos.flush();
				oos.close();
				JOptionPane.showMessageDialog(frame,
						"Das File" + file.getName()
								+ "\nwurde erfolgreich gespeichert!");
			} catch (IOException e) {
				JOptionPane.showMessageDialog(frame, "Das Speichern von "
						+ file.getName() + " ist fehlgeschlagen!");
			}
		}
	}

	/**
	 * Lade den Inhalt des Files in das Drawable-Array
	 * 
	 * @param file
	 *            File
	 * @param d
	 *            Array
	 */
	private void load() {
		File file = null;
		// Create a file chooser
		final JFileChooser fc = new JFileChooser();
		if(fc.showOpenDialog(view)== JFileChooser.APPROVE_OPTION)
				file = fc.getSelectedFile();
		
		if (file == null) return;
		Drawable[] d= view.getDrawables();
		int index = 0;
		int ok = JOptionPane.YES_OPTION;
		if (!view.isEmtpy())
			ok = JOptionPane.showConfirmDialog(
					frame,
					"Soll die aktuelle Zeichnung mit dem File "
							+ file.getName() + " überschrieben werden?",
					"Laden", JOptionPane.YES_NO_OPTION);
		if (ok == JOptionPane.YES_OPTION) {
			ObjectInputStream ois = null;
			try {
				ois = new ObjectInputStream(new FileInputStream(file));
				Drawable[] dneu;
				Color bg = (Color) ois.readObject();
				dneu = (Drawable[]) ois.readObject();
				index = dneu.length;
				for (int i = 0; i < index; i++)
					d[i] = dneu[i];
				view.setIndex(index);
				if (index < MyPanel.MAX_DRAWABLES)
					view.getDrawables()[index] = null;
				view.setGestartet(true);
				Color fg=d[index-1].getColor();
				view.setForeground(fg);
				view.setBackground(bg);
				frame.enableEditMenu();
				updateButtonColor();
				view.repaint();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(frame,
						"Das Lesen von " + file.getName()
								+ " ist fehlgeschlagen!");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
	/**
	 * Color-Auswahl mittels JColorChooser
	 * @param c
	 * @param title
	 * @param old
	 * @return new Color oder bei Cancel: old Color
	 */
	private Color getColorChooser(Component c,String title, Color old){
		Color ret=JColorChooser.showDialog(c, title,old);
		return(ret!=null)?ret:old;
	}
	/**
	 * Farbbutton initialisieren
	 * Schriftfarbe: Black
	 * Hintergrundfarbe: White
	 */
	public void initColor(){
		view.setForeground(Color.BLACK);
		view.setBackground(Color.WHITE);
	}
	/**
	 * Ein spezieller Button
	 * mit gegebener Farbe (background)
	 * und Kontrastfarbe (foreground)
	 * setzen
	 * @param b
	 * @param bg
	 */
	public void setButtonColor(AbstractButton b, Color bg){
		//  convert the RGB values into YUV values. 
		// As we are only interested in the brightness value (represented by Y)
		 double y = (299 * bg.getRed() + 587 * bg.getGreen() + 114 * bg.getBlue()) / 1000;
		  Color fg= (y >= 128) ? Color.BLACK : Color.WHITE;
		b.setForeground(fg);
		b.setBackground(bg);
	}
	/**
	 * Farbbutton anhand der derzeitigen Farben
	 * setzen
	 */
	public void updateButtonColor(){
		this.setButtonColor(frame.getItemForeground(),view.getForeground());
		this.setButtonColor(frame.getItemBackground(),view.getBackground());
	}
	@Override
	public void windowClosed(WindowEvent arg0) {System.exit(0);}
		
	/* (non-Javadoc)
	 * @see java.awt.event.WindowListener#windowClosing(java.awt.event.WindowEvent)
	 */
	@Override
	public void windowClosing(WindowEvent we) {
		int ok=JOptionPane.CANCEL_OPTION;
		ok=JOptionPane.showConfirmDialog(null, "Soll die aktuelle Zeichnung gespeichert werden?");
		switch(ok){
		case JOptionPane.YES_OPTION:
			this.save();
		case JOptionPane.NO_OPTION:
			we.getWindow().dispose(); // Fenster geschlossen
			break;
		default: // do nothing
		    frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		}
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {}

	@Override
	public void mouseEntered(MouseEvent arg0) {}

	@Override
	public void mouseExited(MouseEvent arg0) {}

	@Override
	public void mouseMoved(MouseEvent arg0) {}


}
