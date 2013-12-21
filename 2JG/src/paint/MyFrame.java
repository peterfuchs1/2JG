package paint;
import java.awt.*;

import javax.swing.*;
/**
 * Die Klasse Zeichnung stellt als Zeichenfl�che
 * ein JPanel in einem JFrame zur Verf�gung.
 *
 * @author Walter Rafeiner-Magor
 * @version 1.0
 */
public class MyFrame extends JFrame
{	
	private JMenuItem itemNew;					// Neue Datei erzeugen
	private JMenuItem itemLoad;					// Aus Datei laden
	private JMenuItem itemSave;					// In Datei speichern
	private JMenuItem itemDelete;				// letzter Schritt r�ckg�ngig
	private JMenuItem itemRestore;				// letzter Schritt wiederhergestellt
	private JMenuItem itemDuplicate;			// letztes Element duplizieren
	private JMenuItem itemHome;					// Element in Homeposition
	private JMenuItem itemColor;				// Elementfarbe �ndern
	
	private JRadioButtonMenuItem itemFreehand; 	// Freihandzeichnen
	private JRadioButtonMenuItem itemLine;		// Linien zeichnen
	private JRadioButtonMenuItem itemRectangle;	// Rechteck zeichnen
	private JRadioButtonMenuItem itemOval;		// Ellipse zeichnen
	private JRadioButtonMenuItem itemRoundedRectangle;	// abgerundetes Rechteck zeichnen
	private JRadioButtonMenuItem itemRectangleFull;	// Rechteck ausmalen
	private JRadioButtonMenuItem itemOvalFull;		// Ellipse ausmalen
	private JRadioButtonMenuItem itemRoundedRectangleFull;	// abgerundetes Rechteck ausmalen
	private JRadioButtonMenuItem itemText;		// Schreibt in Ausschnitt
	
	private JMenuItem itemForeground;			// Stiftfarbe
	private JMenuItem itemBackground;			// Hintergrundfarbe
	private JMenuItem itemAbout;					// About
	private JMenuItem itemHelp;					// Hilfe
	
    /**
     * Konstruktor
     * @param view	MyJPanel
     * @param lc	Controller-Klasse
     */
    public MyFrame(MyPanel view,MyController lc)
    {
    	super("Zeichenbrett");					// Titel gesetzt    
    	JMenuBar menuBar=new JMenuBar();		// MenuBar erstellt
    	//////////////////////////////////
    	// erstes Men�: Datei
    	JMenu menuFile=new JMenu("Datei");
    	//// Men�eintrag: New
       	itemNew=new JMenuItem("Neu",'N');
       	itemNew.setAccelerator(KeyStroke.getKeyStroke('N',
                Toolkit.getDefaultToolkit(  ).getMenuShortcutKeyMask(  ), false));
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
    	itemDelete=new JMenuItem("Element l�schen");
    	itemDelete.setAccelerator(KeyStroke.getKeyStroke('Z',
                 Toolkit.getDefaultToolkit(  ).getMenuShortcutKeyMask(  ), false));
    	itemDelete.addActionListener(lc);		// Listener anmelden
    	menuEdit.add(itemDelete);				// zum Men� hinzuf�gen
    	//// Men�eintrag: wiederherstellen
    	itemRestore=new JMenuItem("Element wiederherstellen");
   	 	itemRestore.setAccelerator(KeyStroke.getKeyStroke('Y',
             Toolkit.getDefaultToolkit(  ).getMenuShortcutKeyMask(  ), false));
    	itemRestore.addActionListener(lc);		// Listener anmelden
    	menuEdit.add(itemRestore);				// zum Men� hinzuf�gen
    	//// Men�eintrag: duplizieren
    	itemDuplicate=new JMenuItem("Element duplizieren");
    	itemDuplicate.setAccelerator(KeyStroke.getKeyStroke('D',
                Toolkit.getDefaultToolkit(  ).getMenuShortcutKeyMask(  ), false));
    	itemDuplicate.addActionListener(lc);	// Listener anmelden
    	menuEdit.add(itemDuplicate);			// zum Men� hinzuf�gen
       	/// Separator hinzuf�gen
    	menuEdit.addSeparator();
    	//// Men�eintrag: HomePosition
    	itemHome=new JMenuItem("Element in Home Position",'H');
    	itemHome.addActionListener(lc);	// Listener anmelden
    	menuEdit.add(itemHome);			// zum Men� hinzuf�gen       	
    	//// Men�eintrag: Elementfarbe �ndern 
       	itemColor=new JMenuItem("Elementfarbe �ndern",'F');
       	itemColor.addActionListener(lc);	// Listener anmelden
       	menuEdit.add(itemColor);			// zum Men� hinzuf�gen       	
       	menuBar.add(menuEdit);			// zur MenuBar hinzuf�gen
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
    	menuModus.addSeparator();
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
//      menuModus.addSeparator();
       	//// RadioButton-Men�eintrag f�r Ellipsen ausmalen    	
       	itemText=new JRadioButtonMenuItem("Text schreiben");
       	itemText.addActionListener(lc);			// Listener anmelden
       	group.add(itemText);					// zur Gruppe hinzuf�gen
       	menuModus.add(itemText);				// zum Men� hinzuf�gen
       	itemText.setVisible(false);
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
    	JMenu menuInfo=new JMenu("Info");    	
    	//// Men�eintrag: Help    	
    	itemHelp=new JMenuItem("Help");
    	itemHelp.addActionListener(lc);			// Listener anmelden
    	menuInfo.add(itemHelp);					// zum Men� hinzuf�gen
    	menuBar.add(Box.createHorizontalGlue());// Men� rechtsb�ndig einf�gen
    	menuBar.add(menuInfo);					// zur MenuBar hinzuf�gen
    	//// Men�eintrag: Info    	
    	itemAbout=new JMenuItem("About");
    	itemAbout.addActionListener(lc);			// Listener anmelden
    	menuInfo.add(itemAbout);					// zum Men� hinzuf�gen
    	menuBar.add(menuInfo);					// zur MenuBar hinzuf�gen
    	this.setJMenuBar(menuBar);				// MenuBar im JFrame setzen
    	
        this.add(view);				// MyJPanel Im Center verankert
        this.setSize(800,600);		// Startgr��e festgelegt
        this.setLocationRelativeTo(null); 		// Zentrieren
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addWindowListener(lc);
        this.disableEditMenu();
        this.setVisible(true);		// Fenster nun sichtbar
   }
   public void disableEditMenu(){
	   itemDelete.setEnabled(false);
	   itemRestore.setEnabled(false);
	   itemDuplicate.setEnabled(false);
	   itemHome.setEnabled(false);
	   itemColor.setEnabled(false);
   }
   public void enableEditMenu(){
	   itemDelete.setEnabled(true);
	   itemRestore.setEnabled(true);
	   itemDuplicate.setEnabled(true);
	   itemHome.setEnabled(true);
	   itemColor.setEnabled(true);
   }
    ///////GETTER  und SETTER //////////////
	/**
	 * @return the itemInfo
	 */
	public JMenuItem getItemAbout() {
		return itemAbout;
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
	/**
	 * @return the itemHelp
	 */
	public JMenuItem getItemHelp() {
		return itemHelp;
	}
	/**
	 * @return the itemDuplicate
	 */
	public JMenuItem getItemDuplicate() {
		return itemDuplicate;
	}
	/**
	 * @return the itemHome
	 */
	public JMenuItem getItemHome() {
		return itemHome;
	}
	/**
	 * @return the itemColor
	 */
	public JMenuItem getItemColor() {
		return itemColor;
	}
	/**
	 * @return the itemText
	 */
	public JRadioButtonMenuItem getItemText() {
		return itemText;
	}

} 