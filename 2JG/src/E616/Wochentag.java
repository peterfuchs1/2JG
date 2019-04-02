package E616;

public class Wochentag {
	public static String wochentagText(int tag) {
		String[] tage= {"Sonntag","Montag","Dienstag","Mittwoch","Donnerstag","Freitag","Samstag"};
		if (tag<0 || tag>6) throw new RuntimeException("Tag="+tag+" Es koennen nur Tage zwischen 0 und 6 ermittelt werden!");
		return tage[tag];
	}
	public static int datumsangabe (int tag, int monat, int jahr) {
		if(monat <= 2 ) {
			monat +=10;
			jahr--;
		}
		else
			monat -=2;
		int a= jahr/100;
		int b= jahr %100;
		int c = ((26*monat -2)/10+tag+b+b/4+a/4-2*a) % 7;
		if (c<0)
			c +=7;
		return c;
	}
	
	public static void main(String[] args) {
		int tag=6;
		int monat=12;
		int jahr=2018;
		int wt=Wochentag.datumsangabe(tag, monat, jahr);
		System.out.println("Sie haben folgendes Datum eingegeben: "+
		Wochentag.wochentagText(wt)+", "+tag+"."+monat+"."+jahr);

	}

}
