package paint_figures;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 * Frame Standard-Klasse 
 * hier wird das Panel und
 * und der header gesetzt
 * 
 * @author Walter Rafeiner-Magor
 * @version 2.0
 * 
 */
public class MyFrame extends JFrame {

	private static final long serialVersionUID = 4162099282684131327L;

	/**
	 * Standard Konstruktor
	 */
	public MyFrame(MyPanel myPanel,String header) {
		super(header);
		this.add(myPanel, BorderLayout.CENTER);
		this.setSize(1000, 700);
		this.setResizable(true);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}



}
