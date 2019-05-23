package actionlistener1;

import javax.swing.*;
import java.awt.event.*;

public class EinPanel extends JPanel {
	private JLabel lAusgabe;
	private JButton bOk, bReset;

	public EinPanel() {
		this.lAusgabe = new JLabel("Hallo!");
		this.add(this.lAusgabe);
		this.bOk = new JButton("Ok!");
		this.add(this.bOk);
		this.bReset = new JButton("Zurück!");
		this.add(this.bReset);
	}

	private class JButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			lAusgabe.setText("Geklickt: ");
		}
	}
}
