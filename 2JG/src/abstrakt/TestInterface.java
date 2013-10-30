package abstrakt;
public class TestInterface {

	public static void main(String[] args) {
		// Alle Schüler und Lehrer sind auch Personen!!!
		Printable[] printables= new Person[9];
		int i=0;		
		// Erstellen von Objekten der Klasse Lehrer
		printables[i++]= new Lehrer("Mayer", "Franz","MAYF","HEL");
		printables[i++]= new Lehrer("Weber", "Andrea","WEBA","HIT");
		// Erstellen von Objekten der Klasse Schueler
		printables[i++]= new Schueler("Eigner","Peter",4,"2aHIT");
		printables[i++]= new Schueler("Dame","Claudia",3,"2aHIT");
		printables[i++]= new Schueler("Franz","Patrizia",3,"1aHIT");
		printables[i++]= new Schueler("Berger","Mathias",1,"5bHITI");
		printables[i++]= new Schueler("Weber","Andreas",19,"5bHITI");
		printables[i++]= new Schueler("Mauerer","Anna",10,"5bHITI");
		printables[i]= new Schueler("Schmidt","Johannes",12,"5bHITI");
		// Ausgabe aller Schueler und Lehrer
		while(i>=0){
			printables[i--].print(Printable.NEUE_ZEILE);
		}	
	}
}
