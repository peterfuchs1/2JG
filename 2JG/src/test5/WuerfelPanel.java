package test5;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class WuerfelPanel extends JPanel {
	private int[] augen;
	private int index;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public WuerfelPanel() {
		this.augen=new int[6];
		this.index=0;
		augen[0]=6;
	}
	public void setAugen(int index, int wert) {
		this.augen[index]=wert;
		this.index=index;
		this.repaint();
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int h=super.getHeight()-10;
		int b=super.getWidth()-10;
		g.setColor(Color.YELLOW);
		g.fillRoundRect(10, 10, b, h, 10, 10);
		g.setColor(Color.BLACK);
		g.drawRoundRect(10, 10, b-1, h-1, 10, 10);
		int pxStart=20;
		int pxEnde=b-20;
		int pyStart=20;
		int pyEnde=h-20;
		int s = 20;
		int wert=this.augen[this.index];
		switch(wert) {
		case 1:
			g.fillOval((pxStart+pxEnde)/2, (pyStart+pyEnde)/2, s, s);
			break;
		case 2:
			g.fillOval(pxStart, pyStart, s, s);
			g.fillOval(pxEnde, pyEnde, s, s);
			break;
		case 3:
			g.fillOval((pxStart+pxEnde)/2, (pyStart+pyEnde)/2, s, s);
			g.fillOval(pxStart, pyStart, s, s);
			g.fillOval(pxEnde, pyEnde, s, s);
			break;
		case 4:
			g.fillOval(pxStart, pyStart, s, s);
			g.fillOval(pxEnde, pyStart, s, s);
			g.fillOval(pxStart, pyEnde, s, s);
			g.fillOval(pxEnde, pyEnde, s, s);
			break;
		case 5:
			g.fillOval(pxStart, pyStart, s, s);
			g.fillOval(pxEnde, pyStart, s, s);
			g.fillOval(pxStart, pyEnde, s, s);
			g.fillOval(pxEnde, pyEnde, s, s);
			g.fillOval((pxStart+pxEnde)/2, (pyStart+pyEnde)/2, s, s);
			break;
		default:
			g.fillOval(pxStart, pyStart, s, s);
			g.fillOval(pxEnde, pyStart, s, s);
			g.fillOval(pxStart, pyEnde, s, s);
			g.fillOval(pxEnde, pyEnde, s, s);
			g.fillOval(pxStart, (pyStart+pyEnde)/2, s, s);
			g.fillOval(pxEnde, (pyStart+pyEnde)/2, s, s);
		}		
	}

	
}
