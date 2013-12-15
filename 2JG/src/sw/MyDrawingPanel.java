package sw;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;
/**
 * Ein JPanel, welches MouseListener und MouseMotionListener
 * realisiert.
 *
 * @author Walter Rafeiner-Magor
 * @version 1.1
 */
public class MyDrawingPanel extends JPanel               
{
	// damit die erste Linie beliebig starten kann
	private boolean gestartet;	
    private int lastX=0,lastY=0;	// Initialisierung 
    /**
     * Konstruktor meldet sich bei
     * MouseListener, MouseMotionListener
     * an
     */
    public MyDrawingPanel()
    {
    	MausEreignisse me=new MausEreignisse();
    	gestartet=false;			// noch kein Mausereignis stattgefunden
        this.addMouseListener(me);// Unsere innere Klasse kümmert sich um Mausereignisse
        this.addMouseMotionListener(me);//Unsere innere Klasse kümmert sich um Mausereignisse
    }

     /**
      * Sichert die letzten Koordinaten
      * @param x
      * @param y
      */
     private void merkeKoordinaten(int x, int y){
    	 	lastX=x;
 			lastY=y;
     }
     /**
      * Klasse erweitert MouseAdapter und implementiert
      * MouseMotionListener
      * @author Walter Rafeiner-Magor
      * @version 1.1
      */
     public class MausEreignisse extends MouseAdapter implements MouseMotionListener{
    	    /** 
    	     * Eine Methode des MouseListener Interface.
    	     * Wird aufgerufen, wenn der User einen Mousebutton drueckt.
    	     */
    	    public void mousePressed(MouseEvent e) {
    	        int x = e.getX();  // Liefert X-Koordinaten des Mausklicks!
    	        int y = e.getY();  // Liefert Y-Koordinaten des Mausklicks!
    	    	if(!gestartet){
    	    		gestartet=true;
    	    		merkeKoordinaten(x, y);
    	    	}
    	        Graphics g = getGraphics();
    	        g.drawLine(x, y, x, y); // Zeichnet Punkt: Anfangs- und Endpunkt identisch
    	        merkeKoordinaten(x, y);
    	    }

    	    /** 
    	     * Eine Methode des MouseMotionListener interface.
    	     * Wird aufgerufen, wenn der User die Maus mit gedruecktem Button zieht.
    	     */
    	     public void mouseDragged(MouseEvent e) {
    	        int x = e.getX();  // Liefert X-Koordinaten des Mausklicks!
    	        int y = e.getY();  // Liefert Y-Koordinaten des Mausklicks!
    	       	if(!gestartet){
    	    		gestartet=true;
    	    		merkeKoordinaten(x, y);
    	    	}
    	        Graphics g = getGraphics();
    	        g.drawLine(lastX, lastY, x, y);// Zeichnet Linie von Anfangs- bis Endpunkt
    	        merkeKoordinaten(x, y);
    	     }
    	     // Die andere, unbenutzte Methode des MouseMotionListener Interface.
    	     public void mouseMoved(MouseEvent e) {}
     }
  } 