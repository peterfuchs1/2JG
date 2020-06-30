package test5;

public class Prophezeiung {
	private int[] compWuerfel;
	private int[] spielerTipp;
	private int wurf;
	
	public final static int MAX=20;

	public Prophezeiung() {
		init();
	}
	public void wuerfeln() {
		compWuerfel[wurf]=(int)(Math.random()*6)+1;
		if(wurf<=MAX) wurf++;
	}
	public int gewinnSumme() {
		int sum=0;
		for(int i=0;i<spielerTipp.length;++i) {
			if(compWuerfel[i]==spielerTipp[i]) {
				sum +=10+i*5;
			}
		}
		if(summeArray(compWuerfel)==summeArray(spielerTipp)) {
			sum += 10+summeArray(compWuerfel);
		}
		return sum;
		
	}
	private int summeArray(int[] a) {
		int sum=0;
		for(int i=0;i<a.length;++i)
			sum +=a[i];
		return sum;
	}
	public String gewinnText() {
		String ret="Du hast";
		boolean w=false;
			if(compWuerfel[0]==spielerTipp[0]) {
				w=true;
				ret = ret + " den 1. Würfel";
			}
			if(compWuerfel[1]==spielerTipp[1]) {
				if(w) ret += ", ";
				w=true;
				ret = ret + " den 2. Würfel";
			}
			if (summeArray(compWuerfel)==summeArray(spielerTipp)) {
				if(w) ret += " und ";
				ret = ret + " die Summe";
			}
		if( ret.equals("Du hast"))
			ret = ret +" leider nichts";
		ret += " RICHTIG prophezeit!";
		return ret;
	}
	/**
	 * @param spielerTipp the spielerTipp to set
	 */
	public void setSpielerTipp(int[] spielerTipp) {
		this.spielerTipp = spielerTipp;
	}
	public int getCompWuerfel(int index) {
		return this.compWuerfel[index];
		
	}
	public void init() {
		wurf=0;
		this.compWuerfel=new int[20];
		this.spielerTipp=new int[2];
	}
}
