package paint;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Text extends Drawable {
	private Font f;
	public static Font FONT=new Font("Tahoma",Font.BOLD,20);

	/**
	 * 
	 */
	private static final long serialVersionUID = -4203157182717496481L;
	public Text(int startX, int startY, int endX, int endY, Color c) {
		this(startX, startY, endX, endY, c,FONT);
	}
	public Text(int startX, int startY, int endX, int endY, Color c, Font f) {
		super(startX, startY, endX, endY, c);
		this.f=f;
	}

	/**
	 * Zeichnet einen rechteckigen Ausschnitt  
	 * auf dem Graphics-Kontext
	 * @param g
	 */
	public void draw(Graphics g){
		g.setColor(c);// Farbe setzen	
		int width = p.xpoints[1]-p.xpoints[0];
		int heigth= p.ypoints[1]-p.ypoints[0];
		g.clipRect(p.xpoints[0], p.ypoints[0], width, heigth);
	}
	/**
	 * @see sw.Drawable#clone()
	 */
	@Override
	public Drawable clone() {
		Text d=new Text(p.xpoints[0], p.ypoints[0], p.xpoints[1], p.ypoints[1], c,f);
		d.setHomePosition();
		return d;
	}
}
