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
public class MyDrawingFrame3 extends JFrame
{	
	private JRadioButtonMenuItem itemFreehand; 	// Freihandzeichnen
	private JRadioButtonMenuItem itemLine;		// Linien zeichnen
	private JRadioButtonMenuItem itemRectangle;	// Linien zeichnen
	private JRadioButtonMenuItem itemOval;		// Linien zeichnen
	private JRadioButtonMenuItem itemRectangleFull;	// Linien zeichnen
	private JRadioButtonMenuItem itemOvalFull;		// Linien zeichnen
	
	private JMenuItem itemForeground;			// Stiftfarbe
	private JMenuItem itemBackground;			// Hintergrundfarbe
	private JMenuItem itemInfo;					// About

	
    /**
     * Konstruktor
     * @param view	MyJPanel
     * @param lc	Controller-Klasse
     */
    public MyDrawingFrame3(MyDrawingPanel3 view,LineController lc)
    {
    	super("Zeichenbrett");					// Titel gesetzt    
    	JMenuBar menuBar=new JMenuBar();		// MenuBar erstellt
    	//////////////////////////////////
    	// erstes Men�: Modus
    	JMenu menuModus=new JMenu("Modus");
    	//// Gruppe erstellt
    	ButtonGroup group = new ButtonGroup();
    	//// RadioButton-Men�eintrag f�r Freihandzeichnen
    	itemFreehand = new JRadioButtonMenuItem("Freihand zeichnen");
    	itemFreehand.addActionListener(lc);		// Listener anmelden
    	group.add(itemFreehand);				// zur Gruppe hinzuf�gen
    	menuModus.add(itemFreehand);			// zum Men� hinzuf�gen
    	//// RadioButton-Men�eintrag f�r Linien zeichnen    	
    	itemLine=new JRadioButtonMenuItem("Linien zeichnen");
    	itemLine.addActionListener(lc);			// Listener anmelden
    	group.add(itemLine);					// zur Gruppe hinzuf�gen
    	menuModus.add(itemLine);				// zum Men� hinzuf�gen
    	//// RadioButton-Men�eintrag f�r Rechtecke zeichnen    	
       	itemRectangle=new JRadioButtonMenuItem("Rechtecke zeichnen");
       	itemRectangle.addActionListener(lc);			// Listener anmelden
       	group.add(itemRectangle);					// zur Gruppe hinzuf�gen
       	menuModus.add(itemRectangle);				// zum Men� hinzuf�gen
       	//// RadioButton-Men�eintrag f�r Ellipsen zeichnen    	
       	itemOval=new JRadioButtonMenuItem("Ellipsen zeichnen");
       	itemOval.addActionListener(lc);			// Listener anmelden
       	group.add(itemOval);					// zur Gruppe hinzuf�gen
       	menuModus.add(itemOval);				// zum Men� hinzuf�gen
       	/// Separator hinzuf�gen
    	JSeparator js1=new JSeparator();
    	menuModus.add(js1);
    	//// RadioButton-Men�eintrag f�r Rechtecke ausmalen    	
       	itemRectangleFull=new JRadioButtonMenuItem("Rechtecke ausmalen");
       	itemRectangleFull.addActionListener(lc);			// Listener anmelden
       	group.add(itemRectangleFull);					// zur Gruppe hinzuf�gen
       	menuModus.add(itemRectangleFull);				// zum Men� hinzuf�gen
       	//// RadioButton-Men�eintrag f�r Ellipsen ausmalen    	
       	itemOvalFull=new JRadioButtonMenuItem("Ellipsen ausmalen");
       	itemOvalFull.addActionListener(lc);			// Listener anmelden
       	group.add(itemOvalFull);					// zur Gruppe hinzuf�gen
       	menuModus.add(itemOvalFull);				// zum Men� hinzuf�gen
    	menuBar.add(menuModus);					// zur MenuBar hinzuf�gen
    	//////////////////////////////////
    	// zweites Men�: Farbe    	
    	JMenu menuColor=new JMenu("Farbe");
    	//// Men�eintrag: Stiftfarbe
    	itemForeground=new JMenuItem("Farbe Stift");
    	itemForeground.addActionListener(lc);	// Listener anmelden
    	menuColor.add(itemForeground);			// zum Men� hinzuf�gen
    	//// Men�eintrag: Hintergrundfarbe
    	itemBackground=new JMenuItem("Farbe Hintergrund");
    	itemBackground.addActionListener(lc);	// Listener anmelden
    	menuColor.add(itemBackground);			// zum Men� hinzuf�gen
    	menuBar.add(menuColor);					// zur MenuBar hinzuf�gen
    	//////////////////////////////////
    	// drittes Men�: About    	    	
    	JMenu menuInfo=new JMenu("About");    	
    	//// Men�eintrag: Info    	
    	itemInfo=new JMenuItem("Info");
    	itemInfo.addActionListener(lc);			// Listener anmelden
    	menuInfo.add(itemInfo);					// zum Men� hinzuf�gen
    	menuBar.add(Box.createHorizontalGlue());// Men� rechtsb�ndig einf�gen
    	menuBar.add(menuInfo);					// zur MenuBar hinzuf�gen
    	this.setJMenuBar(menuBar);				// MenuBar im JFrame setzen
    	
        this.add(view);				// MyJPanel Im Center verankert
        this.setSize(800,600);		// Startgr��e festgelegt
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);		// Fenster nun sichtbar
   }
	/**
	 * @return the itemInfo
	 */
	public JMenuItem getItemInfo() {
		return itemInfo;
	}
	/**
	 * @return the itemFreehand
	 */
	public JMenuItem getItemFreehand() {
		return itemFreehand;
	}
	/**
	 * @return the itemLine
	 */
	public JMenuItem getItemLine() {
		return itemLine;
	}
	/**
	 * @return the itemForeground
	 */
	public JMenuItem getItemForeground() {
		return itemForeground;
	}
	/**
	 * @return the itemBackground
	 */
	public JMenuItem getItemBackground() {
		return itemBackground;
	}
	
	/**
	 * @return the itemRectangle
	 */
	public JRadioButtonMenuItem getItemRectangle() {
		return itemRectangle;
	}
	/**
	 * @return the itemOval
	 */
	public JRadioButtonMenuItem getItemOval() {
		return itemOval;
	}
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// gestartet wird der Controller
		new LineController();
	}
	/**
	 * @return the itemRectangleFull
	 */
	public JRadioButtonMenuItem getItemRectangleFull() {
		return itemRectangleFull;
	}
	/**
	 * @return the itemOvalFull
	 */
	public JRadioButtonMenuItem getItemOvalFull() {
		return itemOvalFull;
	}
	
} 