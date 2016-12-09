package navi;


import javax.swing.*;

import java.awt.*;

public class MyPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3115758653936432443L;
	private JButton jbUp,jbDown,jbLeft,jbRight,jbNeu; // Buttons
	private Zeichnung zeichnung;
	private JSlider slider;		// SLider für die Längeneinstellung
	private int len;			// aktuelle Länge einer Kante
	private Point lastPoint;	// letzter Punkt
	
	/**
	 * Übernimmt den Controller und initialisiert das Layout
	 * @param wControl der Controller für diese GUI
	 */
	public MyPanel(MyControl wControl) {
		//Button erstellen
		jbUp=new JButton("up");
		jbUp.addActionListener(wControl);
		jbDown=new JButton("down");
		jbDown.addActionListener(wControl);
		jbLeft=new JButton("left");
		jbLeft.addActionListener(wControl);
		jbRight=new JButton("right");
		jbRight.addActionListener(wControl);
		jbNeu=new JButton("neu");
		jbNeu.addActionListener(wControl);
		
		// Layout für unser Panel
		this.setLayout(new BorderLayout());
		// Im Norden wird ein Label erstellt
		JLabel jlnorth=new JLabel("Erstellen Sie ein Bild mit Hilfe der Buttons!");
		this.add(jlnorth, BorderLayout.NORTH);
		// Im Osten werden die Navi-Buttons erstellt
		JPanel east=new JPanel(new GridLayout(4, 1));
		east.add(jbUp);
		east.add(jbDown);
		east.add(jbLeft);
		east.add(jbRight);
		this.add(east, BorderLayout.EAST);
		// Im Zentrum wird das Bild erstellt
		zeichnung=new Zeichnung();
		this.add(zeichnung,BorderLayout.CENTER);
		// Im Süden wird der Neu-Button erzeugt
		JPanel south=new JPanel();
		JLabel jlLength=new JLabel("Länge:");
		 
		slider=new JSlider(SwingConstants.HORIZONTAL, 1, 10, 5);
		slider.addChangeListener(wControl);
		south.add(jbNeu);
		south.add(jlLength);
		south.add(slider);
		this.add(south,BorderLayout.SOUTH);
		init();
		}
	/**
	 * Panel initialisieren
	 */
	public void init(){
		lastPoint=new Point(10,10);
		len=5;
		slider.setValue(len);
		zeichnung.init();
	}
	/**
	 * Neuen Punkt zur Zeichnung hinzufügen
	 * @param newPoint
	 */
	private void addPoint(Point newPoint){
		zeichnung.addPoint(newPoint.x, newPoint.y);
	}
	/**
	 * Zeichne eine Kanten nach Norden
	 */
	public void up(){
		lastPoint.translate(0, -len);
		addPoint(lastPoint);
	}
	/**
	 * Zeichne eine Kanten nach Süden
	 */
	public void down(){
		lastPoint.translate(0, len);
		addPoint(lastPoint);
	}
	/**
	 * Zeichne eine Kanten nach Westen
	 */
	public void left(){
		lastPoint.translate(-len, 0);
		addPoint(lastPoint);
	}
	/**
	 * Zeichne eine Kanten nach Osten
	 */
	public void right(){
		lastPoint.translate(len, 0);
		addPoint(lastPoint);
	}
	// SETTER UND GETTER
	
	/**
	 * @return the jbUp
	 */
	public JButton getJbUp() {
		return jbUp;
	}

	/**
	 * @return the slider
	 */
	public JSlider getSlider() {
		return slider;
	}
	/**
	 * @return the jbDown
	 */
	public JButton getJbDown() {
		return jbDown;
	}

	/**
	 * @return the jbLeft
	 */
	public JButton getJbLeft() {
		return jbLeft;
	}

	/**
	 * @return the jbRight
	 */
	public JButton getJbRight() {
		return jbRight;
	}

	/**
	 * @return the jbNeu
	 */
	public JButton getJbNeu() {
		return jbNeu;
	}

	public void setLen(int len){
		this.len=len;
	}
}
