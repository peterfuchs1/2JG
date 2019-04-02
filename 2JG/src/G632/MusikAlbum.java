package G632;

import G631.ArrayMethoden;

public class MusikAlbum {

	private String albumName;

	private String albumInterpret;

	private Musikstueck[] musikstuecke;
	/**
	 * Groesse des Musikalbums
	 * @return musikstuecke.length
	 */
	public int getLen() {
		return this.musikstuecke.length;
	}
	/**
	 * Ausgabe aller Musiktitel
	 */
	public String toString() {
		StringBuilder s=new StringBuilder();
		s.append("Das Musikalbum ").append(this.albumName)
		.append(" vom Interpreten ").append(this.albumInterpret)
		.append(" enthaelt ").append(this.musikstuecke.length)
		.append(" Musikstuecke\n");
		;
		for(int i=0;i<this.musikstuecke.length;++i) {
			s.append(this.musikstuecke[i].zeigeDaten());
			s.append('\n');
		}
		return s.toString();
	}

	
	/**
	 * Konstruktor
	 * 
	 * @param name
	 * @param interpret
	 */
	public MusikAlbum(String name, String interpret) {
		this.albumName=name;
		this.albumInterpret=interpret;
		this.musikstuecke=new Musikstueck[0];
	}
	/**
	 * Loescht einen Titel im Album
	 * @param position im Array (index)
	 * @return konnte der Titel geloescht werden?
	 */
	public boolean removeMusikstueck(int position) {
		
		int len=this.musikstuecke.length;
		if(position<0||position>len)
			throw new RuntimeException("Index"+position+ "ist im Array nicht vorhanden!");
		if (len==0) return false;
		if(position==len) return removeLastMusikstueck();
		this.musikstuecke[position]=null;
		for (int i=position;i<len-1;++i) 
			this.musikstuecke[i]=this.musikstuecke[i+1];
		this.musikstuecke=MusikAlbum.verkleinern(this.musikstuecke,	1);
		return true;
	}
	/**
	 * Loescht den letzten Titel
	 * @return war noch ein Titel vorhanden?
	 */
	public boolean removeLastMusikstueck() {
		int len=this.musikstuecke.length;
		if (len==0) return false;
		this.musikstuecke=MusikAlbum.verkleinern(this.musikstuecke,	1);
		return true;
	}
	/**
	 * Neues Musikstueck hinzufuegen
	 * 
	 * @param titel neuer Titel
	 * @param interpret neuer Interpret
	 */
	public void addMusikstueck(String titel,String interpret) {
		this.addMusikstueck(titel, interpret, 0);
	}
	/**
	 * Neues Musikstueck hinzufuegen
	 * 
	 * @param titel neuer Titel
	 * @param interpret neuer Interpret
	 * @param dauer Dauer des neuen Titels
	 */
	public void addMusikstueck(String titel,String interpret,int dauer) {
		int len=this.musikstuecke.length;
		this.musikstuecke=MusikAlbum.vergroessern(this.musikstuecke, 1);
		this.musikstuecke[len]=new Musikstueck(titel, interpret, dauer);
	}
	/**
	 * Diese Methode kopiert ein Array von ints.
	 * 
	 * @param quelle Ausgangs-Array
	 * @param ziel   Ziel-Array
	 * @return Ziel-Array
	 */
	private static Musikstueck[] kopiere(Musikstueck[] quelle, Musikstueck[] ziel) {
		if (quelle == null)
			throw new RuntimeException("Array1 ist null!");
		if (ziel == null)
			throw new RuntimeException("Array2 ist null!");
		int grenze=(ziel.length<quelle.length)?ziel.length:quelle.length;
		for (int i = 0; i < grenze; ++i)
			ziel[i] = quelle[i].clone(); // Achtung: Bitte ein geclontes Element verwenden!
		return ziel;
	}


	/**
	 * Vergroessert ein Array von ints
	 * @param quelle Ausgangs-Array
	 * @param erweitern Anzahl zusaetzlicher Elemente
	 * @return
	 */
	public static Musikstueck[] vergroessern(Musikstueck [] quelle, int erweitern){
		if(erweitern<0)
			throw new RuntimeException("Parameter zur Erweiterung["+erweitern+"] fehlerhaft!");
		int groesse=quelle.length+erweitern;
		Musikstueck[] ziel=new Musikstueck[groesse];
		return MusikAlbum.kopiere(quelle,ziel);
	}
	/**
	 * Verkleinert ein Array von ints
	 * @param quelle Ausgangs-Array
	 * @param erweitern Anzahl reduzierter Elemente
	 * @return
	 */
	public static Musikstueck[] verkleinern(Musikstueck [] quelle, int reduzieren){
		if(reduzieren<0||reduzieren>quelle.length)
			throw new RuntimeException("Parameter zur Erweiterung["+reduzieren+"] fehlerhaft!");
		int groesse=quelle.length-reduzieren;
		Musikstueck[] ziel=new Musikstueck[groesse];
		return MusikAlbum.kopiere(quelle,ziel);
	}
	/**
	 * Testet ein flexibles Musikalbum
	 * @param args
	 */
	public static void main(String[] args) {
		MusikAlbum ma = new MusikAlbum("Vier Jahreszeiten", "Vivaldi");
		System.out.println("Es werden 3 Musikstuecke hinzugefuegt:");
		ma.addMusikstueck("Winter 1", "Vivaldi 1", 182);
		ma.addMusikstueck("Winter 2", "Vivaldi 2", 105);
		ma.addMusikstueck("Winter 3", "Vivaldi 3", 112);
		System.out.println(ma.toString());
		System.out.println("Das letzte Musikstueck wird nun geloescht");
		ma.removeMusikstueck(ma.getLen()-1);
		System.out.println(ma.toString());
		System.out.println("Es werden 2 Musikstuecke hinzugefuegt:");
		ma.addMusikstueck("Sommer 1", "Vivaldi 3", 253);
		ma.addMusikstueck("Sommer 2", "Vivaldi 3", 258);
		System.out.println(ma.toString());
		System.out.println("Es wird das dritte Musikstueck geloescht:");
		ma.removeMusikstueck(2);
		System.out.println(ma.toString());
	}

}
