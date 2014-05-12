package layout;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TestBorderLayout extends JFrame {

	private JLabel east,west;
	public TestBorderLayout(){
		east=new JLabel("east");
		west=new JLabel("west");
		Container c=this.getContentPane();
		c.add(east,BorderLayout.EAST);
		c.add(west,BorderLayout.WEST);
//		c.add(new JLabel("center"),BorderLayout.CENTER);
		this.pack();
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new TestBorderLayout();

	}

}
