package vererbung;

public class Test {

	public static void main(String[] args) {
		// Erstellen von Objekten der Klasse Person
		Person p1=new Person("Mayer", "Franz");
		Person p2=new Person("Weber", "Andrea");
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
		System.out.println("Person "+p1.toString());
		System.out.println("Person "+p2.toString());
		// Ausgabe aller Schueler
		for(i=0;i< schueler.length;i++){
			System.out.println("Schueler "+schueler[i].toString());
		}
		
		
	}

}
