package raten;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;

public class GewinnController implements ActionListener {
	private GewinnPanel myPanel; // My JPanel
	private GewinnModel model; // My model

	public GewinnController() {
		model=new GewinnModel();
		myPanel = new GewinnPanel(this);
		new MyFrame(myPanel, "Gewinnspiel");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s=e.getActionCommand();
		switch(s) {
		case "enter":
			myPanel.EnableButton(true);
			myPanel.EnableTextField(false);
			model.berechneComputerZahl();
			model.berechneRunde(myPanel.getjTFSpielerZahl());
			myPanel.setAktuellesErgebnis(model.getRundenErgebnis());
			myPanel.setComputerZahl(model.getComputerZahl());
			myPanel.setGesamtPunkte(model.getGesamtPunkte());
			break;
		case "button":
			myPanel.EnableButton(false);
			myPanel.EnableTextField(true);
			myPanel.init();
			break;
		}
		myPanel.repaint();		
	}
	public static void main(String args[]){
		new GewinnController();
	}
}
