package abstrakt;
//import static vererbung.Printable.*;
public class Test {

	public static void main(String[] args) {
		// Erstellen von Objekten der Klasse Person
		Person p1=new Lehrer("Mayer", "Franz","MAYF","HEL");
		Person p2=new Lehrer("Weber", "Andrea","WEBA","HIT");
		// Array mit Schuelern
		Schueler[] schueler=new Schueler[7];
		int i=0;
		// Erstellen von Objekten der Klasse Schueler
		schueler[i++]= new Schueler("Eigner","Peter",4,"2aHIT");
		schueler[i++]= new Schueler("Dame","Claudia",3,"2aHIT");
		schueler[i++]= new Schueler("Franz","Patrizia",3,"1aHIT");
		schueler[i++]= new Schueler("Berger","Mathias",1,"5bHITI");
		schueler[i++]= new Schueler("Weber","Andreas",19,"5bHITI");
		schueler[i++]= new Schueler("Mauerer","Anna",10,"5bHITI");
		schueler[i++]= new Schueler("Schmidt","Johannes",12,"5bHITI");
		// Ausgabe der Personen
		p1.print(Printable.NEUE_ZEILE);
		p2.print(true);
		// Ausgabe aller Schueler
		for(i=0;i< schueler.length;i++){
			schueler[i].print(true);
		}	
	}
}
