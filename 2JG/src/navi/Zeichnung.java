package navi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JPanel;

public class Zeichnung extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8478405873889180276L;
	public static final Color MYCOLOR=Color.BLUE;
	private Color color; // Farbe der Zeichnung
	private Polygon p;	//Alle Punkte des Polygons
	/**
	 * Konstruktor
	 */
	public Zeichnung(){
		init();
	}
	public void addPoint(int x,int y){
		p.addPoint(x, y);
		this.repaint();
	}
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(color);
		g.drawPolygon(p);
	}
	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	/**
	 * Initialisierung der Zeichnung
	 */
	public void init(){
		p=new Polygon();
		color=MYCOLOR;
		this.repaint();
	}
}
