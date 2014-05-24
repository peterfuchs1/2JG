package bsp.mvc;

import java.awt.event.*;
import javax.swing.*;

public class WuerfelControl implements ActionListener {
	private WuerfelFrame wFrame;
	private WuerfelPanel wPanel;
	private WuerfelSpiel wSpiel;
	
	public WuerfelControl() {
		wPanel = new WuerfelPanel(this);
		wFrame = new WuerfelFrame(wPanel,"Würfelspiel");
		wSpiel = new WuerfelSpiel(wPanel.getSpielerzahl());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String ac = e.getActionCommand();
		if(ac.equals("neu")) {
			wPanel.reset();
			wSpiel.reset();
		} else if(ac.startsWith("Spieler")){
			String nummer = ac.substring(ac.length()-1);
			int spielerNummer = Integer.parseInt(nummer) - 1;
			int erg = wSpiel.wuerfeln(spielerNummer);
			if(erg > -1) {
				wPanel.setErgebnis(spielerNummer, erg);
				if(wSpiel.alleGewuerfelt()) {
					int[] gew = wSpiel.spielerGewonnen();
					if(gew != null) {
						String gewText = "Spieler ";
						if(gew.length == 1) {
							gewText += (gew[0]+1) + " gewinnt";
						} else {
							gewText += (gew[0]+1);
							for(int i = 1; i < gew.length; i++) {
								gewText += " und " + (gew[i]+1);
							}
							gewText += " gewinnen";
						}
						wPanel.setStatus(gewText);
					}
				}
			}
		}
	}
	
	public static void main(String[] args) {
		new WuerfelControl();
	}

}
