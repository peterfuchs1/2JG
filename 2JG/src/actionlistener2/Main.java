package actionlistener2;

import javax.swing.JFrame;

public class Main extends JFrame {
	public Main() {
		this.setTitle("second actionlistener");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.add(new EinPanel());
		this.setSize(500, 120);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new Main();

	}

}
