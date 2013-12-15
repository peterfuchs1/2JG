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
	private JRadioButtonMenuItem itemFreehand;
	private JRadioButtonMenuItem itemLine;
	private JMenuItem itemColor;
	
	
    /**
     * Der Konstruktor erzeugt ein JPanel
     * legt eine fixe Größe an.
     */
    public MyDrawingFrame3(MyDrawingPanel3 view,LineController lc)
    {
    	super("Zeichenbrett");		// Titel gesetzt    
    	this.setBackground(new Color(240, 230, 140));
    	JMenuBar menuBar=new JMenuBar();
    	
    	JMenu menuModus=new JMenu("Modus");
    	ButtonGroup group = new ButtonGroup();
    	itemFreehand = new JRadioButtonMenuItem("Freihand");
    	itemFreehand.addActionListener(lc);
    	itemFreehand.setSelected(true);
    	group.add(itemFreehand);
    	menuModus.add(itemFreehand);
    	
    	
    	itemLine=new JRadioButtonMenuItem("Strecken");
    	itemLine.addActionListener(lc);
    	group.add(itemLine);
    	menuModus.add(itemLine);
    	menuBar.add(menuModus);
    	
    	JMenu menuColor=new JMenu("Farbe");
    	itemColor=new JMenuItem("Farbauswahl");
    	itemColor.addActionListener(lc);
    	menuColor.add(itemColor);
    	menuBar.add(menuColor);
    	
    	this.setJMenuBar(menuBar);
    	
        this.add(view);				// Im Center verankert
        this.setSize(800,600);		// Größe festgelegt
        this.setResizable(false);	// und fixiert
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);		// Fenster nun sichtbar
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
	 * @return the itemColor
	 */
	public JMenuItem getItemColor() {
		return itemColor;
	}
    
    
} 