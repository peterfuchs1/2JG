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
	private JMenuItem itemNew;					// Neue Datei erzeugen
	private JMenuItem itemLoad;					// Aus Datei laden
	private JMenuItem itemSave;					// In Datei speichern
	private JMenuItem itemDelete;				// letzter Schritt rückgängig
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
    	// erstes Menü: Datei
    	JMenu menuFile=new JMenu("Datei");
    	//// Menüeintrag: New
       	itemNew=new JMenuItem("Neu");
       	itemNew.addActionListener(lc);		// Listener anmelden
       	menuFile.add(itemNew);				// zum Menü hinzufügen
       	//// Menüeintrag: Laden
    	itemLoad=new JMenuItem("Laden...");
    	itemLoad.addActionListener(lc);		// Listener anmelden
    	menuFile.add(itemLoad);				// zum Menü hinzufügen
       	//// Menüeintrag: Speichern
    	itemSave=new JMenuItem("Speichern...");
    	itemSave.addActionListener(lc);		// Listener anmelden
    	menuFile.add(itemSave);				// zum Menü hinzufügen
    	menuBar.add(menuFile);
    	//////////////////////////////////
    	// erstes Menü: Bearbeiten
    	JMenu menuEdit=new JMenu("Bearbeiten");
    	//// Menüeintrag: Löschen
    	itemDelete=new JMenuItem("Aktion löschen");
    	itemDelete.addActionListener(lc);		// Listener anmelden
    	menuEdit.add(itemDelete);				// zum Menü hinzufügen
    	//// Menüeintrag: wiederherstellen
    	itemRestore=new JMenuItem("Aktion wiederherstellen");
    	itemRestore.addActionListener(lc);		// Listener anmelden
    	menuEdit.add(itemRestore);				// zum Menü hinzufügen
    	menuBar.add(menuEdit);					// zur MenuBar hinzufügen
    	// zweites Menü: Modus
    	JMenu menuModus=new JMenu("Zeichnen");
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
    	//// RadioButton-Menüeintrag für Rechtecke zeichnen    	
       	itemRectangle=new JRadioButtonMenuItem("Rechtecke zeichnen");
       	itemRectangle.addActionListener(lc);			// Listener anmelden
       	group.add(itemRectangle);					// zur Gruppe hinzufügen
       	menuModus.add(itemRectangle);				// zum Menü hinzufügen
    	//// RadioButton-Menüeintrag für abgeundete Rechtecke zeichnen    	
       	itemRoundedRectangle=new JRadioButtonMenuItem("Rechtecke abger. zeichnen");
       	itemRoundedRectangle.addActionListener(lc);	// Listener anmelden
       	group.add(itemRoundedRectangle);		// zur Gruppe hinzufügen
       	menuModus.add(itemRoundedRectangle);	// zum Menü hinzufügen
       	//// RadioButton-Menüeintrag für Ellipsen zeichnen    	
       	itemOval=new JRadioButtonMenuItem("Ellipsen zeichnen");
       	itemOval.addActionListener(lc);			// Listener anmelden
       	group.add(itemOval);					// zur Gruppe hinzufügen
       	menuModus.add(itemOval);				// zum Menü hinzufügen
       	/// Separator hinzufügen
    	JSeparator js1=new JSeparator();
    	menuModus.add(js1);
    	//// RadioButton-Menüeintrag für Rechtecke ausmalen    	
       	itemRoundedRectangleFull=new JRadioButtonMenuItem("Rechtecke abger. ausmalen");
       	itemRoundedRectangleFull.addActionListener(lc);// Listener anmelden
       	group.add(itemRoundedRectangleFull);	// zur Gruppe hinzufügen
       	menuModus.add(itemRoundedRectangleFull);// zum Menü hinzufügen
    	//// RadioButton-Menüeintrag für abgerundete Rechtecke ausmalen    	
       	itemRectangleFull=new JRadioButtonMenuItem("Rechtecke ausmalen");
       	itemRectangleFull.addActionListener(lc);			// Listener anmelden
       	group.add(itemRectangleFull);					// zur Gruppe hinzufügen
       	menuModus.add(itemRectangleFull);				// zum Menü hinzufügen
       	//// RadioButton-Menüeintrag für Ellipsen ausmalen    	
       	itemOvalFull=new JRadioButtonMenuItem("Ellipsen ausmalen");
       	itemOvalFull.addActionListener(lc);			// Listener anmelden
       	group.add(itemOvalFull);					// zur Gruppe hinzufügen
       	menuModus.add(itemOvalFull);				// zum Menü hinzufügen
    	menuBar.add(menuModus);					// zur MenuBar hinzufügen
    	//////////////////////////////////
    	// drittes: Farbe    	
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