package grundrechnungsarten;

public class Berechnung {
	Berechnung(){
		String[] str={"+","*","-","/","+","*","-","/"}; // Operatoren
		int start=0; // STartwerte
		int stopp=20; // Stoppwerte
		new GUI(start,stopp,str);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Berechnung();
	}

}
