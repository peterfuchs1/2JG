package sw;
import java.awt.*;

import javax.swing.*;
/**
 * Die Klasse Zeichnung stellt als Zeichenfläche
 * ein JPanel in einem JFrame zur Verfügung.
 *
 * @author Walter Rafeiner-Magor
 * @version 1.0
 */
public class MyDrawingFrame extends JFrame
{
    /**
     * Der Konstruktor erzeugt ein JPanel
     * legt eine fixe Größe an.
     */
    public MyDrawingFrame()
    {
    	super("Zeichenbrett");		// Titel gesetzt
        MyDrawingPanel p = new MyDrawingPanel();	// neues Panel erstellt
        p.setBackground(new Color(240, 230, 140)); 
        this.add(p);				// Im Center verankert
        this.setSize(800,600);		// Größe festgelegt
        this.setResizable(false);	// und fixiert
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);		// Fenster nun sichtbar
   }
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
       new MyDrawingFrame();
    }
} 