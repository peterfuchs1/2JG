package arrays;

public class Arrays2 {

	public static void main(String[] args) {
		int[][] zahlenI = {{2, 7}, {5, 1, 9}, {3, 0, 6, 8}};
		for(int iZeile = 0; iZeile < zahlenI.length; iZeile++) {
		    for(int iSpalte = 0; iSpalte < zahlenI[iZeile].length; iSpalte++) {
		        System.out.print(zahlenI[iZeile][iSpalte] + ", ");
		    }
		    System.out.println();
		}

	}

}
