package grundrechnungsarten_neu2;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel,oben,unten;
	private int anzahlVariable;
	private int anzahlPossibilities;
	private int start,stopp, inkrement;
	private JTextField[] jtf;
	private int ergebnis;
	private JTextField jtf_erg;
	private JTextField jtf_anz;
	private char operatoren[];
	private JButton jb_start,jb_fwd, jb_bwd,jb_clear;
//	private boolean possibilities[];  //freie Möglichkeiten
	private Possibility pos,test;
//	private boolean test[];
	private ArrayList<Variable<Integer>> v; // Variablen
	private boolean found=false;
	private ArrayList <Solution<Integer>> sol;
	private int aktuelleSolution;

	/**
	 * Standard-GUI
	 * @param args Operatoren
	 */
	public GUI(String args[]){
		this(0,9,1,args);
	}
	/**
	 * Gui
	 * @param start niedrigster möglicher Wert
	 * @param stopp höchster möglicher Wert
	 * @param args Operatoren
	 */
	public GUI(int start, int stopp, int inkrement, String[] args) {
		// Anzahl der Variablen
		anzahlVariable=args.length+1;
		// Anzahl der Möglichkeiten
		anzahlPossibilities=stopp-start+1;
		// Erstellt ein Array von Variablen
		v=new ArrayList<Variable<Integer>>(anzahlVariable);
		this.start=start;
		this.stopp=stopp;
		this.inkrement=inkrement;
		// Möglichkeiten anlegen
//		possibilities=new boolean[anzahlPossibilities];
//		test=new boolean[anzahlPossibilities];
		pos=new Possibility(start,stopp,inkrement);
		pos.initiate();
		test=new Possibility(start,stopp,inkrement);
		// Panel anlegen
		panel=new JPanel(new BorderLayout(4,4));
		// Variablenfelder anlegen
		jtf=new JTextField[anzahlVariable];
		// Operatoren  anlegen
		operatoren=new char[args.length];
		// Panel oben anlegen
		oben=new JPanel();
		// Variablen-Felder und Operatoren anzeigen
		int i=0,j=args.length+1,k=j-1;
		for (i=0;i<j;i++) {
			jtf[i]=new JTextField(5);
			oben.add(jtf[i]);
			if(i<k) {
				operatoren[i]=args[i].charAt(0);
				oben.add(new JLabel(""+operatoren[i]));
			}
			
		}
		// Ergebnisfeld anzeigen
		oben.add(new JLabel("="));
		jtf_erg=new JTextField(5);
		oben.add(jtf_erg);
		//Ergebnisfeld erstellen und anzeigen
		oben.add(new JLabel("finds"));
		jtf_anz=new JTextField(5);
		jtf_anz.setText("0");
		jtf_anz.setEditable(false);
		
		oben.add(jtf_anz);
		
		//Button-Panel erstellen		
		unten=new JPanel();
		// Clear
		jb_clear=new JButton("clear");
		jb_clear.addActionListener(this);
		unten.add(jb_clear);
		// Start
		jb_start=new JButton("start");
		jb_start.addActionListener(this);
		unten.add(jb_start);
		// Forward
		jb_fwd=new JButton(">");
		jb_fwd.setEnabled(false);
		jb_fwd.addActionListener(this);
		unten.add(jb_fwd);
		// Backward
		jb_bwd=new JButton("<");
		jb_bwd.setEnabled(false);
		jb_bwd.addActionListener(this);
		unten.add(jb_bwd);
		
		
		panel.add(oben,BorderLayout.CENTER);
		panel.add(unten,BorderLayout.SOUTH);
		// 10 Pixel Rand lassen
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(770, 200);
		this.setTitle("Berechnung Grundrechnungsarten");
		this.getContentPane().add(panel);
		this.setVisible(true);

	}

	@Override
	/**
	 * Button-Ereignisse abfangen
	 */
	public void actionPerformed(ActionEvent e) {
		int wert=0;
		// Falls Start gedrückt wurde
		if(e.getSource()==jb_start){
			// Möglichkeiten initialisieren
//			for (int j=0;j<anzahlPossibilities;j++)
//				possibilities[j]=true;
			pos.initiate();
			// Werte aus dem Formular übernehmen
			for(int i=0;i<anzahlVariable;i++){
				String str=jtf[i].getText();
				try{
					wert=Integer.parseInt(str);					
				}
				catch(NumberFormatException nfe){}
				
				// Falls kein numerischer Integerwert
				// eingegeben wurde, wird eine leere 
				// Variable angenommen
				Variable<Integer> v1=null;
				if(!str.equals("")){
//					possibilities[wert]=false;
					pos.setValue(wert,false);
					
					v1=	new Variable<Integer>(wert,true);
				} 
				else {
					v1=	new Variable<Integer>(start,stopp,wert,false);				
				}
				v.add(i, v1); // Variable wird hinzugefügt
			}
			// ERgebnis übernehmen
			try{
				ergebnis=Integer.parseInt(jtf_erg.getText());
			}
			catch(NumberFormatException nfe){}
			// Initialisierung
			initialisiere();
			// Berechnung der Lösungen rekursiv
			berechneRekursiv();
			// Ausgabe der Ergebnisse
			if(found){
				this.setTitle("Berechnung Grundrechnungsarten successfully finished!");
				jb_fwd.setEnabled(true);
				jb_bwd.setEnabled(true);
				printSolution();
			}
			else
				this.setTitle("Berechnung Grundrechnungsarten finished, but no solution found!");
		}
		// Button forward gedrückt
		else if(e.getSource()==jb_fwd){
			if (found && aktuelleSolution<sol.size()-1){
				++aktuelleSolution;
				printSolution();
			}
		}
		//Button backward gedrückt
		else if(e.getSource()==jb_bwd){
			if (found && aktuelleSolution>0){
				--aktuelleSolution;
				printSolution();
			}
		}
		// Button clear gedrückt
		else if(e.getSource()==jb_clear){
			for(int i=0;i<jtf.length;i++)
				jtf[i].setText("");
			jtf_anz.setText("0");
			jtf_erg.setText("");
		}
	}
	/**
	 * Ausgabe einer Lösung
	 */
	private void printSolution(){
		Solution<Integer> s=sol.get(aktuelleSolution);
		for(int i=0;i<s.length();i++){
			jtf[i].setText(""+s.getVal(i).intValue());
		}
		jtf_anz.setText(""+(aktuelleSolution+1)+"/"+sol.size());
		panel.repaint();
		
	}
	/**
	 * Berechnung initialisieren
	 */
	public void initialisiere(){
		// verfügbare Werte neu setzen
//		for (int i=0;i<possibilities.length;i++){
//			test[i]=possibilities[i];
//		}
		
		for (int i=start;i<=stopp;i+=inkrement){
			test.setValue(i, pos.getValue(i));
		}

		// Ergebnisliste zurücksetzen
		sol=new ArrayList<Solution<Integer>>();
		aktuelleSolution=0;
		// Fund zurücksetzen
		found=false;
		// Fwd und Bwd-Button deaktivieren
		jb_fwd.setEnabled(false);
		jb_bwd.setEnabled(false);
	}
	/**
	 * Start der Berechnung mit Variablenindex=0
	 * @return found
	 */
	public boolean berechneRekursiv(){
		return berechne(0);
	}
	/**
	 * rekursive Berechnung möglicher Werte
	 * @param vIndex aktuelle Variable
	 * @return found
	 */
	public boolean berechne(int vIndex){
		// Aktuelle Variable testen
		Variable<Integer> v1=v.get(vIndex);
		Integer startWert=v1.getStart();
		Integer stoppWert=v1.getStopp();
		boolean konstante=v1.isFix();
		// mögliche Werte iterieren
		for(int i=startWert;i<=stoppWert;i+=inkrement) {
		  // Falls es kein Fixwert ist
			if(!konstante){
		  // ist der Wert noch verfügbar?	  
//			  if(!test[i]) continue;
			  if(!test.getValue(i)) continue;
		  // neuen Wert	verwenden
//			  test[i]=false;
			  test.setValue(i,false);
		  // und für die Variable setzen
			  v1.setValue(i);
		  // Darstellung aktualisieren
			  jtf[vIndex].setText(""+i);
		  }
		  // Noch nicht alle Variablen besetzt?
		  if(vIndex!=anzahlVariable-1)  
			  berechne(vIndex+1);
		  else 
		  // Letzte Variable erreicht
		  // Nun werden die gewählten Werte evaluiert
			if(evaluate(operatoren)){
				found= true;
				panel.repaint();
			}
		  // Falls kein fixer Wert, getesteten Wert wieder
		  // freigeben
		  if(!konstante) 
//			  test[i]=true;
		  	test.setValue(i, true);
		
	}
	  return found;
  }
	/**
	 * Evaluierung der ermittelten Werte
	 * @return Übereinstimmung?
	 */
	public boolean evaluate(char [] operatoren){
		boolean ret=false;
		// Summe mit erster Variable initialisiert
		Variable<Integer> v1=v.get(0);
		double sum=v1.getValue().doubleValue();
		// Alle weiteren Variableninhalte
		// werden je nach Operator
		// algebraisch hinzugefügt

		for(int i=1;i<v.size();i++) {
			v1=v.get(i);
			switch(operatoren[i-1]){			
			case '+': sum+=v1.getValue().doubleValue();break;
			case '-': sum-=v1.getValue().doubleValue();break;
			case '*': sum*=v1.getValue().doubleValue();break;
			case '/': 
				if(v1.getValue().doubleValue()==0.0)
					return false;
				else
					sum/=v1.getValue().doubleValue();
			}
		}
		// Falls die Werte übereinstimmt
		if(sum==ergebnis){ ret=true;
		// Datensatz in ArrayList speichern
			Solution<Integer> s=new Solution<Integer>(anzahlVariable);
			for(int i=0;i<s.length();i++){
				s.setVal(i, v.get(i).getValue());
			}
			sol.add(s);
			// Lösungsanzahl erhöhen
			jtf_anz.setText("1/"+sol.size());
		}
		return ret;
		
	}
}

