package test2;


import java.util.Scanner;

public class Spielfeld {

	public static void main(String[] args) {
		char[][] sf=new char[6][7];
		for(int i=0;i<sf.length;++i) 
			for(int j=0;j<sf[i].length;++j) 
				sf[i][j]=' ';
		Scanner s=new Scanner(System.in);
		for(int i=0;i<5;++i) {
			int c=s.nextInt();
			for(int j=5;j>=0;j--) {
				if(sf[j][c]==' ') {
					sf[j][c]='X';
					break;
				}
			}
		}
	
		for(int i=0;i<sf.length;++i) {
			for(int j=0;j<sf[i].length;++j) {
				System.out.print(sf[i][j]);
			}
			System.out.println();
		}
	}

}
