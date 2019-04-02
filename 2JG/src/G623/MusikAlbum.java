package G623;

public class MusikAlbum {

	private String albumName;

	private String albumInterpret;

	private Musikstueck[] musikstuecke;

	public void MusikAlbum(String albumtitel, String albuminterpret, byte anzahlMusikstuecke) {
		this.musikstuecke=new Musikstueck[anzahlMusikstuecke];
		
		
	}
	public boolean addMusikstueck(String titel,String interpret) {
		return this.addMusikstueck(titel, interpret, 0);
	}
	public boolean addMusikstueck(String titel,String interpret,int dauer) {
		boolean added=false;
		for(int i=0;i<musikstuecke.length;++i) {
			if(this.musikstuecke[i]==null) {
				this.musikstuecke[i]=new Musikstueck(titel, interpret, dauer);
				added=true;
			}
		}
		return added;
	}
}
