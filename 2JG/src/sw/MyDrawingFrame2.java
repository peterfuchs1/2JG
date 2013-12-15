package sw;
import java.awt.*;

import javax.swing.*;
/**
 * Die Klasse Zeichnung stellt als Zeichenfl�che
 * ein JPanel in einem JFrame zur Verf�gung.
 *
 * @author Walter Rafeiner-Magor
 * @version 1.0
 */
public class MyDrawingFrame2 extends JFrame
{
    /**
     * Der Konstruktor erzeugt ein JPanel
     * legt eine fixe Gr��e an.
     */
    public MyDrawingFrame2()
    {
    	super("Zeichenbrett");		// Titel gesetzt
        MyDrawingPanel2 p = new MyDrawingPanel2();	// neues Panel erstellt
        this.add(p);				// Im Center verankert
        this.setSize(800,600);		// Gr��e festgelegt
        this.setResizable(false);	// und fixiert
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);		// Fenster nun sichtbar
   }
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
       new MyDrawingFrame2();
    }
} 