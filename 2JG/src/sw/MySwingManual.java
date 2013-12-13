package sw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MySwingManual extends JFrame {



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MySwingManual frame = new MySwingManual();
	}

	/**
	 * Create the frame.
	 */
	public MySwingManual() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		MySwingManualJPanel contentPane = new MySwingManualJPanel();
		this.add(contentPane);
		this.setVisible(true);
	}
}
