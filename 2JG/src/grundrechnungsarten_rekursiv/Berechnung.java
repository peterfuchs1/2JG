package grundrechnungsarten_rekursiv;

public class Berechnung {
	private GUI gui;
	Berechnung(){
		String[] str={"+","*","-","/","+","*","-","/"}; // Operatoren
		int start=0; // STartwerte
		int stopp=15; // Stoppwerte
		gui=new GUI(start,stopp,str);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Berechnung();
	}

}
