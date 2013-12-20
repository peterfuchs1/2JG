/**
 * 
 */
package paint;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 * Controller f�r Zeichenbrett Actionlistener: JMenuItems im Frame MouseAdapter:
 * View
 * 
 * @author Walter Rafeiner-Magor
 * @version 2.0
 */
public class MyController extends MouseAdapter implements ActionListener,
		KeyListener {
	private MyPanel view; // MyJPanel
	private MyFrame frame; // MyFrame
	private int lastX; // letzte X-Koordinaten
	private int lastY; // letzte Y-Koordinaten
	private Modus modus; // Welcher Modus ist aktiv?
	private MouseEvent lastMouseEvent = null;
	private boolean alt, shift;// SHIFT- und ALT-Taste

	public MyController() {
		modus = Modus.FREEHAND; // Freihandzeichnen aktiviert
		view = new MyPanel(this); // Mit MyJPanel verkn�pft
		frame = new MyFrame(view, this); // Mit MyFrame verkn�pft
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
					// JColorChooser f�r die Elementfarbe
					Drawable d=view.getDrawables()[view.getIndex()-1];
					Color c=d.getColor();
							d.setColor(JColorChooser.showDialog(view,
							"Elementfarbe", c));
							view.repaint();}
				else if (item == frame.getItemDelete())  
						// Element L�schen
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
				// JColorChooser f�r die Stiftfarbe
				view.setForeground(JColorChooser.showDialog(view, "Stiftfarbe",
						view.getForeground())); 
				// ausw�hlen und setzen
			else if (item == frame.getItemBackground()) 
				// JColorChooser f�r die Hintergrundfarbe
				view.setBackground(JColorChooser.showDialog(view,
						"Hintergrund", view.getBackground())); 
				// ausw�hlen und setzen
			else if (item == frame.getItemAbout()) 
				// Info der Applikation anzeigen
				this.about();
			else if (item == frame.getItemHelp())  
				// Hilfe der Applikation anzeigen
				 this.showHelp();
			else if (item == frame.getItemLoad()){ 
				// File laden
				File file=this.fileChooser();
				if(file!=null)
					this.load(file, view.getDrawables());
			}
			else if (item == frame.getItemSave()){  
				// File speichern
				File file=this.fileChooser();
				if(file!=null)
					this.save(file, view.getDrawables());
			}
		}
	}
	/**
	 * About
	 */
	private void about() {
		JOptionPane.showMessageDialog(frame,
				"Zeichenbrett v2.0\n(c) Walter Rafeiner-Magor", "Info",
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
	 * einen Mousebutton losl�sst.
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
	/**
	 * Speichere den Inhalt des Drawable-Array in ein File
	 * @param file
	 * @param d
	 */
	private void save(File file, Drawable[] d) {
		int length = view.getIndex();
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(
					new FileOutputStream(file));
			Drawable[] dneu=Arrays.copyOfRange(d, 0, length);
			// Speichert Hintergrundfarbe 
			oos.writeObject(view.getBackground());
			// Speichert das Drawable-Array
			oos.writeObject(dneu);
			// Buffer leeren und schlie�en
			oos.flush();
			oos.close();
		}
		catch (IOException e) {
			JOptionPane.showMessageDialog(frame, "Das Speichern von " +file.getName()+" ist fehlgeschlagen!");
		} 
	}
	/**
	 * Auswahl eines Files
	 * @return File oder null
	 */
	private File fileChooser(){
		File ret=null;
		//Create a file chooser
		final JFileChooser fc = new JFileChooser();
		 int returnVal = fc.showOpenDialog(view);
		  if (returnVal == JFileChooser.APPROVE_OPTION) 
	            ret= fc.getSelectedFile();
	    return ret;        

	}
	/**
	 * Lade den Inhalt des Files in das Drawable-Array
	 * @param file File
	 * @param d Array
	 */
	private void load(File file, Drawable[] d) {
		int index = 0;
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(new FileInputStream(file));
			Drawable[] dneu;
			Color bg=(Color)ois.readObject();
			dneu=(Drawable []) ois.readObject();
			index=dneu.length;
			for(int i=0;i<index;i++)
				d[i]=dneu[i];
			view.setIndex(index);
			if (index < MyPanel.MAX_DRAWABLES)
				view.getDrawables()[index] = null;
			view.setGestartet(true);
			view.setBackground(bg);
			frame.enableEditMenu();
			view.repaint();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(frame, "Das Lesen von " +file.getName()+" ist fehlgeschlagen!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 	
	}

	/**
	 * SHIFT f�r Vergr��erung ALT f�r Pixel-Schritte
	 */
	@Override
	public void keyPressed(KeyEvent ke) {
		if (ke.getKeyCode() == KeyEvent.VK_SHIFT)
			shift = true;
		else if (ke.getKeyCode() == KeyEvent.VK_ALT)
			alt = true;
	}

	/**
	 * Letztes Element wird in die Richtungen verschoben, vergr��ert (SHIFT+)
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
				alt = false; // ALT zur�cksetzen
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
				view.setBackground(Color.LIGHT_GRAY);
				view.repaint();
			}
		}
	}
	/**
	 * Zeigt die Hilfe als Dialog an
	 */
	private void showHelp(){
		JOptionPane.showMessageDialog(frame,
				"Men� Datei: Mit Neu kann ein neues Zeichenbrett erstellt werden\n\n"+
				"Men� Bearbeiten: Einzelne Elemente l�schen oder wiederherstellen\n\n"+
				"Zeichen: Verschieden Zeichenmethoden\n\n"+
				"Erweiterte M�glichkeiten Tastatur:\n"+
				"Elemente k�nnen mit Pfeiltaste  um 5 Pixel verschoben werden.\n"+
				"Elemente k�nnen mit Pfeiltasten und ALT un 1 Pixel verschoben werden.\n"+
				"Elemente k�nnen mit Pfeiltasten und SHIFT vergr��ert und verkleinert werden.\n", 
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
