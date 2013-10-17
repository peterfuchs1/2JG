package weber;

import java.awt.BorderLayout;
import java.awt.Panel;

public class AmpelPanel extends Panel {

	/**
	 * 
	 */
	public AmpelPanel() {
		this.setLayout(new BorderLayout());
		Ampel a=new Ampel();
		this.add(a,BorderLayout.CENTER);
		a.repaint();
	}
	
}
