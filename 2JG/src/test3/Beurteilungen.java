package test3;

import java.util.Scanner;

public class Beurteilungen {
	private char[][] b;
	public Beurteilungen(int anzahl) {
		b=new char[anzahl][];
	}
	public void hinzu(int index, char value) {
		if(b[index]==null) {
			b[index]=new char[1];
			b[index][0]=value;
		}
		else {
			b[index]=upgrade(b[index]);
			b[index][b[index].length-1]=value;
		}
	}
	public char[] upgrade(char[] schueler) {
		char[] neu=new char[schueler.length+1];
		for(int i=0;i<schueler.length;++i) {
			neu[i]=schueler[i];
		}
		return neu;
		
	}
	public String toString() {
		String s="";
		for(int i=0;i<this.b.length;++i) {
			for(int j=0;this.b[i]!=null&&j<this.b[i].length;++j) {
				s+=b[i][j];
			}
			s += '\n';
		}
		return s;
	}
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("Bitte die Anzahl der Schueler eingeben: ");
		int anz=s.nextInt();
		Beurteilungen b=new Beurteilungen(anz);

		b.hinzu(0,'+');
		b.hinzu(0,'~');
		b.hinzu(1,'-');
		b.hinzu(1,'-');
		b.hinzu(1,'-');
		b.hinzu(2,'-');
		b.hinzu(2,'+');
		System.out.println(b.toString());
		
				
				
		
		
		

	}

}
