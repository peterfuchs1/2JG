package arrays;

public class Testklasse {
	public static void main(String[] args) {
		Kartenhand hand1 = new Kartenhand(4);
		hand1.nimmKarte(new Spielkarte("Karo", 1));
		hand1.nimmKarte(new Spielkarte("Pik", 7));
		System.out.println("1. " + hand1.textDarstellung());
		Kartenhand hand2 = hand1.clone();
		System.out.println("2. " + hand2.textDarstellung());
		System.out.println("1. Hand gleich 2. Hand? " + hand1.equals(hand2));
		hand1.legeKarteAb(new Spielkarte("Pik", 7));
		hand1.getKarte(0).setWert(11);
		hand1.getKarte(0).setFarbe("Kreuz");
		System.out.println("1. " + hand1.textDarstellung());
		System.out.println("2. " + hand2.textDarstellung());
		System.out.println("1. Hand gleich 2. Hand? " + hand1.equals(hand2));
	}
}
