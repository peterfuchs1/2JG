package arrays;

public class Arrays {

	public static void main(String[] args) {
		int[][] zahlen;
		zahlen = new int[3][5];
		int iZeile, iSpalte;
		for(iZeile = 0; iZeile < zahlen.length; iZeile++) {
		    for(iSpalte = 0; iSpalte < zahlen[iZeile].length; iSpalte++) {
		        zahlen[iZeile][iSpalte] = iZeile + iSpalte;
		    }
		}
		for(iZeile = 0; iZeile < zahlen.length; iZeile++) {
		    for(iSpalte = 0; iSpalte < zahlen[iZeile].length; iSpalte++) {
		        System.out.print(zahlen[iZeile][iSpalte] + ", ");
		    }
		    System.out.println();
		}

	}

}
