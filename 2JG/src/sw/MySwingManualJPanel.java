/**
 * 
 */
package sw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

/**
 * @author Walter Rafeiner-Magor
 *
 */
public class MySwingManualJPanel extends JPanel {
	private JTextField jtfName;		// Eingabefeld für Name
	private JLabel lbName;			// Anzeige der Eingabe
	
	public MySwingManualJPanel() {
		// Font:
		Font myFont=new Font("Tahoma", Font.PLAIN, 18);	// Standard
		Font buttonFont=new Font("Tahoma", Font.PLAIN, 20); // Buttons
		// Farben:
		Color myBackground=new Color(224, 255, 255);	// Standard: Mitte
		Color titleBackground=new Color(100, 149, 237);	// Titel und Buttons
		Color buttonBackground=new Color(240, 230, 140);// Hintergrund der Buttons
		
		this.setBackground(new Color(128, 128, 128));	// Hintergrund grau
														// Abstand
		this.setBorder(new EmptyBorder(2, 2, 2, 2));	// 2 Pixel seitlich
		this.setLayout(new BorderLayout(0, 2));			// 2 Pixel vertikal
		//// Aufbau der Seite
		/////////// NORTH
		JPanel jpTitle = new JPanel();
		jpTitle.setForeground(new Color(255, 255, 255));
		jpTitle.setBackground(titleBackground);
		JLabel lblBitteGebenSie = new JLabel("Bitte geben Sie Ihren Namen ein!");
		lblBitteGebenSie.setFont(myFont);
		lblBitteGebenSie.setForeground(new Color(255, 255, 255));
		jpTitle.add(lblBitteGebenSie);
		this.add(jpTitle, BorderLayout.NORTH);
		/////////// NORTH
		
		/////////// CENTER
		JPanel jpContent = new JPanel(new BorderLayout(0, 0));

		// Zentraler Bereich - NORTH
		JPanel jpName = new JPanel();
		jpContent.add(jpName, BorderLayout.NORTH);
		jpName.setBackground(myBackground);
		
		JLabel lblJlname = new JLabel("Name");
		lblJlname.setFont(myFont);
		jpName.add(lblJlname);
		
		jtfName = new JTextField();
		jtfName.setFont(myFont);
		jtfName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbName.setText(jtfName.getText());
			}
		});
		jtfName.setToolTipText("Bitte geben Sie Ihren Namen ein!");
		jpName.add(jtfName);
		jtfName.setColumns(15);
		// Zentraler Bereich - NORTH
		
		// Zentraler Bereich der Ausgabe
		JPanel jpOutput = new JPanel();
		jpOutput.setBackground(myBackground);
		// Fixer Text	
		JLabel lblIhrNameLautet = new JLabel("Ihr Name lautet: ");
		lblIhrNameLautet.setFont(myFont);
		lblIhrNameLautet.setHorizontalAlignment(SwingConstants.CENTER);
		jpOutput.add(lblIhrNameLautet);
		// Variabler Text durch jtfName gesteuert
		lbName = new JLabel(" ");
		lbName.setFont(myFont);
		jpOutput.add(lbName);
		// wird im Center des Contents verankert
		jpContent.add(jpOutput,BorderLayout.CENTER);
		// Zentraler Bereich der Ausgabe
		this.add(jpContent, BorderLayout.CENTER);
		///////////// CENTER
		
		///////////// SOUTH
		// Button-Bereich
		JPanel jpButtons = new JPanel();
		jpButtons.setBackground(titleBackground);
		// Clear-Button löscht den Eintrag
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(buttonFont);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtfName.setText(null);
				setLabelName(" ");
			}
		});
		btnClear.setBackground(buttonBackground);
		jpButtons.add(btnClear);
		// Enter-Button bestätigt die Eingabe
		JButton btnEnter = new JButton("Enter");
		btnEnter.setFont(buttonFont);
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLabelName(jtfName.getText());
			}
		});
		btnEnter.setBackground(buttonBackground);
		jpButtons.add(btnEnter);
		this.add(jpButtons, BorderLayout.SOUTH);
		///////////// SOUTH	
	}
	private void setLabelName(String t){
		lbName.setText(t);
		jtfName.requestFocus();
	}
	
	
	
}
