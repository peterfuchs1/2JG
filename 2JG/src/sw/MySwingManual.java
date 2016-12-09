package sw;

import javax.swing.JFrame;

public class MySwingManual extends JFrame {



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		new MySwingManual();
	}

	/**
	 * Create the frame.
	 */
	public MySwingManual() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		MySwingManualJPanel contentPane = new MySwingManualJPanel();
		this.add(contentPane);
		this.setVisible(true);
	}
}
