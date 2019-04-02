package bruch;

public class Bruchrechnen {

	public static void main(String[] args) {
		Bruchzahl zahl1;
		zahl1 = new Bruchzahl();
		Bruchzahl zahl2 = new Bruchzahl(3, 4);
		System.out.println("Bruchzahl1 (Konstruktor ohne Parameter): " + zahl1.textForm());
		System.out.println("Bruchzahl2 (Konstruktor mit Parameter 3 und 4): " + zahl2.textForm());
		zahl1.setZaehler(0);
		zahl1.setNenner(7);
		double dezimal = zahl1.dezimalWert();
		System.out.println("Der Dezimalwert von " + zahl1.textForm() + " betraegt " + dezimal);
		zahl2.erweitern(2);
		System.out.println(zahl2.textForm()+" mit 2 erweitert: " + zahl2.textForm());
		zahl2.kuerzen();
		System.out.println("Bruchzahl1: " + zahl1.textForm());
		System.out.println(zahl2.textForm()+" gekürzt: " + zahl2.textForm());
		Bruchzahl zahl3=zahl1.addiere(zahl2);
		System.out.println(zahl1.textForm()+" + "+zahl2.textForm()+" : " + zahl3.textForm());
		Bruchzahl zahl4=zahl1.subtrahiere(zahl2);
		System.out.println(zahl1.textForm()+" - "+zahl2.textForm()+" : " + zahl4.textForm());
		Bruchzahl zahl5=zahl1.multipliziere(zahl2);
		System.out.println(zahl1.textForm()+" * "+zahl2.textForm()+" : " + zahl5.textForm());
		Bruchzahl zahl6=zahl2.dividiere(zahl1);
		System.out.println(zahl2.textForm()+" / "+zahl1.textForm()+" : " + zahl6.textForm());
		Bruchzahl zahl7=zahl1.invertiere();
		System.out.println(zahl2.textForm()+" invertiert: " + zahl7.textForm());
		int hochzahl=2;
		Bruchzahl zahl8=zahl2.potenziere(hochzahl);
		System.out.println(zahl2.textForm()+" potenziert mit "+hochzahl+": " + zahl8.textForm());
		hochzahl=-2;
		zahl8=zahl2.potenziere(hochzahl);
		System.out.println(zahl2.textForm()+" potenziert mit "+hochzahl+": " + zahl8.textForm());
		hochzahl=0;
		zahl8=zahl2.potenziere(hochzahl);
		System.out.println(zahl2.textForm()+" potenziert mit "+hochzahl+": " + zahl8.textForm());


	}

}
