package bsp.mvc;

import javax.swing.*;

public class WuerfelFrame extends JFrame {
	
	public WuerfelFrame(JPanel layoutPanel) {

		super("Würfelspiel");
		this.add(layoutPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}
}
