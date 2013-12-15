package sw;
import java.awt.*;
import java.awt.event.*;

import javax.swing.JPanel;
/**
 * Ein JPanel, mit inneren anonymen Adapterklassen.
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
    	gestartet=false;			// noch kein Mausereignis stattgefunden
    	// innere anonyme Klasse 
        this.addMouseListener(new MouseAdapter(){
        	/** 
    	     * Eine Methode des MouseListener Interface.
    	     * Wird aufgerufen, wenn der User einen Mousebutton drueckt.
    	     */
        	@Override
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
        }
        );// ACHTUNG ); nicht vergessen!!
        
        // innere anonyme Klasse 
        this.addMouseMotionListener(new MouseMotionAdapter(){
        	 /** 
    	      * Eine Methode des MouseMotionListener interface.
    	      * Wird aufgerufen, wenn der User die Maus mit gedruecktem Button zieht.
    	      */
        	 @Override
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
        }	
        );// ACHTUNG ); nicht vergessen!!
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
  } 