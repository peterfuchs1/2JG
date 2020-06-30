package test5;
/**
 * 
 * @author wrafeiner
 * @version 1.0
 */
public class Vokabeln {
	private String gesucht; /* gesuchter Begriff */
	private String s1;   /* Loesungsangebot1 */
	private String s2;   /* Loesungsangebot2 */
	private String s3;   /* Loesungsangebot3 */
	private int loesung; /* korrekte Loesung [1,3] */
	/**
	 * Konstruktor
	 * @param gesucht gesuchter Begriff
	 * @param s1 Loesungsangebot1
	 * @param s2 Loesungsangebot2
	 * @param s3 Loesungsangebot3
	 * @param loesung korrekte Loesung [1,3]
	 */
	public Vokabeln(String gesucht, String s1, String s2, String s3, int loesung) {
		this.gesucht=gesucht;
		this.s1=s1;
		this.s2=s2;
		this.s3=s3;
		this.loesung=loesung;
	}
	/******* GETTER ***************/
	/**
	 * @return the gesucht
	 */
	public String getGesucht() {
		return gesucht;
	}
	/**
	 * @return the s1
	 */
	public String getS1() {
		return s1;
	}
	/**
	 * @return the s2
	 */
	public String getS2() {
		return s2;
	}
	/**
	 * @return the s3
	 */
	public String getS3() {
		return s3;
	}
	/**
	 * @return the loesung
	 */
	public int getLoesung() {
		return loesung;
	}
}
