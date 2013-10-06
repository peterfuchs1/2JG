package ampel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Panel;

public class Ampel extends Panel{
	
	private static final int KREIS_RAND=3;
	private Color farbe;
	Ampel(){
		farbe=Color.RED;
//		this.repaint();
	}
	@Override
	public void paint(Graphics g){
		Dimension d=this.getSize();
		int width=d.width-10;
		int height=d.height-10;
		int k_width=width-3;
		int k_x=KREIS_RAND;
		int k_y=KREIS_RAND;
		g.setColor(Color.BLACK);
		Color ampelFarbe=farbe;
		g.fillRect(5, 5, width, height);
		if(farbe.equals(Color.RED))
			k_y=KREIS_RAND;
		else if(farbe.equals(Color.YELLOW)){
				
		
				k_y=3*KREIS_RAND+k_width;
				
		}
		else if(farbe.equals(Color.GREEN)){
				k_y=5*KREIS_RAND+2*k_width;
				
				
		
		}
		g.setColor(ampelFarbe);
		g.fillOval(k_x, k_y, k_width, k_width);
	}
	public void setFarbe(Color f) {
		this.farbe=f;
	}
	/**
	 * @return the farbe
	 */
	public Color getFarbe() {
		return farbe;
	}
	
}
