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
	private JMenuItem itemNew;					// Neue Datei erzeugen
	private JMenuItem itemLoad;					// Aus Datei laden
	private JMenuItem itemSave;					// In Datei speichern
	private JMenuItem itemDelete;				// letzter Schritt r�ckg�ngig
	private JMenuItem itemRestore;				// letzter Schritt wiederhergestellt
	
	
	private JRadioButtonMenuItem itemFreehand; 	// Freihandzeichnen
	private JRadioButtonMenuItem itemLine;		// Linien zeichnen
	private JRadioButtonMenuItem itemRectangle;	// Rechteck zeichnen
	private JRadioButtonMenuItem itemOval;		// Ellipse zeichnen
	private JRadioButtonMenuItem itemRoundedRectangle;	// abgerundetes Rechteck zeichnen
	private JRadioButtonMenuItem itemRectangleFull;	// Rechteck ausmalen
	private JRadioButtonMenuItem itemOvalFull;		// Ellipse ausmalen
	private JRadioButtonMenuItem itemRoundedRectangleFull;	// abgerundetes Rechteck ausmalen
	
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
    	// erstes Men�: Datei
    	JMenu menuFile=new JMenu("Datei");
    	//// Men�eintrag: New
       	itemNew=new JMenuItem("Neu");
       	itemNew.addActionListener(lc);		// Listener anmelden
       	menuFile.add(itemNew);				// zum Men� hinzuf�gen
       	//// Men�eintrag: Laden
    	itemLoad=new JMenuItem("Laden...");
    	itemLoad.addActionListener(lc);		// Listener anmelden
    	menuFile.add(itemLoad);				// zum Men� hinzuf�gen
       	//// Men�eintrag: Speichern
    	itemSave=new JMenuItem("Speichern...");
    	itemSave.addActionListener(lc);		// Listener anmelden
    	menuFile.add(itemSave);				// zum Men� hinzuf�gen
    	menuBar.add(menuFile);
    	//////////////////////////////////
    	// erstes Men�: Bearbeiten
    	JMenu menuEdit=new JMenu("Bearbeiten");
    	//// Men�eintrag: L�schen
    	itemDelete=new JMenuItem("Aktion l�schen");
    	itemDelete.addActionListener(lc);		// Listener anmelden
    	menuEdit.add(itemDelete);				// zum Men� hinzuf�gen
    	//// Men�eintrag: wiederherstellen
    	itemRestore=new JMenuItem("Aktion wiederherstellen");
    	itemRestore.addActionListener(lc);		// Listener anmelden
    	menuEdit.add(itemRestore);				// zum Men� hinzuf�gen
    	menuBar.add(menuEdit);					// zur MenuBar hinzuf�gen
    	// zweites Men�: Modus
    	JMenu menuModus=new JMenu("Zeichnen");
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
    	//// RadioButton-Men�eintrag f�r abgeundete Rechtecke zeichnen    	
       	itemRoundedRectangle=new JRadioButtonMenuItem("Rechtecke abger. zeichnen");
       	itemRoundedRectangle.addActionListener(lc);	// Listener anmelden
       	group.add(itemRoundedRectangle);		// zur Gruppe hinzuf�gen
       	menuModus.add(itemRoundedRectangle);	// zum Men� hinzuf�gen
       	//// RadioButton-Men�eintrag f�r Ellipsen zeichnen    	
       	itemOval=new JRadioButtonMenuItem("Ellipsen zeichnen");
       	itemOval.addActionListener(lc);			// Listener anmelden
       	group.add(itemOval);					// zur Gruppe hinzuf�gen
       	menuModus.add(itemOval);				// zum Men� hinzuf�gen
       	/// Separator hinzuf�gen
    	JSeparator js1=new JSeparator();
    	menuModus.add(js1);
    	//// RadioButton-Men�eintrag f�r Rechtecke ausmalen    	
       	itemRoundedRectangleFull=new JRadioButtonMenuItem("Rechtecke abger. ausmalen");
       	itemRoundedRectangleFull.addActionListener(lc);// Listener anmelden
       	group.add(itemRoundedRectangleFull);	// zur Gruppe hinzuf�gen
       	menuModus.add(itemRoundedRectangleFull);// zum Men� hinzuf�gen
    	//// RadioButton-Men�eintrag f�r abgerundete Rechtecke ausmalen    	
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
    	// drittes: Farbe    	
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
	/**
	 * @return the itemDelete
	 */
	public JMenuItem getItemDelete() {
		return itemDelete;
	}
	/**
	 * @return the itemRestore
	 */
	public JMenuItem getItemRestore() {
		return itemRestore;
	}
	/**
	 * @return the itemRoundedRectangle
	 */
	public JRadioButtonMenuItem getItemRoundedRectangle() {
		return itemRoundedRectangle;
	}
	/**
	 * @return the itemRoundedRectangleFull
	 */
	public JRadioButtonMenuItem getItemRoundedRectangleFull() {
		return itemRoundedRectangleFull;
	}
	/**
	 * @return the itemLoad
	 */
	public JMenuItem getItemLoad() {
		return itemLoad;
	}
	/**
	 * @return the itemSave
	 */
	public JMenuItem getItemSave() {
		return itemSave;
	}
	/**
	 * @return the itemNew
	 */
	public JMenuItem getItemNew() {
		return itemNew;
	}
	
} 