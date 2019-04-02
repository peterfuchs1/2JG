package test3;

public class Projektmitarbeiter {
	private Mitarbeiter[] maListe;

	public Projektmitarbeiter(int max) {
		maListe = new Mitarbeiter[max];
	}

	public boolean hinzu(Mitarbeiter m) {
		boolean added = false;
		for (int i = 0; !added & i < maListe.length; ++i) {
			if (maListe[i] == null) {
				maListe[i] = m;
				added = true;
			}
		}
		return added;
	}

	public boolean hinzu(Mitarbeiter m, int i) {
		if (i >= this.maListe.length || this.maListe[i] != null)
			this.upgrade();
		if (this.maListe[i] != null) {
			for (int j = this.maListe.length - 1; j >= i; --j) {
				this.maListe[j] = this.maListe[j - 1];
			}
		}
		this.maListe[i] = m;
		return true;
	}

	public boolean hinzu(String name, double stunden) {
		return this.hinzu(new Mitarbeiter(name, stunden));
	}

	public void meeting(double stunden) {
		for (int i = 0; i < this.maListe.length; ++i) {
			if (this.maListe[i] != null) {
				this.maListe[i].arbeiten(stunden);
			}
		}
	}

	public double personenStunden() {
		double sum = 0.0;
		for (int i = 0; i < this.maListe.length; ++i) {
			if (this.maListe[i] != null) {
				sum += this.maListe[i].getStundenzahl();
			}
		}
		return sum;
	}

	public String toString() {
		String s = "";
		for (int i = 0; i < this.maListe.length; ++i) {
			if (this.maListe[i] != null) {
				s += "" + this.maListe[i].getName() + ": " + this.maListe[i].getStundenzahl() + "\n";
			}
		}
		return s;
	}

	private void upgrade() {
		int l = this.maListe.length + 1;
		Mitarbeiter[] neu = new Mitarbeiter[l];
		for (int i = 0; i < this.maListe.length; ++i) {
			neu[i] = maListe[i];
		}
		this.maListe = neu;
	}

	public static void main(String[] args) {
		Projektmitarbeiter pm = new Projektmitarbeiter(4);
		pm.hinzu("Franz Meier", 10);
		pm.hinzu("Franz Berger", 11);
		pm.hinzu("Beate Bauer", 12);
		System.out.println(pm.personenStunden());
		pm.meeting(10);
		System.out.println(pm.personenStunden());
		pm.hinzu(new Mitarbeiter("Weber Nicole", 20), 1);
		System.out.println(pm.toString());
	}

}
