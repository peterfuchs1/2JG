package navi;


import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MyControl implements ActionListener, ChangeListener {
	private MyPanel panel;
	
	public MyControl() {
		panel = new MyPanel(this);
		new MyFrame(panel,"Navi-Zeichnung");

	}
	/**
	 * Buttons ausgewertet
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b=(JButton)e.getSource();
		if(b.equals(panel.getJbNeu())) panel.init();
		else if(b.equals(panel.getJbDown())) panel.down();
		else if(b.equals(panel.getJbUp())) panel.up();
		else if(b.equals(panel.getJbLeft())) panel.left();
		else if(b.equals(panel.getJbRight())) panel.right();
	}
	
	public static void main(String[] args) {
		new MyControl();
	}
	/**
	 * Neuer Wert für den Slider gesetzt
	 */
	@Override
	public void stateChanged(ChangeEvent c) {
		JSlider slider=(JSlider)c.getSource();
		if(panel.getSlider().equals(slider))
			panel.setLen(slider.getValue());
	}

}
