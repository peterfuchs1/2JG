package rechenfehler;


import javax.swing.*;

public class MyFrame extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8523267158563035873L;

	public MyFrame(JPanel layoutPanel, String title) {

		super(title);
		this.add(layoutPanel);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}
}
