package vererbung;
public class TestInterface {

	public static void main(String[] args) {
		Printable[] printables= new Person[9];
		int i=0;		
		// Erstellen von Objekten der Klasse Person
		printables[i++]= new Person("Mayer", "Franz");
		printables[i++]= new Person("Weber", "Andrea");
		// Erstellen von Objekten der Klasse Schueler
		printables[i++]= new Schueler("Eigner","Peter",4,"2aHIT");
		printables[i++]= new Schueler("Dame","Claudia",3,"2aHIT");
		printables[i++]= new Schueler("Franz","Patrizia",3,"1aHIT");
		printables[i++]= new Schueler("Berger","Mathias",1,"5bHITI");
		printables[i++]= new Schueler("Weber","Andreas",19,"5bHITI");
		printables[i++]= new Schueler("Mauerer","Anna",10,"5bHITI");
		printables[i++]= new Schueler("Schmidt","Johannes",12,"5bHITI");
		// Ausgabe aller Personen und Schueler
		for(i=0;i< printables.length;i++){
			printables[i].print(Printable.WAHR);
		}	
	}
}
