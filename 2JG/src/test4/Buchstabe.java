/**
 * 
 */
package test4;

/**
 * @author wrafeiner
 *
 */
public class Buchstabe {
	private char buchstabe;
	
	/**
	 * @param buchstabe
	 */
	public Buchstabe(char buchstabe) {
		this.buchstabe = buchstabe;
	}

	/**
	 * @return the buchstabe
	 */
	public char getBuchstabe() {
		return buchstabe;
	}

	/**
	 * @param buchstabe the buchstabe to set
	 */
	public void setBuchstabe(char buchstabe) {
		this.buchstabe = buchstabe;
	}
	public String buchstabenText() {
		return ""+this.buchstabe;
	}
}
