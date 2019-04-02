package datum;

import java.time.*;

import javax.swing.JOptionPane;

public class Datum {

	public static void main(String[] args) {
		LocalDate d=LocalDate.now();
		LocalTime t=LocalTime.now();
		System.out.println("Datum: "+d.toString()+
				"\nZeit: "+t.toString());
		LocalDate d2=LocalDate.of(2000, 2, 29);
		System.out.println(d2.toString());
		LocalTime t2=LocalTime.of(5, 55, 5);
		System.out.println(t2.toString());
		Period p=d.until(d2);
		System.out.println("Periode zwischen Datum1 und Datum2: \n"+
		p.toString());
		String part, str=JOptionPane.showInputDialog("Bitte etwas eingeben");
		System.out.println(str.substring(1, 4));

	}

}
