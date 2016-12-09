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
public class MyDrawingTextFrame extends JFrame
{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8413764388780249600L;
	/**
     * Der Konstruktor erzeugt ein JPanel
     * legt eine fixe Gr��e an.
     */
    public MyDrawingTextFrame()
    {
    	super("Zeichenbrett");		// Titel gesetzt
    	MyDrawingTextPanel p = new MyDrawingTextPanel("SEW ist mein Lieblingsfach!");	// neues Panel erstellt
    	this.setBackground(new Color(240,230,140));
        this.add(p);				// Im Center verankert
        this.setSize(800,600);		// Gr��e festgelegt
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