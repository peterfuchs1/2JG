package nost191;

public class Rezept {
	private Zutat[] zutaten;
	private int personen;
	/**
	 * 
	 */
	public Rezept(int anzahl) {
		zutaten=new Zutat[anzahl];
		this.personen=1;
	}
	public boolean hinzu(Zutat z) {
		boolean ret=false;
		for(int i=0;i<this.zutaten.length;++i) {
			if(zutaten[i]==null) {
				zutaten[i]=z;
				ret=true;
				break;
			}
		}
		return ret;
	}
	public boolean hinzu(String name, double menge, String einheit) {
		return hinzu(new Zutat(name,menge,einheit));
	}
	public void aenderePersonen(int p) {
		int faktor=p/this.personen;
		for(int i=0;i<this.zutaten.length;++i) {
			if(zutaten[i]!=null) {
				zutaten[i].skalieren(faktor);
			}
		}
		this.personen=p;
	}
	public boolean loesche(String n) {
		boolean ret=false;
		for(int i=0;i<this.zutaten.length;++i) {
			if(zutaten[i].getName().equals(n)) {
				zutaten[i]=null;
				ret=true;
				break;
			}
		}
		return ret;
	}
	public String liste() {
		String ret="";
		for(int i=0;i<this.zutaten.length;++i) {
			if(zutaten[i]!=null){
				ret += zutaten[i].eintrag();
				if(i+1<this.zutaten.length)
					ret +=";";
			}
		}
		return ret;
	}
}
