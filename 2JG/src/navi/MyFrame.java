package navi;


import javax.swing.*;

public class MyFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 602703556574556421L;

	public MyFrame(JPanel layoutPanel, String title) {

		super(title);
		this.add(layoutPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}
}
