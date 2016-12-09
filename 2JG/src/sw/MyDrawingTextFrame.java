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
public class MyDrawingTextFrame extends JFrame
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8413764388780249600L;
	/**
     * Der Konstruktor erzeugt ein JPanel
     * legt eine fixe Größe an.
     */
    public MyDrawingTextFrame()
    {
    	super("Zeichenbrett");		// Titel gesetzt
    	MyDrawingTextPanel p = new MyDrawingTextPanel("SEW ist mein Lieblingsfach!");	// neues Panel erstellt
    	this.setBackground(new Color(240,230,140));
        this.add(p);				// Im Center verankert
        this.setSize(800,600);		// Größe festgelegt
        this.setResizable(false);	// und fixiert
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);		// Fenster nun sichtbar
        this.getInsets().top=20;
   }
    /**
     * 
     * @param args
     */
    public static void main(String[] args) {
       new MyDrawingTextFrame();
    }
} 