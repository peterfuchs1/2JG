/**
 * 
 */
package paint_figures;

import java.awt.*;
import javax.swing.JPanel;

/**
 * Zeichnet eine Figur
 * 
 * @author Daniel May
 * @version 1.0
 * 
 */
public class Zeichnung extends JPanel {
	public static Color FRAME_COLOR=Color.BLACK;
	public static Color FIGUR_COLOR=Color.ORANGE;
	private static final long serialVersionUID = 1L;
	private Figur figur;
	private boolean voll;

	/**
	 * STD Konstruktor
	 * 
	 */
	public Zeichnung() {
		this(Figur.QUADRAT,true);
	}
	public Zeichnung(Figur figur, boolean voll) {
		this.figur= figur;
		this.voll=voll;
	}

	
	
	/**
	 * @return the figur
	 */
	public Figur getFigur() {
		return figur;
	}
	/**
	 * @param figur the figur to set
	 */
	public void setFigur(Figur figur) {
		this.figur = figur;
		repaint();
	}
	/**
	 * @return the voll
	 */
	public boolean isVoll() {
		return voll;
	}
	/**
	 * @param voll the voll to set
	 */
	public void setVoll(boolean voll) {
		this.voll = voll;
		repaint();
	}

	/**
	 * Zeichnet entweder ein Quadrdat, Kreis oder Rechteck
	 * voll oder nur gerahmt
	 * 
	 * @param g
	 *            Graphics
	 */
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int size, x, y;
		// ermittle die kleinere Seite
		size=(this.getHeight() < this.getWidth())?
				this.getHeight():this.getWidth();
		// davon 80%
				size=(int)(size*0.8);
		// links oben		
		x = (int) ((this.getWidth() / 2.0) - size / 2.0);
		y = (int) ((this.getHeight() / 2.0) - size / 2.0);
		// Für Dreieck und Pfeile
		
		int x2=(int)(size/2.0);
		int mitteX =x2+x;
		int endeX=x+size;
		int untenY=y+size;
		int [] xpoints,ypoints;
		Polygon p;
		int rechteHausKanteX,rechteHausKanteY;
		int linkeHausKanteX,linkeHausKanteY;
		int wandObenX,wandObenY;
		int wandUntenX,wandUntenY;
		
		switch(figur){
		case QUADRAT:
			if(voll){
				g.setColor(FIGUR_COLOR);
				g.fillRect(x, y, size, size);
			}
			g.setColor(FRAME_COLOR);
			g.drawRect(x, y, size, size);
			break;
		case KREIS:
			if(voll){
				g.setColor(FIGUR_COLOR);
				g.fillOval(x, y, size, size);
			}
			g.setColor(FRAME_COLOR);
			g.drawOval(x, y, size, size);
			break;
		case DREIECK:
						
			xpoints = new int[]{x, x2+x,size+x};
			ypoints = new int[]{size+y,y,size+y};
			
			p=new Polygon(xpoints,ypoints,xpoints.length);
			
			if(voll){
				g.setColor(FIGUR_COLOR);
				g.fillPolygon(p);
			}
			g.setColor(FRAME_COLOR);
			g.drawPolygon(p);
			break;
		case PFEIL_OBEN:
			rechteHausKanteX=x+size*5/6;
			linkeHausKanteX=x+size/6;
			wandObenY=y+size/3;
			wandUntenY=y+size;
			xpoints =new int[] {x, mitteX,endeX,rechteHausKanteX,rechteHausKanteX,linkeHausKanteX,linkeHausKanteX};
			ypoints =new int[] {wandObenY,y,wandObenY,wandObenY,wandUntenY,wandUntenY,wandObenY};
			
			p=new Polygon(xpoints,ypoints,xpoints.length);
			
			if(voll){
				g.setColor(FIGUR_COLOR);
				g.fillPolygon(p);
			}
			g.setColor(FRAME_COLOR);
			g.drawPolygon(p);
			break;
		case PFEIL_UNTEN:
			rechteHausKanteX=x+size*5/6;
			linkeHausKanteX=x+size/6;
			wandObenX=wandUntenX=x+size/3;
			
			wandUntenY=y+size*2/3;
			xpoints =new int[] {x, mitteX,endeX,rechteHausKanteX,rechteHausKanteX,linkeHausKanteX,linkeHausKanteX};
			ypoints =new int[] {wandUntenY,untenY,wandUntenY,wandUntenY,y,y,wandUntenY};
			
			p=new Polygon(xpoints,ypoints,xpoints.length);
			
			if(voll){
				g.setColor(FIGUR_COLOR);
				g.fillPolygon(p);
			}
			g.setColor(FRAME_COLOR);
			g.drawPolygon(p);
			break;
		case DOPPEL_PFEIL:
			rechteHausKanteX=x+size*5/6;
			linkeHausKanteX=x+size/6;
			wandObenX=x+size/3;
			wandUntenX=x+size*2/3;
			wandObenY=y+size/3;
			wandUntenY=y+size*2/3;
			xpoints =new int[] {x, mitteX,endeX,rechteHausKanteX,rechteHausKanteX,endeX,mitteX,x,linkeHausKanteX,linkeHausKanteX};
			ypoints =new int[] {wandUntenY,untenY,wandUntenY,wandUntenY,wandObenY,wandObenY,y,wandObenY,wandObenY,wandUntenY};
			
			p=new Polygon(xpoints,ypoints,xpoints.length);
			
			if(voll){
				g.setColor(FIGUR_COLOR);
				g.fillPolygon(p);
			}
			g.setColor(FRAME_COLOR);
			g.drawPolygon(p);
			break;
			
		}
	}
}
