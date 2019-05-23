package G4c32;
import java.awt.*;
import javax.swing.*;
public class ZiffernPanel extends JPanel{
	private static final long serialVersionUID = 1L;
	private JButton[] ziffern;	/* alle Buttons */
	private boolean decimal;	/* hat die Zahl bereits ein Komma? */
	private JLabel value;		/* der aktuelle Wert im Ziffernfeld */
	/**
	 * Konstruktor
	 * @param c Controller fuer das JPanel
	 */
	public ZiffernPanel(ZiffernControl c) {
		decimal = false;
		this.setLayout(new BorderLayout());
		JPanel oben=new JPanel();
		JPanel center=new JPanel(new GridLayout(4,3,6,6));
		ziffern = new JButton[] { 
			new JButton("7"), new JButton("8"),new JButton("9"),
			new JButton("4"), new JButton("5"),new JButton("6"),
			new JButton("1"), new JButton("2"),new JButton("3"),
			new JButton("+/-"), new JButton("0"),new JButton(",")
		};
		/***************** start oben ********************/
		FlowLayout fl=new FlowLayout();
		fl.setAlignment(FlowLayout.TRAILING);
		oben.setLayout(fl);
		Font f= new Font("Helvetica", Font.BOLD, 23);
		value= new JLabel("0");
		value.setForeground(new Color(255,65,0));
		value.setFont(f);
		oben.add(value);
		/***************** oben ready ********************/
		
		/***************** start center ********************/
		for (int i=0;i<ziffern.length;++i) {
			ziffern[i].addActionListener(c);
			// Achtung!! Im actionPerformed wird bei "+/-" der
			// actionCommand "-" erwartet!!!
			if(ziffern[i].getText().equals("+/-"))
				ziffern[i].setActionCommand("-");
			center.add(ziffern[i]);
			
		}
		/***************** center ready ********************/
		
		/****************** this start *********************/
		this.add(oben,BorderLayout.PAGE_START);
		this.add(center,BorderLayout.CENTER);
		/****************** this start *********************/
		this.invalidate();
	}
	/**
	 * aendert das Vorzeichen im Ziffernfeld
	 */
	public void vorzeichenAendern() {
		String text=value.getText();
		if(text.charAt(0)=='-')
			text=text.substring(1);
		else
			text="-"+text;
		value.setText(text);
	}
	/**
	 * fuegt eine weitere Ziffer hinzu
	 * @param actionCommand ActionCommand des Buttons
	 */
	public void fuegeZifferHinzu(String actionCommand) {
		String text=value.getText();
		if(text.length()==1 && text.charAt(0)=='0')
			text="";
		value.setText(text+actionCommand);
	}
	/**
	 * Fuegt ein Komma hinzu, falls noch keines vorhanden ist
	 */
	public void fuegeKommaHinzu() {
		if(!decimal) {
			decimal=true;
			String text=value.getText();
			value.setText(text+".");	
		}
	}
}
