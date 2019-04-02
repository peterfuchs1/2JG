package G621;

public class NumberSquare {

	private int[][] array;
	public static final int standard = 3;

	public NumberSquare() {
		this(NumberSquare.standard);
	}

	public NumberSquare(int zeilen) {
		if (zeilen < 1)
			throw new RuntimeException("Arrayindex muss groesser 0 sein!");
		array = new int[zeilen][zeilen];
	}

	public void setNumber(int zeile, int spalte, int value) {
		this.checkIndex(zeile);
		this.checkIndex(spalte);
		this.array[zeile][spalte] = value;
	}

	public boolean isMagicSquare() {
		int[] zeilen = new int[array.length];
		int[] spalten = new int[array.length];
		for (int i = 0; i < array.length; ++i) {
			for (int j = 0; j < array.length; ++j) {
				zeilen[i] += array[i][j];
				spalten[j] += array[i][j];
			}
		}
		boolean ret = NumberSquare.testSummen(zeilen);
		return ret & NumberSquare.testSummen(spalten);
	}

	private static boolean testSummen(int[] summen) {
		int value = summen[0];
		boolean ret = true;
		for (int i = 1; ret && i < summen.length; ++i) {
			ret = value == summen[i];
		}
		return ret;
	}

	public int getNumber(int zeile, int spalte) {
		this.checkIndex(zeile);
		this.checkIndex(spalte);
		return this.array[zeile][spalte];
	}

	public String stringForm() {
		int max = array.length;
		StringBuilder s = new StringBuilder();
		for (int i = 0; i < max; ++i) {
			for (int j = 0; j < max; ++j) {
				s.append(array[i][j]);
				if (j < max - 1)
					s.append(" ,");
			}
			s.append('\n');
		}
		return s.toString();
	}

	public void fillMagicSquare() {
		int n = array.length;
		if(n%2==0)
			if(n%4==0)
				fillDoubleEven(n);
			else
				fillSingleEven(n);
		else
			fillOdd(n);
	}
	/**
	 * fill Odd
	 * (c) https://rosettacode.org/wiki/Magic_squares_of_singly_even_order
	 * @param n (n%2!=0)
	 */
	private void fillOdd(int n) {
		
		int value = 0;
        int gridSize = n * n;
        int c = n / 2, r = 0;
 
        while (++value <= gridSize) {
            array[r][c] = value;
            if (r == 0) {
                if (c == n - 1) {
                    r++;
                } else {
                    r = n - 1;
                    c++;
                }
            } else if (c == n - 1) {
                r--;
                c = 0;
            } else if (array[r - 1][c + 1] == 0) {
                r--;
                c++;
            } else {
                r++;
            }
        }

	}
	/**
	 * fill Double Even
	 * (c) geeksforgeeks
	 * https://www.geeksforgeeks.org/magic-square-even-order/
	 * @param n size (n%4==0)
	 */
	private void fillDoubleEven(int n) {
	       int i, j; 
	       
	        // filling matrix with its count value  
	        // starting from 1; 
	        for ( i = 0; i < n; i++) 
	            for ( j = 0; j < n; j++) 
	                array[i][j] = (n*i) + j + 1; 
	        
	        // change value of Array elements 
	        // at fix location as per rule  
	        // (n*n+1)-arr[i][j] 
	        // Top Left corner of Matrix  
	        // (order (n/4)*(n/4)) 
	        for ( i = 0; i < n/4; i++) 
	            for ( j = 0; j < n/4; j++) 
	            	array[i][j] = (n*n + 1) - array[i][j]; 
	      
	        // Top Right corner of Matrix  
	        // (order (n/4)*(n/4)) 
	        for ( i = 0; i < n/4; i++) 
	            for ( j = 3 * (n/4); j < n; j++) 
	            	array[i][j] = (n*n + 1) - array[i][j]; 
	       
	        // Bottom Left corner of Matrix 
	        // (order (n/4)*(n/4)) 
	        for ( i = 3 * n/4; i < n; i++) 
	            for ( j = 0; j < n/4; j++) 
	            	array[i][j] = (n*n+1) - array[i][j]; 
	      
	        // Bottom Right corner of Matrix  
	        // (order (n/4)*(n/4)) 
	        for ( i = 3 * n/4; i < n; i++) 
	            for ( j = 3 * n/4; j < n; j++) 
	            	array[i][j] = (n*n + 1) - array[i][j]; 
	     
	        // Centre of Matrix (order (n/2)*(n/2)) 
	        for ( i = n/4; i < 3 * n/4; i++) 
	            for ( j = n/4; j < 3 * n/4; j++) 
	            	array[i][j] = (n*n + 1) - array[i][j]; 
	}
	/**
	 * fill Single Even
	 * (c) https://rosettacode.org/wiki/Magic_squares_of_singly_even_order
	 * @param n (n%2==0 && n%4!=0) 
	 */
	private void fillSingleEven(int n) {
	      int size = n * n;
	        int halfN = n / 2;
	        int subSquareSize = size / 4;
	 
	         fillOdd(halfN);
	        int[] quadrantFactors = {0, 2, 3, 1};
//	        int[][] result = new int[n][n];
	 
	        for (int r = 0; r < n; r++) {
	            for (int c = 0; c < n; c++) {
	                int quadrant = (r / halfN) * 2 + (c / halfN);
	                array[r][c] = array[r % halfN][c % halfN];
	                array[r][c] += quadrantFactors[quadrant] * subSquareSize;
	            }
	        }
	 
	        int nColsLeft = halfN / 2;
	        int nColsRight = nColsLeft - 1;
	 
	        for (int r = 0; r < halfN; r++)
	            for (int c = 0; c < n; c++) {
	                if (c < nColsLeft || c >= n - nColsRight
	                        || (c == nColsLeft && r == nColsLeft)) {
	 
	                    if (c == 0 && r == nColsLeft)
	                        continue;
	 
	                    int tmp = array[r][c];
	                    array[r][c] = array[r + halfN][c];
	                    array[r + halfN][c] = tmp;
	                }
	            }
	   
	}
	private void checkIndex(int zeile) {
		int max = array.length - 1;
		if (zeile < 0 || zeile > max)
			throw new RuntimeException("Arrayindex [" + zeile + "] sollte im Intervall [0," + max + "] liegen!");
	}
}
