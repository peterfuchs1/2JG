package nost191;

public class TestRezept {

	public static void main(String[] args) {
		Rezept r=new Rezept(4);
		Zutat z1=new Zutat("Mehl", 0.5, "kg");
		r.hinzu(z1);
		r.hinzu("Eier", 4, "Stk");
		r.hinzu("Zucker", 150, "g");
		r.hinzu("Backpulver", 1, "Stk");
		System.out.println("Das Rezept laesst noch Zutaten zu? "+r.hinzu("Butter", 150, "g"));
		System.out.println(r.liste());
		r.loesche("Backpulver");
		
		r.aenderePersonen(8);
		System.out.println(r.liste());
	}

}
