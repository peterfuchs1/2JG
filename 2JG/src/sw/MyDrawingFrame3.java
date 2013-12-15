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
public class MyDrawingFrame3 extends JFrame
{	
	private JRadioButtonMenuItem itemFreehand; 	// Freihandzeichnen
	private JRadioButtonMenuItem itemLine;		// Linien zeichnen
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
    	// erstes Menü: Modus
    	JMenu menuModus=new JMenu("Modus");
    	//// Gruppe erstellt
    	ButtonGroup group = new ButtonGroup();
    	//// RadioButton-Menüeintrag für Freihandzeichnen
    	itemFreehand = new JRadioButtonMenuItem("Freihand zeichnen");
    	itemFreehand.addActionListener(lc);		// Listener anmelden
    	group.add(itemFreehand);				// zur Gruppe hinzufügen
    	menuModus.add(itemFreehand);			// zum Menü hinzufügen
    	//// RadioButton-Menüeintrag für Linien zeichnen    	
    	itemLine=new JRadioButtonMenuItem("Linien zeichnen");
    	itemLine.addActionListener(lc);			// Listener anmelden
    	group.add(itemLine);					// zur Gruppe hinzufügen
    	menuModus.add(itemLine);				// zum Menü hinzufügen
    	menuBar.add(menuModus);					// zur MenuBar hinzufügen
    	//////////////////////////////////
    	// zweites Menü: Farbe    	
    	JMenu menuColor=new JMenu("Farbe");
    	//// Menüeintrag: Stiftfarbe
    	itemForeground=new JMenuItem("Farbe Stift");
    	itemForeground.addActionListener(lc);	// Listener anmelden
    	menuColor.add(itemForeground);			// zum Menü hinzufügen
    	//// Menüeintrag: Hintergrundfarbe
    	itemBackground=new JMenuItem("Farbe Hintergrund");
    	itemBackground.addActionListener(lc);	// Listener anmelden
    	menuColor.add(itemBackground);			// zum Menü hinzufügen
    	menuBar.add(menuColor);					// zur MenuBar hinzufügen
    	//////////////////////////////////
    	// drittes Menü: About    	    	
    	JMenu menuInfo=new JMenu("About");    	
    	//// Menüeintrag: Info    	
    	itemInfo=new JMenuItem("Info");
    	itemInfo.addActionListener(lc);			// Listener anmelden
    	menuInfo.add(itemInfo);					// zum Menü hinzufügen
    	menuBar.add(Box.createHorizontalGlue());// Menü rechtsbündig einfügen
    	menuBar.add(menuInfo);					// zur MenuBar hinzufügen
    	this.setJMenuBar(menuBar);				// MenuBar im JFrame setzen
    	
        this.add(view);				// MyJPanel Im Center verankert
        this.setSize(800,600);		// Startgröße festgelegt
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
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// gestartet wird der Controller
		new LineController();
	}
} 