package paint_figures;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;

public class MyController implements ActionListener {
	private MyFrame myFrame; // My standard JFrame
	private MyPanel myPanel; // My JPanel

	public MyController() {

		myPanel = new MyPanel(this);
		myFrame = new MyFrame(myPanel, "Figuren mit und ohne Füllung");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JRadioButton rb=(JRadioButton)e.getSource();
		if(rb.equals(myPanel.getqFalse()) || rb.equals(myPanel.getqTrue())){
			boolean selected=myPanel.getqTrue().isSelected();
			myPanel.getFiguren()[0].setVoll(selected);
		}
		
		if(rb.equals(myPanel.getkFalse()) || rb.equals(myPanel.getkTrue())){
			boolean selected=myPanel.getkTrue().isSelected();
			myPanel.getFiguren()[1].setVoll(selected);
		}
		
		if(rb.equals(myPanel.getdFalse()) || rb.equals(myPanel.getdTrue())){
			boolean selected=myPanel.getdTrue().isSelected();
			myPanel.getFiguren()[2].setVoll(selected);
		}
	}
	public static void main(String args[]){
		new MyController();
	}
}
