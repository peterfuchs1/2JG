package grundrechnungsarten_neu2;



public class Berechnung {

	Berechnung(){
		String[] str={"+","*","-","/","+","*","-","/"}; // Operatoren
		int start=0; // STartwerte
		int stopp=15; // Stoppwerte
		new GUI(start,stopp,1,str);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Berechnung();
	}

}
