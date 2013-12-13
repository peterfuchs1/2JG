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

public class MySwingBuilder extends JFrame {


	private JPanel contentPane;
	private JTextField jtfName;
	private JLabel lbName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MySwingBuilder frame = new MySwingBuilder();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MySwingBuilder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(2, 2, 2, 2));
		contentPane.setLayout(new BorderLayout(0, 2));
		setContentPane(contentPane);
		
		JPanel jpContent = new JPanel();
		jpContent.setBorder(new EmptyBorder(0, 0, 0, 0));
		contentPane.add(jpContent, BorderLayout.CENTER);
		jpContent.setLayout(new BorderLayout(0, 0));
		
		JPanel jpName = new JPanel();
		jpContent.add(jpName, BorderLayout.NORTH);
		jpName.setBackground(new Color(224, 255, 255));
		
		JLabel lblJlname = new JLabel("Name");
		lblJlname.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jpName.add(lblJlname);
		
		jtfName = new JTextField();
		jtfName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jtfName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbName.setText(jtfName.getText());
			}
		});
		jtfName.setToolTipText("Bitte geben Sie Ihren Namen ein!");
		jpName.add(jtfName);
		jtfName.setColumns(15);
		
		JPanel jpOutput = new JPanel();
		jpOutput.setBackground(new Color(224, 255, 255));
		jpContent.add(jpOutput);
		
		JLabel lblIhrNameLautet = new JLabel("Ihr Name lautet: ");
		lblIhrNameLautet.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIhrNameLautet.setHorizontalAlignment(SwingConstants.CENTER);
		jpOutput.add(lblIhrNameLautet);
		
		lbName = new JLabel(" ");
		lbName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		jpOutput.add(lbName);
		
		JPanel jpButtons = new JPanel();
		jpButtons.setBackground(new Color(100, 149, 237));
		contentPane.add(jpButtons, BorderLayout.SOUTH);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jtfName.setText(null);
				setLabelName(" ");
			}
		});
		btnClear.setBackground(new Color(240, 230, 140));
		jpButtons.add(btnClear);
		
		JButton btnEnter = new JButton("Enter");
		btnEnter.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLabelName(jtfName.getText());
			}
		});
		btnEnter.setBackground(new Color(240, 230, 140));
		jpButtons.add(btnEnter);
		
		JPanel jpTitle = new JPanel();
		jpTitle.setForeground(new Color(255, 255, 255));
		jpTitle.setBackground(new Color(100, 149, 237));
		contentPane.add(jpTitle, BorderLayout.NORTH);
		
		JLabel lblBitteGebenSie = new JLabel("Bitte geben Sie Ihren Namen ein!");
		lblBitteGebenSie.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBitteGebenSie.setForeground(new Color(255, 255, 255));
		jpTitle.add(lblBitteGebenSie);
	}
	private void setLabelName(String t){
		lbName.setText(t);
		jtfName.requestFocus();
	}
}
