/**
 * 
 */
package array_resize;

import java.util.Arrays;

/**
 * @author Walter Rafeiner-Magor
 *
 */
public class DArray {
	private double[] feld;
	public static int SIZE=30;
	/**
	 * 
	 */
	public DArray() {
		feld=new double[SIZE];
		init();
	}
	public DArray(int size) {
		feld=new double[size];
		init();
	}
	/**
	 * @param feld
	 */
	public DArray(double[] feld) {
		this.feld = feld;
		init();
	}
	/**
	 * Initialisierung aller Elemente des Arrays
	 * mit dem Quadrat des jeweiligen Index
	 */
	private void init(){
		for(int i=0;i<feld.length;i++)
			feld[i]=i*i;
	}
	/**
	 * Fügt eine gewisse Anzahl an neuen Elementen zum Array hinzu
	 * @param elements
	 */
	public void add(int elements){
		double[] newFeld=new double[feld.length+elements];
		for(int i=0;i<feld.length;i++)
			newFeld[i]=feld[i];
		feld=newFeld;
		init();
	}
	/**
	 * Verkleinert das Arrays um die angegebene Anzahl von Elementen
	 * @param elements
	 */
	public void remove(int elements){
		elements=(elements>feld.length)?feld.length:elements;
		double[] newFeld=new double[feld.length-elements];
		newFeld=Arrays.copyOf(feld, feld.length-elements);
		feld=newFeld;
	}
	/**
	 * @return the feld
	 */
	public double[] getFeld() {
		return feld;
	}
	/**
	 * prints all values
	 */
	public void print(){
		print(feld.length);
	}
	/**
	 * print at maximum anzahl values
	 * @param anzahl
	 */
	public void print(int anzahl){
		if(anzahl<0)
			anzahl=0;
		if(anzahl>feld.length)
			anzahl=feld.length;
		for(int i=0;i<feld.length;i++)
			System.out.println("Feld["+i+"]="+feld[i]);
	}
	/**
	 * print values from start to ende
	 * return: if start is greater then ende 
	 * 	or ende is lower then zero
	 * 	or start is lower then zero 
	 * @param start
	 * @param ende
	 */
	public void print(int start, int ende){
		if(ende<0 ||start>ende || start<0)
			return;
		if(start>=feld.length)
			start=feld.length-1;
		if(ende>=feld.length)
			ende=feld.length-1;
		for(int i=start;i<=ende;i++)
			System.out.println("Feld["+i+"]="+feld[i]);
	}
	/**
	 * @param feld the feld to set
	 */
	public void setFeld(double[] feld) {
		this.feld = feld;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DArray a=new DArray(10);
		a.print();
		a.add(7);
		a.print();
		a.remove(8);
		a.print();
		a.print(4);
		a.print(4,5);
		a.print(-1,2);
		a.print(-2,-1);
	}

}
