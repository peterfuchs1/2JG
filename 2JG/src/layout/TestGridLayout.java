package layout;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class TestGridLayout extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton east,west;
	public TestGridLayout(){
		this.setLayout(
				new GridLayout(1, 2)
				);
		east=new JButton("east");
		west=new JButton("western");
		Container c=this.getContentPane();
		c.add(east);
		c.add(west);
		c.add(new JButton("to much..."));
		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new TestGridLayout();

	}

}
