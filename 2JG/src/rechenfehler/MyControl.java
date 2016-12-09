package rechenfehler;


import java.awt.event.*;

import javax.swing.*;

public class MyControl implements ActionListener {
	private MyPanel panel;
	private MyModel model;
	
	public MyControl() {
		model=new MyModel();
		panel = new MyPanel(this,model);
		new MyFrame(panel,"Rechnen muss gelernt werden :-)");

	}
	/**
	 * Buttons ausgewertet
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// Prüfen-Button oder Enter im Textfield
		if(e.getSource()==panel.getJbPruefen() || e.getSource() instanceof JTextField){
			panel.checkResult(panel.getIndexAufgabe(), panel.getLoesungText());
		}
		else{
			// neu
			panel.init();
		}
		panel.getLoesung().requestFocus();
	}
	
	public static void main(String[] args) {
		new MyControl();
	}


}
