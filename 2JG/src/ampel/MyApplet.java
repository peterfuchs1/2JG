package ampel;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Graphics;

public class MyApplet extends Applet {
@Override
public void init() {
	this.add(new AmpelPanel());
}
//	@Override
//	public void paint(Graphics g) {
//
//		g.setColor(Color.BLACK);
//		g.fillRect(5, 5, 40, 50);
//	
//	}
}
