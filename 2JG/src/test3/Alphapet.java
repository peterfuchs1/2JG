package test3;

import java.util.Random;

public class Alphapet {
	private char[][] zeichen;

	public Alphapet() {
		zeichen = new char[2][26];
		Random r = new Random();
		char start2 = (char) ((r.nextInt(26))+'A');

		char start1 = 'A';
		for (int j = 0; j < 26; ++j) {
			zeichen[0][j] = start1++;
			if (start2 >= 'A' + 26)
				start2 -= 26;
			zeichen[1][j] = start2++;
		}
		for (int i = 0; i < 2; ++i) {
			for (int j = 0; j < 26; ++j) {
				System.out.print(zeichen[i][j]+" ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {
		Alphapet a=new Alphapet();
	}

}
