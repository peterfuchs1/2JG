package test2;

public class Lernbueroblock {
	private Lernbuero[] lbListe;
	
	public Lernbueroblock(int maxLB) {
		this.lbListe=new Lernbuero[maxLB];
	}

	public boolean hinzu(Lernbuero lb) {
		boolean ret=false;
		for(int i=0;i<lbListe.length;++i) {
			if(lbListe[i]==null) {
				lbListe[i]=lb;
				ret=true;
				break;
			}
		}
		return ret;
	}
	public boolean hinzu(String bez, int maxSch) {
		return hinzu(new Lernbuero(bez, maxSch));
	}
	public void anmelden(String bez, int anm) {
		for(int i=0;i<lbListe.length;++i) {
			if(lbListe[i]!=null && 
					lbListe[i].getBezeichung().equals(bez)) {
				lbListe[i].anmelden(anm);
			}
		}
	}
	public void loeschen() {
		for(int i=0;i<lbListe.length;++i) {
			if(lbListe[i]!=null && lbListe[i].getAnmeldungen()==0) {
				lbListe[i]=null;
			}
		}
	}
}
