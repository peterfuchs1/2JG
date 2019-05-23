package actionlistener2;

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
		JButtonHandler jbh = new JButtonHandler();
		this.bOk.addActionListener(jbh);
		this.bReset.addActionListener(jbh);
	}

	private class JButtonHandler implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
			if (o == bOk) {
				lAusgabe.setText("Geklickt: ");
			} else if (o == bReset) {
				lAusgabe.setText("Hallo!");
			}
		}
	}
}