package grundrechnungsarten;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI extends JFrame implements ActionListener{
	private JPanel panel,oben,unten;
	private int werte[];
	private int anzahlVariable;
	private int anzahlPossibilities;
	private JTextField[] jtf;
	private int ergebnis;
	private JTextField jtf_erg;
	private JTextField jtf_anz;
	private char operatoren[];
	private JButton jb_start,jb_fwd, jb_bwd,jb_clear;
	private boolean possibilities[];  //freie Möglichkeiten
	private boolean test[];
	private Variable v[]; // Variablen
	private boolean found=false;
	private ArrayList <Sol> solutions;
	private int aktuelleSolution;
	class Sol{
		private int[] val;
		/**
		 * @return the val
		 */
		public int[] getVal() {
			return val;
		}
		public int getVal(int index){
			return val[index];
		}
		/**
		 * @param val the val to set
		 */
		public void setVal(int[] val) {
			this.val = val;
		}
		public void setVal(int index, int value){
			this.val[index]=value;
		}
		public int length(){
			return val.length;
		}
		Sol(int anzahl){
			val=new int[anzahl];
		}
		
	}
	public GUI(String args[]){
		this(0,9,args);
	}

	public GUI(int start, int stopp, String[] args) {
		anzahlVariable=args.length+1;
		anzahlPossibilities=stopp-start+1;
		v=new Variable[anzahlVariable];
		Variable.setStaticValues(start, stopp);
		possibilities=new boolean[anzahlPossibilities];
		test=new boolean[anzahlPossibilities];
		panel=new JPanel(new BorderLayout(4,4));
		werte=new int[anzahlVariable];
		jtf=new JTextField[anzahlVariable];
		operatoren=new char[args.length];
		oben=new JPanel();
		int i=0,j=args.length+1,k=j-1;
		for (i=0;i<j;i++) {
			werte[i]=0;
			jtf[i]=new JTextField(5);
			oben.add(jtf[i]);
			if(i<k) {
				operatoren[i]=args[i].charAt(0);
				oben.add(new JLabel(""+operatoren[i]));
			}
			
		}
		oben.add(new JLabel("="));
		jtf_erg=new JTextField(5);
		oben.add(jtf_erg);
		oben.add(new JLabel("finds"));
		jtf_anz=new JTextField(5);
		jtf_anz.setText("0");
		jtf_anz.setEditable(false);
		
		oben.add(jtf_anz);
		
		///
		
		unten=new JPanel();
		jb_clear=new JButton("clear");
		jb_clear.addActionListener(this);
		unten.add(jb_clear);
		jb_start=new JButton("start");
		jb_start.addActionListener(this);
		unten.add(jb_start);
		jb_fwd=new JButton(">");
		jb_fwd.setEnabled(false);
		jb_fwd.addActionListener(this);
		unten.add(jb_fwd);
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
	public void actionPerformed(ActionEvent e) {		
		if(e.getSource()==jb_start){
			for (int j=0;j<anzahlPossibilities;j++)
				possibilities[j]=true;
		
			for(int i=0;i<anzahlVariable;i++){
				String str=jtf[i].getText();
				try{
					werte[i]=Integer.parseInt(str);
					
				}
				catch(NumberFormatException nfe){
					
				}
				if(!str.equals("")){
					possibilities[werte[i]]=false;
					v[i]=new Variable(werte[i],true);
				}
				else
					v[i]=new Variable();
//				System.out.println(""+i+": "+v[i].getValue()+": fix:"+v[i].isFix()+" start:"+v[i].getStart()+" stopp: "+v[i].getStopp());
				
				
			}
			try{
				ergebnis=Integer.parseInt(jtf_erg.getText());
			}
			catch(NumberFormatException nfe){}
//			for(int i=0;i<possibilities.length;i++)
//				System.out.println(""+i+": "+possibilities[i]);
//			System.out.println("ergebnis : "+ergebnis);
			initialisiere();
			berechne();
			if(found){
				this.setTitle("Berechnung Grundrechnungsarten successfully finished!");
				jb_fwd.setEnabled(true);
				jb_bwd.setEnabled(true);
				printSolution();
			}
			else
				this.setTitle("Berechnung Grundrechnungsarten finished, but not found!");
		}
		else if(e.getSource()==jb_fwd){
			if (found && aktuelleSolution<solutions.size()-1){
				++aktuelleSolution;
				printSolution();
			}
		}
		else if(e.getSource()==jb_bwd){
			if (found && aktuelleSolution>0){
				--aktuelleSolution;
				printSolution();
			}
		}
		else if(e.getSource()==jb_clear){
			for(int i=0;i<jtf.length;i++)
				jtf[i].setText("");
			jtf_anz.setText("0");
			jtf_erg.setText("");
		}
	}
	private void printSolution(){
		Sol s=solutions.get(aktuelleSolution);
		for(int i=0;i<s.length();i++){
			jtf[i].setText(""+s.getVal(i));
		}
		jtf_anz.setText(""+(aktuelleSolution+1)+"/"+solutions.size());
		panel.repaint();
		
	}
	
	public void initialisiere(){
		for (int i=0;i<possibilities.length;i++){
			test[i]=possibilities[i];
		}
		solutions=new ArrayList<Sol>();
		aktuelleSolution=0;
		found=false;
		jb_fwd.setEnabled(false);
		jb_bwd.setEnabled(false);
	}
	public boolean berechne(){
		found=false;
	  for(int h=v[0].getStart();h<=v[0].getStopp();h++) {
		  if(!v[0].isFix()){
			  if(!test[h]) continue;
			  test[h]=false;
			  v[0].setValue(h);
			  jtf[0].setText(""+h);
		  }
		for (int i=v[1].getStart();i<=v[1].getStopp();i++){
			if(!v[1].isFix()) {
				if(!test[i] ) continue;
				test[i]=false;
				v[1].setValue(i);
				jtf[1].setText(""+i);
			}
			for (int j=v[2].getStart();j<=v[2].getStopp();j++){
				if(!v[2].isFix()){
					if(!test[j]) continue;
					test[j]=false;
					v[2].setValue(j);
					jtf[2].setText(""+j);
				}
				for(int k=v[3].getStart();k<=v[3].getStopp();k++){
					if(!v[3].isFix()){
						if(!test[k]) continue;
						test[k]=false;
						v[3].setValue(k);
						jtf[3].setText(""+k);
					}
					for(int l=v[4].getStart();l<=v[4].getStopp();l++){
						if(!v[4].isFix()){
							if(!test[l]) continue;
							test[l]=false;
							v[4].setValue(l);
							jtf[4].setText(""+l);
						}
						for(int m=v[5].getStart();m<=v[5].getStopp();m++) {
							if(!v[5].isFix()){
								if(!test[m]) continue;
								test[m]=false;
								v[5].setValue(m);
								jtf[5].setText(""+m);
							}
							for(int n=v[6].getStart();n<=v[6].getStopp();n++){
								if(!v[6].isFix()){
									if(!test[n]) continue;
									test[n]=false;
									v[6].setValue(n);
									jtf[6].setText(""+n);
								}
								for(int o=v[7].getStart();o<=v[7].getStopp();o++) {
									if(!v[7].isFix()){
										if(!test[o]) continue;
										test[o]=false;
										v[7].setValue(o);
										jtf[7].setText(""+o);
									}
									for(int p=v[8].getStart();p<=v[8].getStopp();p++){
										if(!v[8].isFix()){
											if(!test[p]) continue;
											test[p]=false;
											v[8].setValue(p);
											jtf[8].setText(""+p);
										}
										panel.repaint();
										if(evaluate()){
											found= true;
										}
										
										
										if(!v[8].isFix()) test[p]=true;
										
									}
									if(!v[7].isFix()) test[o]=true;
								}
								if(!v[6].isFix())test[n]=true;
							}
							if(!v[5].isFix())test[m]=true;
						}
						if(!v[4].isFix())test[l]=true;
					}
					if(!v[3].isFix())test[k]=true;	
						
				}
				if(!v[2].isFix())test[j]=true;
			}
			if(!v[1].isFix())test[i]=true;
		}
		if(!v[0].isFix())test[h]=true;
	}
	  return found;
  }
	public boolean evaluate(){
		boolean ret=false;
		double sum=v[0].getValue();
		for(int i=1;i<v.length;i++) {
			switch(operatoren[i-1]){
			case '+': sum+=v[i].getValue();break;
			case '-': sum-=v[i].getValue();break;
			case '*': sum*=v[i].getValue();break;
			case '/': 
				if(v[i].getValue()==0)
					return false;
				else
					sum/=v[i].getValue();
			}
		}
//		for(int i=0;i<v.length;i++){
//			System.out.print(v[i].getValue());
//			if(i<8)
//				System.out.print(operatoren[i]);
//		}
//		System.out.println("= "+sum);
//		System.out.println("= "+ergebnis);
		if(sum==ergebnis){ ret=true;
			Sol s=new Sol(9);
			for(int i=0;i<s.length();i++)
				s.setVal(i, v[i].getValue());
			solutions.add(s);
			jtf_anz.setText("1/"+solutions.size());
		}
		return ret;
		
	}
}

